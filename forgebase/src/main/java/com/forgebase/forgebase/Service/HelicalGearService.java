package com.forgebase.forgebase.Service;

import com.forgebase.forgebase.Model.HelicalGearInputDTO;
import com.forgebase.forgebase.Model.HelicalGearModel;
import com.forgebase.forgebase.Model.HelicalGearOutputDTO;
import com.forgebase.forgebase.Model.SpurGearModel;
import com.forgebase.forgebase.Repository.HelicalGearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.DTD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HelicalGearService {
    private final HelicalGearRepository helicalGearRepository;

    public HelicalGearOutputDTO CalculateAndSave(HelicalGearInputDTO dto){
        HelicalGearModel helicalGearModel = BuildGearModel(dto);
        helicalGearRepository.save(helicalGearModel);
        return BuildOutputDTO(helicalGearModel);
    }



    private HelicalGearModel BuildGearModel(HelicalGearInputDTO dto) {
        HelicalGearCalculations helicalGearCalculations = new HelicalGearCalculations(
                dto.getModule(),
                dto.getTeethOnPinion(),
                dto.getTeethOnGear(),
                dto.getPressureAngle(),
                dto.getHelixAngle(),
                dto.getAddendaOnPinion(),
                dto.getAddendaOnGear());
        return HelicalGearModel.builder()
                .CreatedAt(new Date())
                .module(dto.getModule())
                .teethOnPinion(dto.getTeethOnPinion())
                .teethOnGear(dto.getTeethOnGear())
                .pressureAngle(dto.getPressureAngle())
                .helixAngle(dto.getHelixAngle())
                .addendaOnPinion(dto.getAddendaOnPinion())
                .addendaOnGear(dto.getAddendaOnGear())
                .normalModule(helicalGearCalculations.getNormalModule())
                .transverseModule(helicalGearCalculations.getTransverseModule())
                .pitchDiameterPinion(helicalGearCalculations.getPitchDiameterPinion())
                .pitchDiameterGear(helicalGearCalculations.getPitchDiameterGear())
                .baseDiameterPinion(helicalGearCalculations.getBaseDiameterPinion())
                .baseDiameterGear(helicalGearCalculations.getBaseDiameterGear())
                .circularPitch(helicalGearCalculations.getCircularPitch())
                .axialPitch(helicalGearCalculations.getAxialPitch())
                .leadPinion(helicalGearCalculations.getLeadPinion())
                .leadGear(helicalGearCalculations.getLeadGear())
                .wholeDepth(helicalGearCalculations.getWholeDepth())
                .centerDistance(helicalGearCalculations.getCenterDistance())
                .contactRatio(helicalGearCalculations.getContactRatio())
                .build();
    }
    private HelicalGearOutputDTO BuildOutputDTO(HelicalGearModel model) {
        return HelicalGearOutputDTO.builder()
                .CreatedAt(new Date())
                .normalModule(model.getNormalModule())
                .transverseModule(model.getTransverseModule())
                .pitchDiameterPinion(model.getPitchDiameterPinion())
                .pitchDiameterGear(model.getPitchDiameterGear())
                .baseDiameterPinion(model.getBaseDiameterPinion())
                .baseDiameterGear(model.getBaseDiameterGear())
                .circularPitch(model.getCircularPitch())
                .axialPitch(model.getAxialPitch())
                .leadPinion(model.getLeadPinion())
                .leadGear(model.getLeadGear())
                .wholeDepth(model.getWholeDepth())
                .centerDistance(model.getCenterDistance())
                .contactRatio(model.getContactRatio())
                .build();
    }
    public HelicalGearModel GetById(Long Id){
        return helicalGearRepository.findById(Id).orElseThrow(() -> new RuntimeException("Gear model not found for this Id"));
    }
    public List<HelicalGearModel> getAllGears() {
        return helicalGearRepository.findAll();
    }


}
