package com.adu21.ddd.policy.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateHomePolicyCommand {
    private LocalDate startDate;
    private String buildingMaterial;
    private String buildingType;
    private String numberOfRooms;
    private String quoteId;
    private double premium;
    private LocalDate holderBirthday;
    private String holderEmail;
    private String holderId;
    private String holderName;
}
