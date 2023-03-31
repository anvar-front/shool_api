package example.school.school.repository;

import example.school.school.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<StudentEntity, Long> {
}
