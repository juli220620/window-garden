package com.github.juli220620.service;

import com.github.juli220620.mapper.FlowerInfoMapper;
import com.github.juli220620.model.FlowerInfoEntity;
import com.github.juli220620.model.dto.FlowerInfoDto;
import com.github.juli220620.repo.FlowerInfoRepo;
import com.github.juli220620.web.rq.SearchParamsRq;
import com.github.juli220620.web.rq.SearchRangedParamsRq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final FlowerInfoRepo flowerRepo;
    private final FlowerInfoMapper mapper;

    public List<FlowerInfoDto> listAll() {
        return mapList(flowerRepo.findAll());
    }

    public FlowerInfoDto findById(String id) {
        return flowerRepo.findById(id)
                .map(mapper::entityToDto)
                .orElse(new FlowerInfoDto());
    }

    public List<FlowerInfoDto> findNonToxic() {
        return mapList(flowerRepo.findNonToxic());
    }

    public List<FlowerInfoDto> findByParams(SearchParamsRq rq) {
        return mapList(flowerRepo.findByParams(rq));
    }

    public List<FlowerInfoDto> findByRangedParams(SearchRangedParamsRq rq) {
        return mapList(flowerRepo.findByRangedParams(rq));
    }

    private List<FlowerInfoDto> mapList(List<FlowerInfoEntity> entities) {
        return entities.stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
