package com.example.bemanagementdevice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {
    private String username;
    private String password;

}
