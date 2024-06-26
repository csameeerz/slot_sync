package com.project.slotsync.controller;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.Slot;
import com.project.slotsync.model.User;
import com.project.slotsync.request.CreateSlotRequest;
import com.project.slotsync.request.UpdateSlotRequest;
import com.project.slotsync.service.SlotService;
import com.project.slotsync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<Slot>> createNewSlot(@RequestBody CreateSlotRequest request) {
        ApiResponse<Slot> slot = slotService.createNewSlot(request);
        if (slot.getData() != null) {
            return ResponseEntity.ok(slot);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(slot);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Slot>> updateExistingSlot(@PathVariable Long id, @RequestBody UpdateSlotRequest request) {
        ApiResponse<Slot> slot =  slotService.updateExistingSlot(id, request);
        if (slot.getData() != null) {
            return ResponseEntity.ok(slot);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(slot);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<String>> deleteExistingSlot(@PathVariable Long id) {
        ApiResponse<String> slot = slotService.deleteExistingSlot(id);
        if (slot.getData() != null) {
            return ResponseEntity.ok(slot);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(slot);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Slot>>> showAllExistingSlots() {
        ApiResponse<List<Slot>> slots = slotService.showAllExistingSlots();
        if (slots.getData() != null) {
            return ResponseEntity.ok(slots);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(slots);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Slot>> showExistingSlot(@PathVariable Long id) {
        ApiResponse<Slot> slot = slotService.showExistingSlot(id);
        if (slot.getData() != null) {
            return ResponseEntity.ok(slot);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(slot);
        }
    }

//    @GetMapping
//    public ApiResponse<List<Slot>> searchExistingSlots() {
//        return null;
//    }

    @PutMapping("/rating/{id}")
    public ResponseEntity<ApiResponse<String>> rateExistingSlot(@PathVariable Long id, @RequestParam Double rating) {
        ApiResponse<String> slot = slotService.rateExistingSlot(id, rating);
        if (slot.getData() != null) {
            return ResponseEntity.ok(slot);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(slot);
        }
    }
}
