package com.example.DSAMAssignment.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDTO {
    private List<BottleDTO> bottleDTOS;
    private List<CrateDTO> crateDTOS;
}
