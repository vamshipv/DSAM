package com.example.DSAMAssignment.dtos;

import com.example.DSAMAssignment.model.Bottle;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class BottleDTO {
    private Long id;
    private String name;
    private String bottlePic;
    private double volume;
    private boolean isAlcoholic;
    private double volumePercent;
    private double price;
    private String supplier;
    private int inStock;
    private int totalCount;

    public static BottleDTO valueof(Bottle bottle) {
        BottleDTO bottleDTO = new BottleDTO();
        BeanUtils.copyProperties(bottle, bottleDTO);
        return bottleDTO;
    }
}
