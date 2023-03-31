package example.school.school.controller;

import example.school.school.dto.FormDTO;
import example.school.school.dto.FormForListDTO;
import example.school.school.dto.RegionDTO;
import example.school.school.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    private FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping
    public ResponseEntity addForm(@RequestBody FormDTO formDTO){
        try {
            return ResponseEntity.ok(formService.addForm(formDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public HashMap<String, List<FormForListDTO>> getAllRegions(){
        HashMap<String, List<FormForListDTO>> hashMap = new HashMap<>();
        hashMap.put("Forms", formService.getAll());
        return hashMap;
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneForm(@PathVariable Long id){
        try {
            return ResponseEntity.ok(formService.getOne(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteForm(@PathVariable Long id){
        try {
            return ResponseEntity.ok(formService.deleteForm(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Denied");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putForm(@PathVariable Long id,
                                       @RequestBody FormDTO formDTO){
        try {
            return ResponseEntity.ok(formService.putForm(id, formDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Denied");
        }
    }

}
