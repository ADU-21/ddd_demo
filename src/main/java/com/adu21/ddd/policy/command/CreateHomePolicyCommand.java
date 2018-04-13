package com.adu21.ddd.policy.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateHomePolicyCommand {
    private String policyNumber;
    private String ownerEmail;
    private String ownerUserName;
    private String policyOwnerUuid;
    private Date startDate;
    private String buildingMaterial;
    private String buildingType;
    private int numberOfRooms;
    private double price;
    private String quoteId;
    private Date holderBirthday;
    private String holderEmail;
    private String holderId;
}
