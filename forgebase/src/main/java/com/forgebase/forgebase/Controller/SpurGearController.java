package com.forgebase.forgebase.Controller;
import com.forgebase.forgebase.Model.SpurGearInputDTO;
import com.forgebase.forgebase.Model.SpurGearOutputDTO;
import com.forgebase.forgebase.Service.SpurGearService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Marks the class as a REST Controller (returns a JSON file)
@RequestMapping("/api/spurgears/calculations")
@RequiredArgsConstructor
public class SpurGearController {
    private final SpurGearService gearService;
    @Valid
    @PostMapping
    public ResponseEntity<SpurGearOutputDTO> CalculateAndSave(@RequestBody SpurGearInputDTO inputDTO){
        SpurGearOutputDTO result = gearService.CalculateAndSave(inputDTO);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{Id}")
    public SpurGearOutputDTO GetById(Long Id){
        return gearService.GetById(Id);
    }
    @GetMapping("/all")
    public List<SpurGearOutputDTO> getAllGears() {
        return gearService.getAllGears();
    }
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll(){
        gearService.deleteAll();
        return ResponseEntity.ok("All the Spur gear calculations are deleted");
    }
    public ResponseEntity<String> deleteById(Long Id){
        gearService.deleteById(Id);
        return ResponseEntity.ok("Spur gear with ID" + Id +"deleted successfully");
    }
}
