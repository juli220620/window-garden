package com.github.juli220620.web;

import lombok.Getter;

import java.util.List;

@Getter
public class AddFlowerInfoRq {

    private String id;

    private String name;
    private boolean canBloom;
    private String light;
    private String humidity;
    private String temperature;
    private String toxicityStatus;
    private String toxicityExplanation;
    private List<String> alternativeNames;

}
