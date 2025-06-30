package com.forgebase.forgebase.Controller;
import com.forgebase.forgebase.Model.SpurGearInputDTO;
import com.forgebase.forgebase.Model.SpurGearOutputDTO;
import com.forgebase.forgebase.Service.SpurGearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
