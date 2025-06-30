package com.forgebase.forgebase.Model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SpurGearInputDTO {
    private final
    Date CreatedAt;

    double pressureAngleOfGear;
    double module;
    double teethOnPinion;
    double teethOnGear;
    double addendaOnPinion;
    double addendaOnGear;
}
