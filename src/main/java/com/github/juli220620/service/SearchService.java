package com.github.juli220620.service;

import com.github.juli220620.mapper.FlowerInfoMapper;
import com.github.juli220620.model.dto.FlowerInfoDto;
import com.github.juli220620.repo.FlowerInfoRepo;
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
        return flowerRepo.findAll().stream().map(mapper::entityToDto).collect(Collectors.toList());
    }

    public FlowerInfoDto findById(String id) {
        return flowerRepo.findById(id).map(mapper::entityToDto).orElse(new FlowerInfoDto());
    }
}
