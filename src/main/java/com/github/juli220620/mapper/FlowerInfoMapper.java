package com.github.juli220620.mapper;

import com.github.juli220620.model.FlowerInfoEntity;
import com.github.juli220620.web.AddFlowerInfoRq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        imports = FlowerToxicityMapper.class,
        uses = FlowerToxicityMapper.class)
public interface FlowerInfoMapper {

    @Mapping(target = "toxicity", source = ".")
    FlowerInfoEntity rqToEntity(AddFlowerInfoRq rq);


}
