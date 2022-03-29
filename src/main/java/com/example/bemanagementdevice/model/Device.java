package com.example.bemanagementdevice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Device {
    @Id

    private String id;

    @ManyToOne
    @JoinColumn
    private Category category;

    private LocalDate useDate;

    private String brand;
    private String model;
    private String serial;

//    Computer

    private String cpuType;


    private String cpuGeneration;
    private String memory;
    private String monitor;


    private String storageType;
    private int storageSize;

    private String storageType2;
    private int storageSize2;

    private String description;

    @ManyToOne
    @JoinColumn
    private Block block;


    @ManyToOne
    @JoinColumn

    private Room room;

    @OneToMany(mappedBy = "device")

    List<History> historyList;

}

