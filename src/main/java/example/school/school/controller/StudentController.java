package example.school.school.controller;

import example.school.school.dto.RegionDTO;
import example.school.school.dto.StudentDTO;
import example.school.school.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentDTO studentDTO){
        try {
            return ResponseEntity.ok(studentService.addStudent(studentDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putStudent(@PathVariable Long id,
                                       @RequestBody StudentDTO studentDTO){
        try {
            return ResponseEntity.ok(studentService.putStudent(id, studentDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Denied");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneStudent(@PathVariable Long id){
        try {
            return ResponseEntity.ok(studentService.getOneStudent(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Denied");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        try {
            return ResponseEntity.ok(studentService.deleteStudent(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Denied");
        }
    }
}
