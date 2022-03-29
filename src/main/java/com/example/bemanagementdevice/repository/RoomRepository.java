package com.example.bemanagementdevice.repository;

import com.example.bemanagementdevice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findRoomByBlock_Id(int id);
    List<Room> findRoomByBlock_Name(String name);
}
