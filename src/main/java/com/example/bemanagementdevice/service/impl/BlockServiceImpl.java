package com.example.bemanagementdevice.service.impl;

import com.example.bemanagementdevice.model.Block;
import com.example.bemanagementdevice.repository.BlockRepository;
import com.example.bemanagementdevice.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockRepository blockRepository;
    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public void save(Block block) {
        blockRepository.save(block);
    }

    @Override
    public Block findById(int id) {
        return blockRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Block block) {
        blockRepository.delete(block);
    }
}
