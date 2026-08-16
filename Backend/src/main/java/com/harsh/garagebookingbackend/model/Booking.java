package com.harsh.garagebookingbackend.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Booking{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int garageId;
    private int vehicleId;
    private String bookingDate;


    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        PENDING,ACCEPTED,REJECTED,COMPLETED
    }
}