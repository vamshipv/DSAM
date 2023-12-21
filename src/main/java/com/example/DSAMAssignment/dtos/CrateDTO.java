package com.example.DSAMAssignment.dtos;


import com.example.DSAMAssignment.model.Crate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class CrateDTO {
    private Long id;
    private String name;
    private String cratePic;
    private int noOfBottles;
    private double price;
    private int cratesInStock;
    private int totalCount;

    public static CrateDTO valueOf(Crate crate) {
        CrateDTO crateDTO = new CrateDTO();
        BeanUtils.copyProperties(crate, crateDTO);
        return crateDTO;
    }
}
