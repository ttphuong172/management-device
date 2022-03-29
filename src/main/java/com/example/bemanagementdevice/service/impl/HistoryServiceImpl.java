package com.example.bemanagementdevice.service.impl;

import com.example.bemanagementdevice.model.History;
import com.example.bemanagementdevice.repository.HistoryRepository;
import com.example.bemanagementdevice.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    @Override
    public void save(History history) {
        historyRepository.save(history);
    }
}
