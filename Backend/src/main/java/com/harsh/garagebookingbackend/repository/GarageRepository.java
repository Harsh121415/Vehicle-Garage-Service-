package com.harsh.garagebookingbackend.repository;

import com.harsh.garagebookingbackend.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage, Integer> {

    List<Garage> findByIsApproved(boolean isApproved);

    List<Garage> findByLocationContainingIgnoreCase(String location);
}