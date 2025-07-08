package com.forgebase.forgebase.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HelicalGearInputDTO {

    @NotNull(message = "CreatedAt cannot be null")
    private final Date CreatedAt;

    @Min(value = 1, message = "Module must be at least 1")
    private final double module;

    @Min(value = 1, message = "Teeth on pinion must be at least 1")
    private final double teethOnPinion;

    @Min(value = 1, message = "Teeth on gear must be at least 1")
    private final double teethOnGear;

    @Min(value = 10, message = "Pressure angle must be at least 10°")
    private final double pressureAngle;

    @Min(value = 1, message = "Helix angle must be greater than 0°")
    private final double helixAngle;

    @Min(value = 0, message = "Addenda on pinion must be non-negative")
    private final double addendaOnPinion;

    @Min(value = 0, message = "Addenda on gear must be non-negative")
    private final double addendaOnGear;
}
