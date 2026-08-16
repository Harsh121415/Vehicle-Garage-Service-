package com.harsh.garagebookingbackend.controller;

import com.harsh.garagebookingbackend.model.Garage;
import com.harsh.garagebookingbackend.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GarageController {

    private final GarageService garageService;

    @PostMapping
    public Garage addGarage(@RequestBody Garage garage) {
        return garageService.addGarage(garage);
    }

    @GetMapping
    public List<Garage> getAll() {
        return garageService.getApprovedGarages();
    }
}