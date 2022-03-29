package com.example.bemanagementdevice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fromRoom;
    private String toRoom;
    private LocalDate moveDate;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Device device;
}
