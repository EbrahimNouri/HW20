package ir.hospital.service.patientService;

import ir.hospital.dto.*;
import ir.hospital.entity.*;
import ir.hospital.repository.patientRepository.PatientRepositoryImpl;
import ir.hospital.repository.prescriptionRepository.PrescriptionRepositoryImpl;
import ir.hospital.repository.queuingRepository.QueuingRepositoryImpl;
import ir.hospital.service.clinicService.ClinicServiceImpl;
import ir.hospital.utility.ApplicationContext;
import ir.hospital.utility.SessionFactoryProvider;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService {

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
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException("don't saved");
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
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
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
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Patient findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return PATIENT_REPOSITORY.findById(session, id).orElseThrow();
        }
    }

    @Override
    public void delete(Patient patient) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.getTransaction().begin();
            try {
                PATIENT_REPOSITORY.delete(session, patient);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Patient findByNc(String nationalCode) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return PATIENT_REPOSITORY.findByNc(session, nationalCode).orElseThrow();
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
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public boolean isExist(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return PATIENT_REPOSITORY.isExist(session, id);
        }
    }


    private List<DiseaseRecordsDto> diseaseRecords(Long patientId) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return PRESCRIPTION_REPOSITORY.findByPatientId(session, patientId).orElseThrow().stream()
                    .map(this::createDiseaseRecordsDto).toList();
        }
    }

    private DiseaseRecordsDto createDiseaseRecordsDto(Prescription prescription) {
        return DiseaseRecordsDto.builder().description(prescription.getDescription())
                .localDate(prescription.getLocalDate()).ClinicName(prescription.getDoctor().getClinic().getName())
                .DrName(prescription.getDoctor().getFirstname() + " " + prescription.getDoctor().getLastname()).build();
    }

    @Override
    public PatientDto patientGetDtoInfo(Patient patient) {
        return new PatientDto(patient.getFirstname(), patient.getLastname()
                , patient.getNationalCode(), patient.getPhoneNumber()
                , patient.getAddress(), diseaseRecords(patient.getId()));
    }

    @Override
    public List<ClinicDto> getClinicDtoInfo() {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return CLINIC_SERVICE.clinics().stream().map(this::createClinicDto).toList();
        }
    }

    private ClinicDto createClinicDto(Clinic clinic){

        return new ClinicDto(clinic.getName(), clinic.getAddress()
                , clinic.getDoctors().stream().map(this::createDrTdo).toList());
    }


    private DoctorDto createDrTdo(Doctor doctor){
        return DoctorDto.builder()
                .firstname(doctor.getFirstname())
                .lastname(doctor.getLastname())
                .specialtyType(doctor.getSpecialtyType())
                .dateReserves(createDateReservedDto())
                .build();
    }

    private Map<LocalDate, LocalDateType> createDateReservedDto(){
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return new HashMap<>(QUEUING_REPOSITORY.getAllAfterNow(session).stream()
                    .collect(Collectors.toMap(Queuing::getLocalDate, Queuing::getLocalDateType)));
        }
    }
}
