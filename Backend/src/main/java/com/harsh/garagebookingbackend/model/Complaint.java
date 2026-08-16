package com.harsh.garagebookingbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Complaint{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        OPEN,IN_PROGRESS,RESOLVED
    }
}
