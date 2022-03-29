package com.example.bemanagementdevice.repository;

import com.example.bemanagementdevice.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device,String> {
    @Query("SELECT d FROM Device d WHERE (:idCategory is null or d.category.id=:idCategory) and (d.brand like %:brand%)  and (:idBlock is null or d.block.id=:idBlock) and (:idRoom is null or d.room.id=:idRoom) and (d.model like %:model%) and (d.cpuType like %:cpuType%) and (d.memory like %:memory%) and (d.storageType like %:storageType%)")
    List<Device> searchDevice(@Param("idCategory") Optional<Integer> idCategory,@Param("brand") String brand,@Param("idBlock") Optional<Integer> idBlock,@Param("idRoom") Optional<Integer> idRoom, @Param("model") String model,String cpuType,String memory,String storageType);
    List<Device> findAllByRoom_Id(int id);
}
