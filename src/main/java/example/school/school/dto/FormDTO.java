package example.school.school.dto;

import example.school.school.entity.FormEntity;
import example.school.school.enums.FormEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class FormDTO {
    private Long id;
    private Integer form;
    private FormEnum prefix;
    private List<StudentDTO> students;

    public static FormDTO toModel(FormEntity entity){
        FormDTO formDTO = new FormDTO();
        formDTO.setId(entity.getId());
        formDTO.setForm(entity.getForm());
        formDTO.setPrefix(entity.getPrefix());
        formDTO.setStudents(entity.getStudents().stream().map(StudentDTO::toModel).collect(Collectors.toList()));
        return formDTO;
    }

    public static FormDTO toCreateModel(FormEntity entity){
        FormDTO formDTO = new FormDTO();
        formDTO.setId(entity.getId());
        formDTO.setForm(entity.getForm());
        formDTO.setPrefix(entity.getPrefix());
        return formDTO;
    }
}
