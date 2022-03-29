package com.example.bemanagementdevice.service;

import com.example.bemanagementdevice.model.Device;
import com.example.bemanagementdevice.model.Room;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<Device> findAll();
    void save(Device device);
    Device findById(String id);
    void delete(Device device);
    List<Device> searchDevice (Optional<Integer> idCategory,String brand,Optional<Integer> idBlock,Optional<Integer> idRoom,String model,String cpuType,String memory,String storageType);
    List<Device> findAllByRoom_Id(int id);
}
