package com.example.DSAMAssignment.services;

import com.example.DSAMAssignment.dtos.BottleDTO;
import com.example.DSAMAssignment.respository.BottleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BottleService {

    @Autowired
    private BottleRepository bottleRepository;

    public List<BottleDTO> getAllBottles() {
        List<BottleDTO> bottleDTOS = new ArrayList<>();
        bottleRepository.findAll().forEach(bottle -> {
            bottleDTOS.add(BottleDTO.valueof(bottle));
        });
        return bottleDTOS;
    }

}
