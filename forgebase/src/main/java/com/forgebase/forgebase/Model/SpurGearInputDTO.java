package com.forgebase.forgebase.Model;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class SpurGearInputDTO {

   @NotNull(message = "Creation date is required")
   private final Date CreatedAt;

   @Min(value = 10, message = "Pressure angle must be at least 10 degrees")
   private final double pressureAngleOfGear;

   @Min(value = 0, message = "Module must be positive")
   private final double module;

   @Min(value = 1, message = "Teeth on pinion must be at least 1")
   private final double teethOnPinion;

   @Min(value = 1, message = "Teeth on gear must be at least 1")
   private final double teethOnGear;

   @Min(value = 0, message = "Addenda on pinion must be non-negative")
   private final double addendaOnPinion;

   @Min(value = 0, message = "Addenda on gear must be non-negative")
   private final double addendaOnGear;
}
