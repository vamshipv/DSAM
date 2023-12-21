package com.example.DSAMAssignment.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private Long id;
    private double price;

    private List<OrderItemDTO> orderItemDTOS;

}
