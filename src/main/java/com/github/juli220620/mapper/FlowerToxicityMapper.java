package com.github.juli220620.mapper;

import com.github.juli220620.model.FlowerToxicityInfoEntity;
import com.github.juli220620.model.dto.FlowerToxicityDto;
import com.github.juli220620.web.rq.AddFlowerInfoRq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FlowerToxicityMapper {

    @Mapping(target = "flower", ignore = true)
    @Mapping(source = "toxicityExplanation", target = "explanation")
    FlowerToxicityInfoEntity flowerRqToToxEntity(AddFlowerInfoRq rq);

    @Mapping(target = "status", source = "toxicityStatus")
    FlowerToxicityDto entityToDto(FlowerToxicityInfoEntity entity);
}
