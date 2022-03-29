package com.example.bemanagementdevice.service;

import com.example.bemanagementdevice.model.Block;

import java.util.List;

public interface BlockService {
    List<Block> findAll();
    void save(Block block);
    Block findById(int id);
    void delete(Block block);
}
