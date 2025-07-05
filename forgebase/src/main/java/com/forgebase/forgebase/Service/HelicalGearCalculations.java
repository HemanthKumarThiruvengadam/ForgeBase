package com.forgebase.forgebase.Service;

import lombok.Getter;
@Getter
public class HelicalGearCalculations {
   private final double module;               // m
   private final double teethOnPinion;        // z1
   private final double teethOnGear;          // z2
   private final double pressureAngle;        // φ (degrees)
   private final double helixAngle;           // β (degrees)
   private final double addendaOnPinion;      // ap
   private final double addendaOnGear;        // ag
   private double pressureAngleInRadians;
   private double helixAngleInRadians;

   private double normalModule;               // mn = m * cos(β)
   private double transverseModule;          // mt = m
   private double pitchDiameterPinion;       // dp1 = m * z1 / cos(β)
   private double pitchDiameterGear;         // dp2 = m * z2 / cos(β)
   private double baseDiameterPinion;        // db1 = dp1 * cos(φ)
   private double baseDiameterGear;          // db2 = dp2 * cos(φ)
   private double circularPitch;             // p = π * m
   private double axialPitch;                // pa = π * m / tan(β)
   private double leadPinion;                // L1 = π * dp1 / tan(β)
   private double leadGear;                  // L2 = π * dp2 / tan(β)
   private double wholeDepth;                // h = ap + (1.25 * m)  [or average]
   private double centerDistance;           // a = (dp1 + dp2)/2
   private double contactRatio;             // Approximate (can be refined)

    public HelicalGearCalculations(double module, double teethOnPinion, double teethOnGear, double pressureAngle, double helixAngle, double addendaOnPinion, double addendaOnGear) {
        this.module = module;
        this.teethOnPinion = teethOnPinion;
        this.teethOnGear = teethOnGear;
        this.pressureAngle = pressureAngle;
        this.helixAngle = helixAngle;
        this.addendaOnPinion = addendaOnPinion;
        this.addendaOnGear = addendaOnGear;
        transverseModule = module;
        ConversionToRadians();
        NormalModuleCalculation();
        PitchDiameterPinionCalculation();
        PitchDiameterGearCalculation();
        BaseDiameterPinionCalculation();
        BaseDiameterGearCalculation();
        CircularPitchCalculation();
        AxialPitchCalculation();
        LeadPinionCalculation();
        LeadGearCalculation();
        WholeDepthCalculation();
        CenterDistanceCalculation();
        ContactRatioCalculation();
    }
    private void ConversionToRadians(){
        pressureAngleInRadians = Math.toRadians(pressureAngle);
        helixAngleInRadians = Math.toRadians(helixAngle);
    }
    private void NormalModuleCalculation(){

        normalModule = module * Math.cos(helixAngleInRadians);
    }
    private void PitchDiameterPinionCalculation(){

        pitchDiameterPinion = module * teethOnPinion / Math.cos(helixAngleInRadians);
    }
    private void PitchDiameterGearCalculation(){

        pitchDiameterGear = module * teethOnGear / Math.cos(helixAngleInRadians);
    }
    private void BaseDiameterPinionCalculation(){
        baseDiameterPinion = pitchDiameterPinion * Math.cos(pressureAngleInRadians);
    }
    private void BaseDiameterGearCalculation(){
        baseDiameterGear = pitchDiameterGear * Math.cos(pressureAngleInRadians);
    }
    private void CircularPitchCalculation(){
        circularPitch = Math.PI * module;
    }
    private void AxialPitchCalculation(){
        axialPitch = Math.PI * module / Math.cos(helixAngleInRadians);
    }
    private void LeadPinionCalculation(){
        leadPinion = Math.PI * pitchDiameterPinion / Math.tan(helixAngleInRadians);
    }
    private void LeadGearCalculation(){
        leadGear = Math.PI * pitchDiameterGear / Math.tan(helixAngleInRadians);
    }
    private void WholeDepthCalculation(){
        wholeDepth = (addendaOnPinion + addendaOnGear) / 2 + (1.25 * module);
    }
    private void CenterDistanceCalculation(){
        centerDistance = (pitchDiameterPinion + pitchDiameterGear) / 2;
    }
    private void ContactRatioCalculation() {
        double workingDepth = addendaOnPinion + addendaOnGear;
        double circularBasePitch = (Math.PI * module) * Math.cos(pressureAngleInRadians);
        contactRatio = workingDepth / circularBasePitch;
    }


}
