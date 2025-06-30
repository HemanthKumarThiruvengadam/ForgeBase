package com.forgebase.forgebase.Model;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class SpurGearOutputDTO {
    private
    Date CreatedAt;

    double contactRatio;
    double angleTurnByPinion;
    double angleTurnByGear;
    double makingContactRatio;
    double leavingContactRatio;
}
