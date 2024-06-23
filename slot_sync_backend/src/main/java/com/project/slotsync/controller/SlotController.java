//package com.project.slotsync.controller;
//
//import com.project.slotsync.constants.ApiResponse;
//import com.project.slotsync.model.Slot;
//import com.project.slotsync.model.User;
//import com.project.slotsync.service.SlotService;
//import com.project.slotsync.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/slots")
//public class SlotController {
//
//    @Autowired
//    private SlotService slotService;
//
//    @GetMapping
//    public ApiResponse<List<Slot>> showAllExistingSlots() {
//        return null;
//    }
//
//    @GetMapping("/{id}")
//    public ApiResponse<Slot> showExistingSlot(@PathVariable Long id) {
//        return null;
//    }
//
//    @GetMapping
//    public ApiResponse<List<Slot>> searchExistingSlots() {
//        return null;
//    }
//
//    @PostMapping
//    public ApiResponse<String> rateExistingSlot() {
//        return null; //Maintain two (no of ratings, and sum of all) variable, keep averaging that variable.
//    }
//
//    @PostMapping
//    public ApiResponse<Slot> createNewSlot() {
//        return null;
//    }
//
//    @PutMapping
//    public ApiResponse<Slot> updateExistingSlot() {
//        return null;
//    }
//
//    @DeleteMapping
//    public ApiResponse<String> deleteExistingSlot() {
//        return null;
//    }
//
//    @PutMapping
//    public ApiResponse<Slot> cancelExistingSlot() {
//        return null;
//    }
//}
