package com.example.bemanagementdevice.controller;

import com.example.bemanagementdevice.model.Block;
import com.example.bemanagementdevice.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blocks")
@CrossOrigin
public class BlockController {
    @Autowired
    private BlockService blockService;
    @GetMapping("")
    public ResponseEntity<List<Block>> findAll(){
        return new ResponseEntity<>(blockService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Block block){
        blockService.save(block);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Block block){
        Block blockCurrent=blockService.findById(id);
        if (blockCurrent==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blockCurrent.setName(block.getName());
        blockCurrent.setDescription(block.getDescription());
        blockService.save(blockCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Block block=blockService.findById(id);
        if (block==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blockService.delete(block);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
