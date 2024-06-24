package com.project.slotsync.controller;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.Slot;
import com.project.slotsync.model.User;
import com.project.slotsync.request.CreateSlotRequest;
import com.project.slotsync.request.UpdateSlotRequest;
import com.project.slotsync.service.SlotService;
import com.project.slotsync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Slot> createNewSlot(@RequestBody CreateSlotRequest request) {
        return slotService.createNewSlot(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Slot> updateExistingSlot(@PathVariable Long id, @RequestBody UpdateSlotRequest request) {
        return slotService.updateExistingSlot(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<String> deleteExistingSlot(@PathVariable Long id) {
        return slotService.deleteExistingSlot(id);
    }

    @GetMapping
    public ApiResponse<List<Slot>> showAllExistingSlots() {
        return slotService.showAllExistingSlots();
    }

    @GetMapping("/{id}")
    public ApiResponse<Slot> showExistingSlot(@PathVariable Long id) {
        return slotService.showExistingSlot(id);
    }

//    @GetMapping
//    public ApiResponse<List<Slot>> searchExistingSlots() {
//        return null;
//    }

    @PutMapping("/rating/{id}")
    public ApiResponse<String> rateExistingSlot(@PathVariable Long id, @RequestParam Double rating) {
        return slotService.rateExistingSlot(id, rating);
    }
}
