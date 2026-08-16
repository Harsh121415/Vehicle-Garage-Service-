package com.harsh.garagebookingbackend.service;

import com.harsh.garagebookingbackend.model.Booking;
import com.harsh.garagebookingbackend.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        booking.setStatus(Booking.Status.PENDING);
        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(int userId) {
        return bookingRepository.findByUserId(userId);
    }
}