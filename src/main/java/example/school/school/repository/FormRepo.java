package example.school.school.repository;

import example.school.school.entity.FormEntity;
import example.school.school.enums.FormEnum;
import org.springframework.data.repository.CrudRepository;

public interface FormRepo extends CrudRepository<FormEntity, Long> {
    FormEntity findByForm(Integer form);
    FormEntity findByPrefix(FormEnum formEnum);

}
