package com.harsh.garagebookingbackend.repository;

import com.harsh.garagebookingbackend.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    List<Complaint> findByUserId(int userId);

    List<Complaint> findByStatus(Complaint.Status status);
}