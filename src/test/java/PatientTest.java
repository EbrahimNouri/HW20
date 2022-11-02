import ir.hospital.entity.*;
import ir.hospital.service.clinicService.ClinicServiceImpl;
import ir.hospital.service.doctorService.DoctorServiceImpl;
import ir.hospital.service.patientService.PatientServiceImpl;
import ir.hospital.service.prescriptionService.PrescriptionServiceImpl;
import ir.hospital.service.queuingService.QueuingServiceImpl;
import ir.hospital.utility.ApplicationContext;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PatientTest {

    private static final PatientServiceImpl PATIENT_SERVICE = ApplicationContext.getPATIENT_SERVICE();
    private static final ClinicServiceImpl CLINIC_SERVICE = ApplicationContext.getCLINIC_SERVICE();
    private static final DoctorServiceImpl DOCTOR_SERVICE = ApplicationContext.getDOCTOR_SERVICE();
    private static final PrescriptionServiceImpl PRESCRIPTION_SERVICE = ApplicationContext.getPRESCRIPTION_SERVICE();
    private static final QueuingServiceImpl QUEUING_SERVICE = ApplicationContext.getQUEUING_SERVICE();

    private static Patient patient;
    private static Doctor doctor;


    @BeforeAll
    static void initialize() {
        patient = new Patient("test", "ftest", "1234567890", "12345678"
                , "12345678901", "fellan ja", null, null, null, null);

        Clinic clinic = Clinic.builder().name("sina").build();

        doctor = Doctor.builder().employeeNumber("12345678").nationalCode("1234456789").password("12345678").specialtyType(SpecialtyType.EMERGENCY).nationalCode("1234567889")
                .firstname("ali").clinic(clinic).build();

        Prescription prescription = new Prescription(null, doctor, patient, "anfulaanza", "estaminofen every 8H", LocalDate.now());
        Queuing queuing = new Queuing(null, LocalDate.of(2022, 12, 9), LocalDateType.MORNING, QueuingCheck.RESERVED, doctor, patient);
        Set<Prescription> prescriptions = new HashSet<>();
        prescriptions.add(prescription);
        patient.setClinic(clinic);
        patient.setPrescriptions(prescriptions);

        CLINIC_SERVICE.save(clinic);
        DOCTOR_SERVICE.save(doctor);
        PATIENT_SERVICE.save(patient);
        PRESCRIPTION_SERVICE.save(prescription);
        QUEUING_SERVICE.save(queuing);



    }



    @Test
    void PatientChooseClinic() {

        Assertions.assertEquals(1, ApplicationContext.getCLINIC_SERVICE().clinics().get(0).getDoctors().size());
    }


    @Test
    void getAllClinicCheckGetDoctorsByEmployeeNumber() {
        Assertions.assertTrue(ApplicationContext.getCLINIC_SERVICE().clinics()
                .get(0).getDoctors().stream().anyMatch((doctor1) -> doctor1.getEmployeeNumber()
                        .equals(doctor.getEmployeeNumber())));
    }

    @Test
    void getAllPatientData() {
        Assertions.assertNotNull(PATIENT_SERVICE.patientGetDtoInfo(patient).getFirstname());
        Assertions.assertNotNull(PATIENT_SERVICE.patientGetDtoInfo(patient).getDiseaseRecordsDtos().get(0));
        Assertions.assertNotNull(PATIENT_SERVICE.patientGetDtoInfo(patient).getPhoneNumber());
        Assertions.assertNotNull(PATIENT_SERVICE.patientGetDtoInfo(patient).getAddress());
    }

    @Test
    void getClinicInfo(){
        Assertions.assertEquals("sina", PATIENT_SERVICE.getClinicDtoInfo().get(0).getClinicName());

        Assertions.assertEquals("ali", PATIENT_SERVICE.getClinicDtoInfo().get(0).getDoctorDtos()
                .get(0).getFirstname());

        Assertions.assertEquals(LocalDateType.MORNING, PATIENT_SERVICE.getClinicDtoInfo().get(0).getDoctorDtos()
                .get(0).getDateReserves().get(LocalDate.of(2022, 12, 9)));

    }

    @Test
    void getQueuing(){
        Queuing queuing1 = new Queuing(null,LocalDate.of(2022, 12, 9)
                , LocalDateType.MORNING,QueuingCheck.RESERVED, doctor, Patient.builder()
                .nationalCode("123456799").password("12345678").build() );
        Assertions.assertFalse(QUEUING_SERVICE.checkQueuing(queuing1));
    }



}
