package com.github.juli220620.mapper;

import com.github.juli220620.model.FlowerInfoEntity;
import com.github.juli220620.web.AddFlowerInfoRq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        imports = FlowerToxicityMapper.class,
        uses = FlowerToxicityMapper.class)
public abstract class FlowerInfoMapper {


    public FlowerInfoEntity rqToEntity(AddFlowerInfoRq rq) {
        var info = rqToEntityInternal(rq);
        info.getToxicity().setFlower(info);
        return info;
    }

    @Mapping(target = "toxicity", source = ".")
    protected abstract FlowerInfoEntity rqToEntityInternal(AddFlowerInfoRq rq);

}
