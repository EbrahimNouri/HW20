package ir.hospital.service.doctorService;

import ir.hospital.entity.Doctor;
import ir.hospital.service.BaseService;


public interface DoctorService extends BaseService<Doctor> {
    Doctor findByNc(String nationalCode);
}
