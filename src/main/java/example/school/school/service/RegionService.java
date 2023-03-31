package example.school.school.service;

import example.school.school.dto.RegionDTO;
import example.school.school.entity.RegionEntity;
import example.school.school.exception.RegionAlreadyExistException;
import example.school.school.exception.RegionNotFoundException;
import example.school.school.repository.RegionRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {
    private RegionRepo regionRepo;

    public RegionService(RegionRepo regionRepo) {
        this.regionRepo = regionRepo;
    }

    public RegionDTO addRegion(RegionDTO regionDTO) throws RegionAlreadyExistException {
        RegionEntity region = new RegionEntity(regionDTO.getName());
        if (regionRepo.findByName(region.getName()) != null){
            throw new RegionAlreadyExistException("This Region already created");
        }
        return RegionDTO.toModel(regionRepo.save(region));
    }

    public List<RegionDTO> getAll(){
        List<RegionEntity> entities = (List<RegionEntity>) regionRepo.findAll();
        List<RegionDTO> dtos = new ArrayList<>();
        for (RegionEntity entity: entities){
            dtos.add(new RegionDTO(entity.getId(), entity.getName()));
        }
        return dtos;
    }

    public RegionDTO getOneRegion(Long id) throws RegionNotFoundException {
        RegionEntity entity = regionRepo.findById(id).get();
        if (entity == null){
            throw new RegionNotFoundException("User not found!");
        }
        return RegionDTO.toModel(entity);
    }

    public RegionDTO putRegion(Long id, RegionDTO regionDTO){
        RegionEntity entity = regionRepo.findById(id).get();
        entity.setName(regionDTO.getName());
        return RegionDTO.toModel(regionRepo.save(entity));
    }

    public Long deleteRegion(Long id){
        regionRepo.deleteById(id);
        return id;
    }
}
