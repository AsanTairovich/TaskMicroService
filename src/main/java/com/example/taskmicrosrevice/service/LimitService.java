package com.example.taskmicrosrevice.service;

import com.example.taskmicrosrevice.model.entity.Limit;
import com.example.taskmicrosrevice.repository.LimitRepository;
import org.springframework.stereotype.Service;

@Service
public class LimitService {
    private final LimitRepository limitRepository;

    public LimitService(LimitRepository limitRepository) {
        this.limitRepository = limitRepository;
    }

    public Limit createLimit(Limit limit) {
        return limitRepository.save(limit);
    }
}
