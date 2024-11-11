package com.github.juli220620.web;

import com.github.juli220620.model.dto.FlowerInfoDto;
import com.github.juli220620.service.SearchService;
import com.github.juli220620.web.rq.SearchParamsRq;
import com.github.juli220620.web.rq.SearchRangedParamsRq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/by-params")
    public List<FlowerInfoDto> findBy(@RequestBody SearchParamsRq rq) {
        return service.findByParams(rq);
    }

    @GetMapping("/by-range")
    public List<FlowerInfoDto> findByRangedParams(@RequestBody SearchRangedParamsRq rq) {
        return service.findByRangedParams(rq);
    }

    @GetMapping("/non-toxic")
    public List<FlowerInfoDto> findNonToxic() {
        return service.findNonToxic();
    }
}
