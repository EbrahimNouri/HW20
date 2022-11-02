import ir.hospital.entity.*;
import ir.hospital.service.clinicService.ClinicServiceImpl;
import ir.hospital.service.doctorService.DoctorServiceImpl;
import ir.hospital.service.patientService.PatientServiceImpl;
import ir.hospital.service.prescriptionService.PrescriptionServiceImpl;
import ir.hospital.service.queuingService.QueuingServiceImpl;
import ir.hospital.service.secretaryService.SecretaryServiceImpl;
import ir.hospital.utility.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SecretaryTest {


    private static final PatientServiceImpl PATIENT_SERVICE = ApplicationContext.getPATIENT_SERVICE();
    private static final ClinicServiceImpl CLINIC_SERVICE = ApplicationContext.getCLINIC_SERVICE();
    private static final DoctorServiceImpl DOCTOR_SERVICE = ApplicationContext.getDOCTOR_SERVICE();
    private static final PrescriptionServiceImpl PRESCRIPTION_SERVICE = ApplicationContext.getPRESCRIPTION_SERVICE();
    private static final QueuingServiceImpl QUEUING_SERVICE = ApplicationContext.getQUEUING_SERVICE();
    private static final SecretaryServiceImpl SECRETARY_SERVICE = ApplicationContext.getSECRETARY_SERVICE();

    private static Secretary secretary;


    @BeforeAll
    static void initialize() {
        Patient patient = new Patient("test", "ftest", "1234567890", "12345678"
                , "12345678901", "fellan ja", null, null, null, null);

        Clinic clinic = Clinic.builder().name("sina").build();

        Doctor doctor = Doctor.builder().employeeNumber("12345678").nationalCode("1234566789").password("12345678").specialtyType(SpecialtyType.EMERGENCY)
                .firstname("ali").clinic(clinic).build();

        Prescription prescription = new Prescription(null, doctor, patient, "anfulaanza", "estaminofen every 8H"
                , LocalDate.now());
        Queuing queuing = new Queuing(null, LocalDate.of(2022, 12, 9), LocalDateType.MORNING
                , QueuingCheck.RESERVED, doctor, patient);

        secretary = new Secretary("ava", "sadehgzade", "1234567789", "12345678"

                , "09120000000", "tehran", null, clinic);
        Set<Prescription> prescriptions = new HashSet<>();
        prescriptions.add(prescription);


        patient.setPrescriptions(prescriptions);
        patient.setClinic(clinic);

        CLINIC_SERVICE.save(clinic);
        DOCTOR_SERVICE.save(doctor);
        PATIENT_SERVICE.save(patient);
        PRESCRIPTION_SERVICE.save(prescription);
        QUEUING_SERVICE.save(queuing);
        SECRETARY_SERVICE.save(secretary);



    }

    @Test
    void showAllData(){
        Assertions.assertEquals("1234567890", SECRETARY_SERVICE.ShowAllData(secretary).getPatients().get(0)
                .getNationalCode());

        Assertions.assertEquals("12345678", SECRETARY_SERVICE.ShowAllData(secretary).getDoctors().get(0)
                .getEmployeeNumber());

        Assertions.assertEquals("estaminofen every 8H", SECRETARY_SERVICE.ShowAllData(secretary).getPatients().get(0)
                .getPrescriptions().stream().toList().get(0).getDescription());
    }
}
