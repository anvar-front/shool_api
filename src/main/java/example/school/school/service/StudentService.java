package example.school.school.service;

import example.school.school.dto.StudentDTO;
import example.school.school.entity.StudentEntity;
import example.school.school.exception.StudentNotFoundException;
import example.school.school.repository.StudentRepo;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public StudentDTO addStudent(StudentDTO studentDTO){
        StudentEntity entity = new StudentEntity(
            studentDTO.getFirstname(),
            studentDTO.getName(),
            studentDTO.getLastname(),
            studentDTO.getDatebirth(),
            studentDTO.getGender(),
            studentDTO.getRegion(),
            studentDTO.getForm()
        );
        return StudentDTO.toModel(studentRepo.save(entity));
    }

    public StudentDTO putStudent(Long id, StudentDTO studentDTO){
        StudentEntity entity = studentRepo.findById(id).get();
        entity.setFirstname(studentDTO.getFirstname());
        entity.setName(studentDTO.getName());
        entity.setLastname(studentDTO.getLastname());
        entity.setDatebirth(studentDTO.getDatebirth());
        entity.setGender(studentDTO.getGender());
        entity.setRegion(studentDTO.getRegion());
        entity.setForm(studentDTO.getForm());
        return StudentDTO.toModel(studentRepo.save(entity));
    }

    public StudentDTO getOneStudent(Long id) throws StudentNotFoundException {
        StudentEntity entity = studentRepo.findById(id).get();
        if (entity == null){
            throw new StudentNotFoundException("Student not found");
        }
        return StudentDTO.toModel(entity);
    }

    public Long deleteStudent(Long id){
        studentRepo.deleteById(id);
        return id;
    }
}
