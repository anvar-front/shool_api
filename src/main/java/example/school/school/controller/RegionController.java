package example.school.school.controller;

import example.school.school.dto.RegionDTO;
import example.school.school.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping
    public ResponseEntity addRegion(@RequestBody RegionDTO regionDTO){
        try {
            return ResponseEntity.ok(regionService.addRegion(regionDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public HashMap<String, List<RegionDTO>> getAll(){
        HashMap<String, List<RegionDTO>> hashMap = new HashMap<>();
        hashMap.put("Regions", regionService.getAll());
        return hashMap;
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneRegion(@PathVariable Long id){
        try {
            return ResponseEntity.ok(regionService.getOneRegion(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Denied");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity completeToDo(@PathVariable Long id,
                                       @RequestBody RegionDTO regionDTO){
        try {
            return ResponseEntity.ok(regionService.putRegion(id, regionDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Denied");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRegion(@PathVariable Long id){
        try {
            return ResponseEntity.ok(regionService.deleteRegion(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Denied");
        }
    }
}
