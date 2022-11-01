package ir.hospital.service.patientService;

import ir.hospital.dto.PatientListDto;
import ir.hospital.entity.Patient;
import ir.hospital.service.BaseService;

public interface PatientService extends BaseService<Patient> {
    Patient findByNc(String nationalCode);

    void addPatient(String nationalCode, String password);

    PatientListDto viewPatientInformation(Patient patient);

}
