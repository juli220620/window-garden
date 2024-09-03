package com.github.juli220620.web;

import com.github.juli220620.model.dto.FlowerInfoDto;
import com.github.juli220620.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/flower")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService service;

    @GetMapping
    public List<FlowerInfoDto> listAll() {
        return service.listAll();
    }

    @GetMapping("/{flowerId}")
    public FlowerInfoDto findById(@PathVariable String flowerId) {
        return service.findById(flowerId);
    }

    public List<FlowerInfoDto> findBy() {
        return null;
    }
}
