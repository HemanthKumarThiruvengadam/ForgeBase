package com.forgebase.forgebase.Service;

import com.forgebase.forgebase.Model.HelicalGearModel;
import com.forgebase.forgebase.Model.SpurGearInputDTO;
import com.forgebase.forgebase.Model.SpurGearModel;
import com.forgebase.forgebase.Model.SpurGearOutputDTO;
import com.forgebase.forgebase.Repository.SpurGearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpurGearService {
    private final SpurGearRepository gearRepository;
    //SpurGearOutPut Calculation and saving in repository
    //Returns DTO containing the output
    public SpurGearOutputDTO CalculateAndSave(SpurGearInputDTO dto){
        SpurGearModel gearModel = BuildGearModel(dto);
        gearRepository.save(gearModel);
        return BuildOutputDTO(gearModel);
    }
    //Constructs the SpurGearModel by calculating using the SpurGearCalculations
    private SpurGearModel BuildGearModel(SpurGearInputDTO dto) {
        SpurGearCalculations spur= new SpurGearCalculations(
                dto.getPressureAngleOfGear(),
                dto.getModule(),
                dto.getTeethOnPinion(),
                dto.getTeethOnGear(),
                dto.getAddendaOnPinion(),
                dto.getAddendaOnGear());
        return SpurGearModel.builder()
                .CreatedAt(new Date())
                .pressureAngleOfGear(dto.getPressureAngleOfGear())
                .module(dto.getModule())
                .teethOnPinion(dto.getTeethOnPinion())
                .teethOnGear(dto.getTeethOnGear())
                .addendaOnPinion(dto.getAddendaOnPinion())
                .addendaOnGear(dto.getAddendaOnGear())
                .contactRatio(spur.ContactRatio())
                .angleTurnByPinion(spur.AngleTurnByPinion())
                .angleTurnByGear(spur.AngleTurnByGear())
                .makingContactRatio(spur.MakingContactRatio())
                .leavingContactRatio(spur.LeavingContactRatio())
                .build();
    }
    //Converts the stored SpurGearModel into SpurGearOutputDTO for Client response
    private SpurGearOutputDTO BuildOutputDTO(SpurGearModel model){
        return SpurGearOutputDTO.builder()
                .CreatedAt(model.getCreatedAt())
                .contactRatio(model.getContactRatio())
                .angleTurnByPinion(model.getAngleTurnByPinion())
                .angleTurnByGear(model.getAngleTurnByGear())
                .makingContactRatio(model.getMakingContactRatio())
                .leavingContactRatio(model.getLeavingContactRatio())
                .build();
    }
    public SpurGearModel GetById(Long Id){
        return gearRepository.findById(Id).orElseThrow(() -> new RuntimeException("Gear model not found for this Id"));
    }
    public List<SpurGearModel> getAllGears() {
        return gearRepository.findAll();
    }

}
