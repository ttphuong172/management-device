package com.example.bemanagementdevice.service.impl;

import com.example.bemanagementdevice.model.Room;
import com.example.bemanagementdevice.repository.RoomRepository;
import com.example.bemanagementdevice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImp implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Room findById(int id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Room room) {
        roomRepository.delete(room);
    }

    @Override
    public List<Room> findRoomByBlock_Id(int id) {
        return roomRepository.findRoomByBlock_Id(id);
    }

    @Override
    public List<Room> findRoomByBlock_Name(String name) {
        return roomRepository.findRoomByBlock_Name(name);
    }


}
