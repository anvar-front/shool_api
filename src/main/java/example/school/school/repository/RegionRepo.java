package example.school.school.repository;

import example.school.school.entity.RegionEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepo extends CrudRepository<RegionEntity, Long> {
    RegionEntity findByName(String name);
}
