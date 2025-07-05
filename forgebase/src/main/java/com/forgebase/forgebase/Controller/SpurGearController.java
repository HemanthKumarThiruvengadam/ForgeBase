package com.forgebase.forgebase.Controller;
import com.forgebase.forgebase.Model.HelicalGearModel;
import com.forgebase.forgebase.Model.SpurGearInputDTO;
import com.forgebase.forgebase.Model.SpurGearModel;
import com.forgebase.forgebase.Model.SpurGearOutputDTO;
import com.forgebase.forgebase.Service.SpurGearService;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Marks the class as a REST Controller (returns a JSON file)
@RequestMapping("/api/spurgears/calculations")
@RequiredArgsConstructor
public class SpurGearController {
    private final SpurGearService gearService;
    @PostMapping
    public ResponseEntity<SpurGearOutputDTO> CalculateAndSave(@RequestBody SpurGearInputDTO inputDTO){
        SpurGearOutputDTO result = gearService.CalculateAndSave(inputDTO);
        return ResponseEntity.ok(result);
    }
    @GetMapping
    public SpurGearModel GetById(Long Id){
        return gearService.GetById(Id);
    }
    @GetMapping
    public List<SpurGearModel> getAllGears() {
        return gearService.getAllGears();
    }
}
