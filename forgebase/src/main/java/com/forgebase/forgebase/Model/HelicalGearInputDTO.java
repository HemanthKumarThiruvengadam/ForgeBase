package com.forgebase.forgebase.Model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HelicalGearInputDTO {

    private final Date CreatedAt;

    private final double module;               // m
    private final double teethOnPinion;        // z1
    private final double teethOnGear;          // z2
    private final double pressureAngle;        // φ (degrees)
    private final double helixAngle;           // β (degrees)
    private final double addendaOnPinion;      // ap
    private final double addendaOnGear;        // ag
}
