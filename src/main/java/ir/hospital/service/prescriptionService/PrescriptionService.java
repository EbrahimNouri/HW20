package ir.hospital.service.prescriptionService;

import ir.hospital.entity.Prescription;
import ir.hospital.service.BaseService;

import java.util.List;

public interface PrescriptionService extends BaseService<Prescription> {

    List<Prescription> findByPatientId(Long id);
}
