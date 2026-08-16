package com.harsh.garagebookingbackend.controller;

import com.harsh.garagebookingbackend.model.Complaint;
import com.harsh.garagebookingbackend.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ComplaintController {

    private final ComplaintService complaintService;

    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return complaintService.create(complaint);
    }

    @GetMapping("/user/{id}")
    public List<Complaint> getUser(@PathVariable int id) {
        return complaintService.getUserComplaints(id);
    }
}