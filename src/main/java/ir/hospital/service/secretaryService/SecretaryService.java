package ir.hospital.service.secretaryService;

import ir.hospital.entity.Doctor;
import ir.hospital.entity.Secretary;
import ir.hospital.service.BaseService;

public interface SecretaryService extends BaseService<Secretary> {
    Secretary findByNc(String nationalCode);

}
