package ir.hospital.service.patientService;

import ir.hospital.dto.*;
import ir.hospital.entity.*;
import ir.hospital.repository.patientRepository.PatientRepositoryImpl;
import ir.hospital.repository.prescriptionRepository.PrescriptionRepositoryImpl;
import ir.hospital.repository.queuingRepository.QueuingRepositoryImpl;
import ir.hospital.service.clinicService.ClinicServiceImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LogManager.getLogger(PatientServiceImpl.class);

    private final PatientRepositoryImpl PATIENT_REPOSITORY = ApplicationContext.getPATIENT_REPOSITORY();
    private final QueuingRepositoryImpl QUEUING_REPOSITORY = ApplicationContext.getQUEUING_REPOSITORY();
    private final PrescriptionRepositoryImpl PRESCRIPTION_REPOSITORY = ApplicationContext.getPRESCRIPTION_REPOSITORY();

    private final ClinicServiceImpl CLINIC_SERVICE = ApplicationContext.getCLINIC_SERVICE();


    @Override
    public void save(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PATIENT_REPOSITORY.save(session, patient);
                session.getTransaction().commit();
                LOGGER.debug("saved {} ", patient);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("can't save {} ", patient, e);
            }
        }
    }


    @Override
    public void saveOrUpdate(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PATIENT_REPOSITORY.saveOrUpdate(session, patient);
                session.getTransaction().commit();
                LOGGER.debug("saved {} ", patient);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("can't saved or updated {} ", patient);
            }
        }
    }

    @Override
    public void update(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PATIENT_REPOSITORY.update(session, patient);
                session.getTransaction().commit();
                LOGGER.debug("updated {} ", patient);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("can't update {} ", patient, e);
            }
        }
    }

    @Override
    public Patient findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("find by id {} ", id);
                return PATIENT_REPOSITORY.findById(session, id).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("can't find by id {} ", id, e);
                return null;
            }
        }
    }

    @Override
    public void delete(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PATIENT_REPOSITORY.delete(session, patient);
                session.getTransaction().commit();
                LOGGER.debug("deleted {} ", patient);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("can't delete {} ", patient, e);
            }
        }
    }

    @Override
    public Patient findByNc(String nationalCode) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("saved {} ", nationalCode);
                return PATIENT_REPOSITORY.findByNc(session, nationalCode).orElseThrow();
            } catch (Exception e) {
                LOGGER.error("can't find by national code {} ", nationalCode, e);
                return null;
            }
        }
    }

    @Override
    public void addPatient(String nationalCode, String password) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PATIENT_REPOSITORY.save(session, Patient.builder()
                        .nationalCode(nationalCode)
                        .password(password).build());
                session.getTransaction().commit();
                LOGGER.debug("patient added {}::{} ", nationalCode, password);
            } catch (Exception e) {
                session.getTransaction().rollback();
                LOGGER.error("can't add patient by national code and string {}::{} ", nationalCode, password, e);
            }
        }
    }

    @Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("is exist {} ", id);
                return PATIENT_REPOSITORY.isExist(session, id);
            } catch (Exception e) {
                LOGGER.error("can't run is exist {} ", id, e);
                return false;
            }

        }
    }


    private List<DiseaseRecordsDto> diseaseRecords(Long patientId) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("disease Record dto {} ", patientId);
                return PRESCRIPTION_REPOSITORY.findByPatientId(session, patientId).orElseThrow().stream()
                        .map(this::createDiseaseRecordsDto).toList();
            } catch (Exception e) {
                LOGGER.error("error disease record {} ", patientId, e);
                return null;
            }
        }
    }

    private DiseaseRecordsDto createDiseaseRecordsDto(Prescription prescription) {
        try {
            LOGGER.debug("created disease record dto {}", prescription);
            return DiseaseRecordsDto.builder().description(prescription.getDescription())
                    .localDate(prescription.getLocalDate()).ClinicName(prescription.getDoctor().getClinic().getName())
                    .DrName(prescription.getDoctor().getFirstname() + " " + prescription.getDoctor().getLastname()).build();
        } catch (Exception e) {
            LOGGER.error("error create disease record dto {} ", prescription, e);
            return null;
        }
    }

    @Override
    public PatientDto patientGetDtoInfo(Patient patient) {
        try {
            LOGGER.debug("patient get dto info run {} ", patient);
            return new PatientDto(patient.getFirstname(), patient.getLastname()
                    , patient.getNationalCode(), patient.getPhoneNumber()
                    , patient.getAddress(), diseaseRecords(patient.getId()));
        } catch (Exception e) {
            LOGGER.error("error patient get dto info {} ", patient, e);
            return null;
        }
    }

    @Override
    public List<ClinicDto> getClinicDtoInfo() {
            try {
                LOGGER.debug("get clinic dto info");
                return CLINIC_SERVICE.clinics().stream().map(this::createClinicDto).toList();
            } catch (Exception e) {
                LOGGER.error("error get clinic dto info", e);
                return null;
            }

    }

    private ClinicDto createClinicDto(Clinic clinic) {
        try {
            LOGGER.debug("created create clinic dto {}", clinic);
            return new ClinicDto(clinic.getName(), clinic.getAddress()
                    , clinic.getDoctors().stream().map(this::createDrTdo).toList());
        } catch (Exception e) {
            LOGGER.error("error reate clinic dto {} ", clinic, e);
            return null;
        }
    }


    private DoctorDto createDrTdo(Doctor doctor) {
        try {
            LOGGER.debug("create dr dto {} ", doctor);
            return DoctorDto.builder()
                    .firstname(doctor.getFirstname())
                    .lastname(doctor.getLastname())
                    .specialtyType(doctor.getSpecialtyType())
                    .dateReserves(createDateReservedDto())
                    .build();

        } catch (Exception e) {
            LOGGER.error("error create doctor dto {}", doctor, e);
            return null;
        }
    }

    private Map<LocalDate, LocalDateType> createDateReservedDto() {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            try {
                LOGGER.debug("date reserved show");
                return new HashMap<>(QUEUING_REPOSITORY.getAllAfterNow(session).stream()
                        .collect(Collectors.toMap(Queuing::getLocalDate, Queuing::getLocalDateType)));
            } catch (Exception e) {
                LOGGER.error("error dates reserved show ", e);
                return null;
            }
        }
    }
}

