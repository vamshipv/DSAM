package com.example.DSAMAssignment.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private LocalDate birthday;
}
