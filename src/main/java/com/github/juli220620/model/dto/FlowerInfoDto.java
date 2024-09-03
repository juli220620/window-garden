package com.github.juli220620.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlowerInfoDto {

    private String name;
    private boolean canBloom;
    private String light;
    private String humidity;
    private String temperature;
    private FlowerToxicityDto toxicity;
    private List<String> alternativeNames;
}
