package ir.hospital.utility;

import ir.hospital.repository.clinicRepository.ClinicRepositoryImpl;
import ir.hospital.repository.doctorRepository.DoctorRepositoryImpl;
import ir.hospital.repository.patientRepository.PatientRepositoryImpl;
import ir.hospital.repository.prescriptionRepository.PrescriptionRepositoryImpl;
import ir.hospital.repository.queuingRepository.QueuingRepositoryImpl;
import ir.hospital.repository.secretaryRepository.SecretaryRepositoryImpl;
import ir.hospital.service.clinicService.ClinicServiceImpl;
import ir.hospital.service.doctorService.DoctorServiceImpl;
import ir.hospital.service.patientService.PatientServiceImpl;
import ir.hospital.service.prescriptionService.PrescriptionServiceImpl;
import ir.hospital.service.queuingService.QueuingServiceImpl;
import ir.hospital.service.secretaryService.SecretaryServiceImpl;

public class ApplicationContext {

    private ApplicationContext() {}


    private static final ClinicRepositoryImpl CLINIC_REPOSITORY = new ClinicRepositoryImpl();
    private static final DoctorRepositoryImpl DOCTOR_REPOSITORY = new DoctorRepositoryImpl();
    private static final PatientRepositoryImpl PATIENT_REPOSITORY = new PatientRepositoryImpl() ;
    private static final PrescriptionRepositoryImpl PRESCRIPTION_REPOSITORY = new PrescriptionRepositoryImpl();
    private static final QueuingRepositoryImpl QUEUING_REPOSITORY = new QueuingRepositoryImpl();
    private static final SecretaryRepositoryImpl SECRETARY_REPOSITORY = new SecretaryRepositoryImpl();


    private static final ClinicServiceImpl CLINIC_SERVICE = new ClinicServiceImpl();
    private static final DoctorServiceImpl DOCTOR_SERVICE = new DoctorServiceImpl();
    private static final PatientServiceImpl PATIENT_SERVICE = new PatientServiceImpl();
    private static final PrescriptionServiceImpl PRESCRIPTION_SERVICE = new PrescriptionServiceImpl();
    private static final QueuingServiceImpl QUEUING_SERVICE = new QueuingServiceImpl();
    private static final SecretaryServiceImpl SECRETARY_SERVICE = new SecretaryServiceImpl();



    public static ClinicRepositoryImpl getCLINIC_REPOSITORY() {
        return CLINIC_REPOSITORY;
    }

    public static DoctorRepositoryImpl getDOCTOR_REPOSITORY() {
        return DOCTOR_REPOSITORY;
    }

    public static PatientRepositoryImpl getPATIENT_REPOSITORY() {
        return PATIENT_REPOSITORY;
    }

    public static PrescriptionRepositoryImpl getPRESCRIPTION_REPOSITORY() {
        return PRESCRIPTION_REPOSITORY;
    }

    public static QueuingRepositoryImpl getQUEUING_REPOSITORY() {
        return QUEUING_REPOSITORY;
    }

    public static SecretaryRepositoryImpl getSECRETARY_REPOSITORY() {
        return SECRETARY_REPOSITORY;
    }



    public static ClinicServiceImpl getCLINIC_SERVICE() {
        return CLINIC_SERVICE;
    }

    public static DoctorServiceImpl getDOCTOR_SERVICE() {
        return DOCTOR_SERVICE;
    }

    public static PatientServiceImpl getPATIENT_SERVICE() {
        return PATIENT_SERVICE;
    }

    public static PrescriptionServiceImpl getPRESCRIPTION_SERVICE() {
        return PRESCRIPTION_SERVICE;
    }

    public static QueuingServiceImpl getQUEUING_SERVICE() {
        return QUEUING_SERVICE;
    }

    public static SecretaryServiceImpl getSECRETARY_SERVICE() {
        return SECRETARY_SERVICE;
    }

}
