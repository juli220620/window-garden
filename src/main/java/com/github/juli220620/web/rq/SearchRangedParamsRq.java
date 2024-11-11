package com.github.juli220620.web.rq;

import java.util.Set;

public record SearchRangedParamsRq(String name,
                                   Set<Boolean> canBloom,
                                   Set<String> light,
                                   Set<String> humidity,
                                   Set<String> temperature,
                                   Set<String> toxicityStatus) {}
