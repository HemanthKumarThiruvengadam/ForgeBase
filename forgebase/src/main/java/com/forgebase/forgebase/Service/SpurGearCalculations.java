package com.forgebase.forgebase.Service;

public class SpurGearCalculations {
    private final
    double pressureAngleOfGear;
    double module;
    double teethOnPinion;
    double teethOnGear;
    double addendaOnPinion;
    double addendaOnGear;

    public SpurGearCalculations(double pressureAngleOfGear, double module, double teethOnPinion, double teethOnGear, double addendaOnPinion, double addendaOnGear) {
        this.pressureAngleOfGear = pressureAngleOfGear;
        this.module = module;
        this.teethOnPinion = teethOnPinion;
        this.teethOnGear = teethOnGear;
        this.addendaOnPinion = addendaOnPinion;
        this.addendaOnGear = addendaOnGear;
    }

    private double PitchCircleRadius(double module, double teeth) {
        return module * (teeth / 2);
    }

    private double RadiusOfAddendumCircle(double module, double teeth, double addenda) {
        return PitchCircleRadius(module, teeth) + addenda;
    }

    private double LengthOfPath(double module, double teeth, double addenda, double angle) {
        double radians = Math.toRadians(angle);
        return  (Math.sqrt(Math.pow(RadiusOfAddendumCircle(module, teeth, addenda), 2) // This is Ra ^ 2
                - Math.pow(PitchCircleRadius(module, teeth), 2) * Math.pow(Math.cos(radians), 2)) //This is R ^ 2 * cos ^ 2 (randians)
                - PitchCircleRadius(module, teeth) * Math.sin(radians)); // This is R * sin(radians)
    }

    private double LengthOfPathOfContact(double module, double angle, double teethPinion, double teethGear, double addendaPinion, double addendaGear) {
        return LengthOfPath(module, teethPinion, addendaPinion, angle) + LengthOfPath(module, teethGear, addendaGear, angle);
    }

    private double LengthOfArcOfContact(double module, double angle, double teethPinion, double teethGear, double addendaPinion, double addendaGear) {
        double radians = Math.toRadians(angle);
        return  (LengthOfPathOfContact(module, angle, teethPinion, teethGear, addendaPinion, addendaGear)
                / Math.cos(radians));
    }

    private double CircularPitch(double module) {
        return (double) Math.PI * module;
    }

    public double ContactRatio() {
        return LengthOfArcOfContact(module, pressureAngleOfGear, teethOnPinion, teethOnGear, addendaOnPinion, addendaOnGear)
                / CircularPitch(module);
    }

    private double circumference(double module, double teeth) {
        return  (2 * Math.PI * PitchCircleRadius(module, teeth));
    }

    public double AngleTurnByPinion() {
        return LengthOfArcOfContact(module, pressureAngleOfGear, teethOnPinion, teethOnGear, addendaOnPinion, addendaOnGear) * 360
                / circumference(module, teethOnPinion);
    }

    public double AngleTurnByGear() {
        return LengthOfArcOfContact(module, pressureAngleOfGear, teethOnPinion, teethOnGear, addendaOnPinion, addendaOnGear) * 360
                / circumference(module, teethOnGear);
    }
    private double RatioOfVelocities(double teethPinion,double teethGear){
        return teethPinion / teethGear;
    }
    private double SlidingVelocity(double teethPinion,double teethGear,double module, double teeth, double addenda, double angle){
        return (1 + RatioOfVelocities(teethPinion,teethGear)) * LengthOfPath(module,teeth,addenda,angle);
    }
    public double MakingContactRatio(){
        return SlidingVelocity(teethOnPinion,teethOnGear,module,teethOnGear,addendaOnGear,pressureAngleOfGear)
                / PitchCircleRadius(module,teethOnPinion);
    }
    public double LeavingContactRatio(){
        return SlidingVelocity(teethOnPinion,teethOnGear,module,teethOnPinion,addendaOnGear,pressureAngleOfGear)
                / PitchCircleRadius(module,teethOnPinion);
    }

}
