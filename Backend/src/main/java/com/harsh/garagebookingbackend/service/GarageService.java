package com.harsh.garagebookingbackend.service;

import com.harsh.garagebookingbackend.model.Garage;
import com.harsh.garagebookingbackend.repository.GarageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GarageService {

    private final GarageRepository garageRepository;

    public Garage addGarage(Garage garage) {
        garage.setApproved(false);
        return garageRepository.save(garage);
    }

    public List<Garage> getApprovedGarages() {
        return garageRepository.findByIsApproved(true);
    }
}