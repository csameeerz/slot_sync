package com.project.slotsync.controller;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.Booking;
import com.project.slotsync.request.CreateBookingRequest;
import com.project.slotsync.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ApiResponse<Booking> bookSlot(@RequestBody CreateBookingRequest request) {
        return bookingService.bookSlot(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ApiResponse<Booking> changeStatusOfBooking(@PathVariable Long id, @RequestParam String status) {
        return bookingService.changeStatusOfBooking(id, status);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<Booking>> showAllBookings() {
        return bookingService.showAllBookings();
    }

    @GetMapping("/slots/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<Booking>> showAllBookingsForSlot(@PathVariable Long id) {
        return bookingService.showAllBookingsForSlot(id);
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('USER')")
    public ApiResponse<List<Booking>> showAllBookingsByUser(@PathVariable Long id) {
        return bookingService.showAllBookingsByUser(id);
    }
}
