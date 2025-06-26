package com.forgebase.forgebase.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class GearModel {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    double pressureAngleOfGear;
    double module;
    double teethOnPinion;
    double teethOnGear;
    double addendaOnPinion;
    double addendaOnGear;

    double contactRatio;
    double angleTurnByPinion;
    double angleTurnByGear;
    double makingContactRatio;
    double leavingContactRatio;


}
