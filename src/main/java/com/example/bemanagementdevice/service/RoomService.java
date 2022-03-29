package com.example.bemanagementdevice.service;

import com.example.bemanagementdevice.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    void save(Room room);
    Room findById(int id);
    void delete(Room room);
    List<Room> findRoomByBlock_Id(int id);
    List<Room> findRoomByBlock_Name(String name);
}
