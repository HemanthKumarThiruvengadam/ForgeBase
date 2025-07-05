package com.forgebase.forgebase.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Builder
public class SpurGearModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Date CreatedAt;

    private double pressureAngleOfGear;
    private double module;
    private double teethOnPinion;
    private double teethOnGear;
    private double addendaOnPinion;
    private double addendaOnGear;

    private double contactRatio;
    private double angleTurnByPinion;
    private double angleTurnByGear;
    private double makingContactRatio;
    private double leavingContactRatio;


}
