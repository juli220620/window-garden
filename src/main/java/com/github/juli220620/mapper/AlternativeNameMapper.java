package com.github.juli220620.mapper;

import com.github.juli220620.model.AlternativeNameEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlternativeNameMapper {

    List<AlternativeNameEntity> stringListToAlternativeNameEntityList(List<String> list);

    List<String> entityListToStringList(List<AlternativeNameEntity> entities);

    @Mapping(target = "flower", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "alternativeName", source = ".")
    AlternativeNameEntity map(String alternativeName);

    default String entityToString(AlternativeNameEntity entity) {
        return entity.getAlternativeName();
    }
}
