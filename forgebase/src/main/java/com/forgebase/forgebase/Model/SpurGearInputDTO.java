package com.forgebase.forgebase.Model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SpurGearInputDTO {
   private final Date CreatedAt;

   private final double pressureAngleOfGear;
   private final double module;
   private final double teethOnPinion;
   private final double teethOnGear;
   private final double addendaOnPinion;
   private final double addendaOnGear;
}
