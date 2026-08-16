package com.harsh.garagebookingbackend.controller;

import com.harsh.garagebookingbackend.model.Booking;
import com.harsh.garagebookingbackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/user/{id}")
    public List<Booking> getUserBookings(@PathVariable int id) {
        return bookingService.getUserBookings(id);
    }
}