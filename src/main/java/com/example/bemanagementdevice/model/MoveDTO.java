package com.example.bemanagementdevice.model;

import lombok.*;

import java.time.LocalDate;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoveDTO {
    private LocalDate moveDate;
    private Room room;
}
