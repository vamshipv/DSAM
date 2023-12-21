package com.example.DSAMAssignment.dtos;


import com.example.DSAMAssignment.model.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class AddreesDTO {
    private Long id;
    private String street;
    private String number;
    private String postalCode;
    private Long usersId;

    public static AddreesDTO valueOf(Address address) {
        AddreesDTO addreesDTO = new AddreesDTO();
        BeanUtils.copyProperties(address, addreesDTO);
        return addreesDTO;
    }
}
