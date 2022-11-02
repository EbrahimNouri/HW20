package ir.hospital.service.patientService;

import ir.hospital.dto.ClinicDto;
import ir.hospital.dto.PatientDto;
import ir.hospital.entity.Patient;
import ir.hospital.service.BaseService;

import java.util.List;

public interface PatientService extends BaseService<Patient> {
    Patient findByNc(String nationalCode);

    void addPatient(String nationalCode, String password);

    PatientDto patientGetDtoInfo(Patient patient);

    List<ClinicDto> getClinicDtoInfo();

}
