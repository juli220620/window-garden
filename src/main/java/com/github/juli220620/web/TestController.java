package com.github.juli220620.web;

import com.github.juli220620.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @PostMapping
    public void addFlowerInfo(@RequestBody AddFlowerInfoRq rq) {
        service.addFlowerInfo(rq);
    }

    @PutMapping("/{flowerId}")
    public void removeFlowerInfo(@PathVariable String flowerId) {
        service.removeFlowerInfo(flowerId);
    }
}