package com.github.juli220620.web.rq;

public record SearchParamsRq (String name,
                              Boolean canBloom,
                              String light,
                              String humidity,
                              String temperature,
                              String toxicityStatus) {}
