package com.harsh.garagebookingbackend.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Garage{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int ownerId;
    private String name;
    private String location;
    private String phone;
    private String services;
    private boolean isApproved;
}