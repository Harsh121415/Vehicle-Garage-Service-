package com.harsh.garagebookingbackend.repository;

import com.harsh.garagebookingbackend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByUserId(int userId);

    List<Booking> findByGarageId(int garageId);

    List<Booking> findByStatus(Booking.Status status);
}