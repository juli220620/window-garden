package com.github.juli220620.mapper;

import com.github.juli220620.model.FlowerInfoEntity;
import com.github.juli220620.model.dto.FlowerInfoDto;
import com.github.juli220620.web.rq.AddFlowerInfoRq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {FlowerToxicityMapper.class, AlternativeNameMapper.class})
public abstract class FlowerInfoMapper {


    public FlowerInfoEntity rqToEntity(AddFlowerInfoRq rq) {
        var info = rqToEntityInternal(rq);
        info.getToxicity().setFlower(info);
        info.getAlternativeNames().forEach(name -> name.setFlower(info));
        return info;
    }

    public abstract FlowerInfoDto entityToDto(FlowerInfoEntity entity);

    @Mapping(target = "toxicity", source = ".")
    protected abstract FlowerInfoEntity rqToEntityInternal(AddFlowerInfoRq rq);

}
