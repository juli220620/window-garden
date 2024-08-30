package com.github.juli220620.mapper;

import com.github.juli220620.model.FlowerToxicityInfoEntity;
import com.github.juli220620.web.AddFlowerInfoRq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FlowerToxicityMapper {

    @Mapping(source = "id", target = "flowerId")
    @Mapping(source = "toxicityExplanation", target = "explanation")
    FlowerToxicityInfoEntity flowerRqToToxEntity(AddFlowerInfoRq rq);
}
