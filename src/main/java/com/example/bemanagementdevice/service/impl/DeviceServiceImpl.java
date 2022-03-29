package com.example.bemanagementdevice.service.impl;

import com.example.bemanagementdevice.model.Device;
import com.example.bemanagementdevice.model.Room;
import com.example.bemanagementdevice.repository.DeviceRepository;
import com.example.bemanagementdevice.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public void save(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public Device findById(String id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Device device) {
        deviceRepository.delete(device);
    }

    @Override
    public List<Device> searchDevice(Optional<Integer> idCategory,String brand,Optional<Integer> idBlock,Optional<Integer> idRoom,String model,String cpuType,String memory,String storageType) {
        return deviceRepository.searchDevice(idCategory,brand,idBlock,idRoom,model,cpuType,memory,storageType);
    }

    @Override
    public List<Device> findAllByRoom_Id(int id) {
        return deviceRepository.findAllByRoom_Id(id);
    }
}
