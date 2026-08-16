package com.harsh.garagebookingbackend.service;

import com.harsh.garagebookingbackend.model.Complaint;
import com.harsh.garagebookingbackend.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public Complaint create(Complaint complaint) {
        complaint.setStatus(Complaint.Status.OPEN);
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getUserComplaints(int userId) {
        return complaintRepository.findByUserId(userId);
    }
}