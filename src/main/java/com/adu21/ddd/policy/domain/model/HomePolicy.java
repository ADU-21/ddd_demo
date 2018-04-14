package com.adu21.ddd.policy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomePolicy extends Policy {
    private String buildingMaterial;
    private String buildingType;
    private String numberOfRooms;
}
