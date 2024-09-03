package com.github.juli220620.web.rq;

import java.util.List;

public record AddFlowerInfoRq (String id,
                               String name,
                               boolean canBloom,
                               String light,
                               String humidity,
                               String temperature,
                               String toxicityStatus,
                               String toxicityExplanation,
                               List<String> alternativeNames) {}
