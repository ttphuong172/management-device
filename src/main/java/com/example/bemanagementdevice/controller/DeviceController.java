package com.example.bemanagementdevice.controller;

import com.example.bemanagementdevice.model.*;
import com.example.bemanagementdevice.service.DeviceService;
import com.example.bemanagementdevice.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/devices")
@CrossOrigin
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private HistoryService historyService;

    @GetMapping("")
    public ResponseEntity<List<Device>> findAll() {
        return new ResponseEntity<>(deviceService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Device device) {
        deviceService.save(device);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody Device device) {
        Device deviceCurrent = deviceService.findById(id);
        if (deviceCurrent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        deviceCurrent.setCategory(device.getCategory());
        deviceCurrent.setUseDate(device.getUseDate());
        deviceCurrent.setBrand(device.getBrand());
        deviceCurrent.setModel(device.getModel());
        deviceCurrent.setSerial(device.getSerial());
        deviceCurrent.setCpuType(device.getCpuType());
        deviceCurrent.setCpuGeneration(device.getCpuGeneration());
        deviceCurrent.setMemory(device.getMemory());
        deviceCurrent.setMonitor(device.getMonitor());
        deviceCurrent.setStorageType(device.getStorageType());
        deviceCurrent.setStorageSize(device.getStorageSize());
        deviceCurrent.setStorageType2(device.getStorageType2());
        deviceCurrent.setStorageSize2(device.getStorageSize2());
        deviceCurrent.setDescription(device.getDescription());
        deviceCurrent.setBlock(device.getBlock());
        deviceCurrent.setRoom(device.getRoom());
        deviceService.save(deviceCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        Device device = deviceService.findById(id);
        if (device == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        deviceService.delete(device);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<Device>> searchDevice(@RequestParam Optional<Integer> idCategory, @RequestParam(required = false) String brand, Optional<Integer> idBlock, Optional<Integer> idRoom, @RequestParam(required = false) String model, @RequestParam(required = false) String cpuType, @RequestParam(required = false) String memory, @RequestParam(required = false) String storageType) {
        System.out.println(brand);
        return new ResponseEntity<>(deviceService.searchDevice(idCategory, brand, idBlock, idRoom, model, cpuType, memory, storageType), HttpStatus.OK);
    }

    @PutMapping("move/{id}")
    public ResponseEntity<String> move(@PathVariable String id, @RequestBody MoveDTO moveDTO) {
        History history=new History();
        Device deviceCurrent = deviceService.findById(id);
        if (deviceCurrent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        System.out.println(deviceCurrent.getRoom().getName());
        history.setFromRoom(deviceCurrent.getRoom().getName()+"-"+deviceCurrent.getRoom().getBlock().getName());

        System.out.println(moveDTO.getRoom().getName());
        history.setToRoom(moveDTO.getRoom().getName()+"-"+ moveDTO.getRoom().getBlock().getName());

        history.setMoveDate(LocalDate.now());
        history.setMoveDate(moveDTO.getMoveDate());
        history.setDevice(deviceCurrent);


        deviceCurrent.setBlock(moveDTO.getRoom().getBlock());
        deviceCurrent.setRoom(moveDTO.getRoom());

        deviceService.save(deviceCurrent);
        historyService.save(history);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("rooms/{id}")
    public ResponseEntity<List<Device>> findAllByRoom_Id(@PathVariable int id){
        return new ResponseEntity<>(deviceService.findAllByRoom_Id(id),HttpStatus.OK);
    }

}
