package com.harsh.garagebookingbackend.controller;

import com.harsh.garagebookingbackend.model.Garage;
import com.harsh.garagebookingbackend.repository.GarageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AdminController {

    private final GarageRepository garageRepository;

    @GetMapping("/pending-garages")
    public List<Garage> getPendingGarages() {
        return garageRepository.findByIsApproved(false);
    }

    @PutMapping("/approve/{id}")
    public Garage approveGarage(@PathVariable int id) {

        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garage not found"));

        garage.setApproved(true);
        return garageRepository.save(garage);
    }
}