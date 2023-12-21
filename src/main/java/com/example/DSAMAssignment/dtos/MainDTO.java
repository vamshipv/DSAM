package com.example.DSAMAssignment.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MainDTO {

    List<BottleDTO> bottleDTOS;

    List<CrateDTO> crateDTOS;

    List<OrderDTO> orderDTOS;
}
