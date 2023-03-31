package example.school.school.dto;

import example.school.school.entity.FormEntity;
import example.school.school.enums.FormEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FormForListDTO {
    private Long id;
    private Integer form;
    private FormEnum prefix;

    public FormForListDTO(Long id, Integer form, FormEnum prefix) {
        this.id = id;
        this.form = form;
        this.prefix = prefix;
    }

    public static FormDTO toModel(FormEntity entity){
        FormDTO formDTO = new FormDTO();
        formDTO.setId(entity.getId());
        formDTO.setForm(entity.getForm());
        formDTO.setPrefix(entity.getPrefix());
        return formDTO;
    }
}

