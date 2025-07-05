package com.forgebase.forgebase.Controller;

import com.forgebase.forgebase.Model.HelicalGearInputDTO;
import com.forgebase.forgebase.Model.HelicalGearModel;
import com.forgebase.forgebase.Model.HelicalGearOutputDTO;
import com.forgebase.forgebase.Service.HelicalGearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helicalgears/calculations")
@RequiredArgsConstructor
public class HelicalGearController {
    private final HelicalGearService helicalGearService;

    @PostMapping
    public ResponseEntity<HelicalGearOutputDTO> CalculateAndSave(@RequestBody HelicalGearInputDTO inputDTO){
        HelicalGearOutputDTO result = helicalGearService.CalculateAndSave(inputDTO);
        return ResponseEntity.ok(result);

    }
    @GetMapping
    public List<HelicalGearModel> getAllGears() {
        return helicalGearService.getAllGears();
    }
    @GetMapping
    public HelicalGearModel GetById(Long Id){
        return helicalGearService.GetById(Id);
    }
}
