//package com.project.slotsync.controller;
//
//import com.project.slotsync.constants.ApiResponse;
//import com.project.slotsync.model.Booking;
//import com.project.slotsync.model.Slot;
//import com.project.slotsync.service.BookingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/bookings")
//public class BookingController {
//
//    @Autowired
//    public BookingService bookingService;
//
//    @GetMapping
//    public ApiResponse<List<Booking>> showAllBookingsForSlot() {
//        return null;
//    }
//
//    @PostMapping
//    public ApiResponse<Booking> bookSlot() {
//        return null;
//    }
//
//    @GetMapping("/users/{id}")
//    public ApiResponse<Booking> showAllBookingsByUser(@PathVariable Long id) {
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public ApiResponse<Booking> cancelBooking(@PathVariable Long id) {
//        return null;
//    }
//}
