package com.forgebase.forgebase.Model;

import lombok.Builder;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Builder
public class HelicalGearOutputDTO {

    private final
    Date CreatedAt;

    private final double normalModule;               // mn = m * cos(β)
    private final double transverseModule;          // mt = m
    private final double pitchDiameterPinion;       // dp1 = m * z1 / cos(β)
    private final double pitchDiameterGear;         // dp2 = m * z2 / cos(β)
    private final double baseDiameterPinion;        // db1 = dp1 * cos(φ)
    private final double baseDiameterGear;          // db2 = dp2 * cos(φ)
    private final double circularPitch;             // p = π * m
    private final double axialPitch;                // pa = π * m / tan(β)
    private final double leadPinion;                // L1 = π * dp1 / tan(β)
    private final double leadGear;                  // L2 = π * dp2 / tan(β)
    private final double wholeDepth;                // h = ap + (1.25 * m)  [or average]
    private final double centerDistance;           // a = (dp1 + dp2)/2
    private final double contactRatio;              // Approximate (can be refined)
    private double round(double value) {
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getNormalModule() {
        return round(normalModule);
    }

    public double getTransverseModule() {
        return round(transverseModule);
    }

    public double getPitchDiameterPinion() {
        return round(pitchDiameterPinion);
    }

    public double getPitchDiameterGear() {
        return round(pitchDiameterGear);
    }

    public double getBaseDiameterPinion() {
        return round(baseDiameterPinion);
    }

    public double getBaseDiameterGear() {
        return round(baseDiameterGear);
    }

    public double getCircularPitch() {
        return round(circularPitch);
    }

    public double getAxialPitch() {
        return round(axialPitch);
    }

    public double getLeadPinion() {
        return round(leadPinion);
    }

    public double getLeadGear() {
        return round(leadGear);
    }

    public double getWholeDepth() {
        return round(wholeDepth);
    }

    public double getCenterDistance() {
        return round(centerDistance);
    }

    public double getContactRatio() {
        return round(contactRatio);
    }
}

