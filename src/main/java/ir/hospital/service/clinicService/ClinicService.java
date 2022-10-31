package ir.hospital.service.clinicService;

import ir.hospital.entity.Clinic;
import ir.hospital.service.BaseService;

import java.util.List;

public interface ClinicService extends BaseService<Clinic> {
    List<Clinic> clinics();
}
