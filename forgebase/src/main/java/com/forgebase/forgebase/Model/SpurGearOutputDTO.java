package com.forgebase.forgebase.Model;


import lombok.Builder;
import lombok.Getter;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;


@Builder

public class SpurGearOutputDTO {


    private final Date CreatedAt;

    private double contactRatio;
    private double angleTurnByPinion;
    private double angleTurnByGear;
    private double makingContactRatio;
    private double leavingContactRatio;
    private double round(double value) {
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double getContactRatio() {
        return  round (contactRatio);
    }

    public double getAngleTurnByPinion() {
        return  round (angleTurnByPinion);
    }

    public double getAngleTurnByGear() {
        return  round (angleTurnByGear);
    }

    public double getMakingContactRatio() {
        return  round (makingContactRatio);
    }

    public double getLeavingContactRatio() {
        return  round (leavingContactRatio);
    }
}
