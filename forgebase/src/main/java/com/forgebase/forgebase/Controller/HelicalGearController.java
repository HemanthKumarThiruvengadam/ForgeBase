package com.forgebase.forgebase.Controller;

import com.forgebase.forgebase.Model.HelicalGearInputDTO;
import com.forgebase.forgebase.Model.HelicalGearOutputDTO;
import com.forgebase.forgebase.Service.HelicalGearService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helicalgears/calculations")
@RequiredArgsConstructor
public class HelicalGearController {
    private final HelicalGearService helicalGearService;
    @Valid
    @PostMapping
    public ResponseEntity<HelicalGearOutputDTO> CalculateAndSave(@RequestBody HelicalGearInputDTO inputDTO){
        HelicalGearOutputDTO result = helicalGearService.CalculateAndSave(inputDTO);
        return ResponseEntity.ok(result);

    }
    @GetMapping("/api/helicalgears/calculations/all")
    public List<HelicalGearOutputDTO> getAllGears() {
        return helicalGearService.getAllGears();
    }
    @GetMapping("/api/helicalgears/{Id}")
    public HelicalGearOutputDTO GetById(Long Id){
        return helicalGearService.GetById(Id);
    }
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll(){
        helicalGearService.deleteAll();
        return ResponseEntity.ok("All the Helical gear calculations are deleted");
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteById(Long Id){
        helicalGearService.deleteById(Id);
        return ResponseEntity.ok("Helical gear with ID" + Id +"deleted successfully");
    }
}
