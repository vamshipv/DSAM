package com.example.DSAMAssignment.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
    private Long id;
    private String position;
    private double price;
    private String name;
    private String image;

}
