package com.example.bemanagementdevice.controller;

import com.example.bemanagementdevice.model.Block;
import com.example.bemanagementdevice.model.Room;
import com.example.bemanagementdevice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("")
    public ResponseEntity<List<Room>> findAll(){
        return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Room room){
        roomService.save(room);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Room room){
        Room roomCurrent=roomService.findById(id);
        if (roomCurrent==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        roomCurrent.setName(room.getName());
        roomCurrent.setDescription(room.getDescription());
        roomCurrent.setBlock(room.getBlock());
        roomService.save(roomCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Room room=roomService.findById(id);
        if (room==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        roomService.delete(room);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping("blocks/{id}")
//    public ResponseEntity<List<Room>> findRoomByBlock_Id(@PathVariable int id){
//        return new ResponseEntity<>(roomService.findRoomByBlock_Id(id),HttpStatus.OK);
//    }

    @GetMapping("blocks/{name}")
    public ResponseEntity<List<Room>> findRoomByBlock_Name(@PathVariable String name){
        return new ResponseEntity<>(roomService.findRoomByBlock_Name(name),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Room> findById(@PathVariable int id){
        return new ResponseEntity<>(roomService.findById(id),HttpStatus.OK);
    }
}
