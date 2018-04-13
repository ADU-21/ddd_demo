package com.adu21.ddd.quote.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryHomePolicyCommand {
    private LocalDate startDate;
    private String buildingMaterial;
    private String buildingType;
    private String numberOfRooms;
}
