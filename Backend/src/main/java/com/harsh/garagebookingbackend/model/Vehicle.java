package com.harsh.garagebookingbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String vehicleType;
    private String vehicleNumber;
    private String model;
}