package ir.hospital.service.secretaryService;

import ir.hospital.dto.SecretaryDto;
import ir.hospital.entity.Secretary;
import ir.hospital.service.BaseService;

public interface SecretaryService extends BaseService<Secretary> {
    Secretary findByNc(String nationalCode);

    SecretaryDto ShowAllData(Secretary secretary);

}
