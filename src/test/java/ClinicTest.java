import ir.hospital.entity.Clinic;
import ir.hospital.entity.Doctor;
import ir.hospital.entity.SpecialtyType;
import ir.hospital.service.clinicService.ClinicServiceImpl;
import ir.hospital.service.doctorService.DoctorServiceImpl;
import ir.hospital.utility.ApplicationContext;
import org.junit.jupiter.api.*;

public class ClinicTest {

    ClinicServiceImpl clinicService = ApplicationContext.getCLINIC_SERVICE();
    DoctorServiceImpl doctorService = ApplicationContext.getDOCTOR_SERVICE();
    private static Clinic clinic;
    private static Doctor doctor;


    @BeforeAll
    static void initialize() {

        clinic = Clinic.builder().name("sina").build();
        doctor = Doctor.builder().employeeNumber("12345678").specialtyType(SpecialtyType.EMERGENCY)
                .firstname("ali").nationalCode("1223456789").password("12345678").clinic(clinic).build();
    }

    @BeforeEach
    void addToDb() {
        clinicService.save(clinic);
        doctorService.save(doctor);
    }

    @Test
    void getAllClinicCheckGetDoctors() {
        Assertions.assertEquals(1, clinicService.clinics().get(0).getDoctors().size());
    }


    @Test
    void getAllClinicCheckGetDoctorsByEmployeeNumber() {
        Assertions.assertTrue(clinicService.clinics()
                .get(0).getDoctors().stream().anyMatch((doctor1) -> doctor1.getEmployeeNumber()
                        .equals(doctor.getEmployeeNumber())));
    }

}
