package com.forgebase.forgebase.Model;


import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder
public class SpurGearOutputDTO {

    private Date CreatedAt;

    private double contactRatio;
    private double angleTurnByPinion;
    private double angleTurnByGear;
    private double makingContactRatio;
    private double leavingContactRatio;
}
