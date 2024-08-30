package com.github.juli220620.service;

import com.github.juli220620.mapper.FlowerInfoMapper;
import com.github.juli220620.repo.FlowerInfoRepo;
import com.github.juli220620.web.AddFlowerInfoRq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final FlowerInfoRepo repo;
    private final FlowerInfoMapper mapper;

    public void addFlowerInfo(AddFlowerInfoRq rq) {
        var flowerEntity = mapper.rqToEntity(rq);
        repo.save(flowerEntity);
    }

    public void removeFlowerInfo(String flowerId) {
        repo.deleteById(flowerId);
    }
}
