package com.adu21.ddd.quotation.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryHomePolicyCommand {
    private String buildingMaterial;
    private String buildingType;
    private String numberOfRooms;
}
