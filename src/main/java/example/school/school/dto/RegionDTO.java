package example.school.school.dto;

import example.school.school.entity.RegionEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionDTO {
    private Long id;
    private String name;

    public RegionDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static RegionDTO toModel(RegionEntity region){
        RegionDTO model = new RegionDTO(region.getId(), region.getName());
        return model;
    }
}
