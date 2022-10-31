package ir.hospital.service.patientService;

import ir.hospital.entity.Doctor;
import ir.hospital.entity.Patient;
import ir.hospital.service.BaseService;

public interface PatientService extends BaseService<Patient> {
    Patient findByNc(String nationalCode);

}
