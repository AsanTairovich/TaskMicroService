package com.example.taskmicrosrevice.controller;

import com.example.taskmicrosrevice.model.entity.Limit;
import com.example.taskmicrosrevice.service.LimitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitController {

    private final LimitService limitService;

    public LimitController(LimitService limitService) {
        this.limitService = limitService;
    }

    @PostMapping
    public ResponseEntity<Limit> createLimit(@RequestBody Limit limit) {
        Limit createdLimit = limitService.createLimit(limit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLimit);
    }
}
