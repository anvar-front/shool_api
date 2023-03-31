package example.school.school.dto;

import example.school.school.entity.FormEntity;
import example.school.school.entity.RegionEntity;
import example.school.school.entity.StudentEntity;
import example.school.school.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String firstname;
    private String name;
    private String lastname;
    private Date datebirth;
    private GenderEnum gender;
    private RegionEntity region;
    private FormEntity form;

    public static StudentDTO toModel(StudentEntity student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstname(student.getFirstname());
        studentDTO.setName(student.getName());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setDatebirth(student.getDatebirth());
        studentDTO.setGender(student.getGender());
        studentDTO.setRegion(student.getRegion());
        studentDTO.setForm(student.getForm());
        return studentDTO;
    }
}
