package com.forgebase.forgebase.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelicalGearModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     Date CreatedAt;
     double module;               // m
     double teethOnPinion;        // z1
     double teethOnGear;          // z2
     double pressureAngle;        // φ (degrees)
     double helixAngle;           // β (degrees)
     double addendaOnPinion;      // ap
     double addendaOnGear;        // ag

     double normalModule;               // mn = m * cos(β)
     double transverseModule;          // mt = m
     double pitchDiameterPinion;       // dp1 = m * z1 / cos(β)
     double pitchDiameterGear;         // dp2 = m * z2 / cos(β)
     double baseDiameterPinion;        // db1 = dp1 * cos(φ)
     double baseDiameterGear;          // db2 = dp2 * cos(φ)
     double circularPitch;             // p = π * m
     double axialPitch;                // pa = π * m / tan(β)
     double leadPinion;                // L1 = π * dp1 / tan(β)
     double leadGear;                  // L2 = π * dp2 / tan(β)
     double wholeDepth;                // h = ap + (1.25 * m)  [or average]
     double centerDistance;           // a = (dp1 + dp2)/2
     double contactRatio;             // Approximate (can be refined)

}
