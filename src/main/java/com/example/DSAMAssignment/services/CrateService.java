package com.example.DSAMAssignment.services;

import com.example.DSAMAssignment.dtos.CrateDTO;
import com.example.DSAMAssignment.respository.CrateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrateService {

    @Autowired
    private CrateRepository crateRepository;

    public List<CrateDTO> getAllCrates() {
        List<CrateDTO> crateDTOS = new ArrayList<>();
        crateRepository.findAll().forEach(crate -> {
            crateDTOS.add(CrateDTO.valueOf(crate));
        });
        return crateDTOS;
    }
}
