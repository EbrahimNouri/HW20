import ir.hospital.entity.Clinic;
import ir.hospital.entity.Doctor;
import ir.hospital.entity.SpecialtyType;
import ir.hospital.utility.ApplicationContext;
import org.junit.jupiter.api.*;

public class ClinicTest {
    private static Clinic clinic;
    private static Doctor doctor;


    @BeforeAll
    static void initialize() {

        clinic = Clinic.builder().name("sina").build();
        doctor = Doctor.builder().employeeNumber("12345678").specialtyType(SpecialtyType.EMERGENCY)
                .firstname("ali").clinic(clinic).build();
    }

    @BeforeEach
    void addToDb() {
        ApplicationContext.getCLINIC_SERVICE().save(clinic);
        ApplicationContext.getDOCTOR_SERVICE().save(doctor);
    }

    @Test
    void getAllClinicCheckGetDoctors() {
        Assertions.assertEquals(1, ApplicationContext.getCLINIC_SERVICE().clinics().get(0).getDoctors().size());
    }


    @Test
    void getAllClinicCheckGetDoctorsByEmployeeNumber() {
        Assertions.assertTrue(ApplicationContext.getCLINIC_SERVICE().clinics()
                .get(0).getDoctors().stream().anyMatch((doctor1) -> doctor1.getEmployeeNumber()
                        .equals(doctor.getEmployeeNumber())));
    }


    @AfterAll
    static void setNullVariables(){
        ApplicationContext.getCLINIC_SERVICE().delete(clinic);
        ApplicationContext.getDOCTOR_SERVICE().delete(doctor);
        doctor = null;
        clinic = null;
    }

}
