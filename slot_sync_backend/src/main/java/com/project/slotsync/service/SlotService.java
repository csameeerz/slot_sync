package com.project.slotsync.service;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.Slot;
import com.project.slotsync.model.User;
import com.project.slotsync.repository.SlotRepository;
import com.project.slotsync.repository.UserRepository;
import com.project.slotsync.request.CreateSlotRequest;
import com.project.slotsync.request.UpdateSlotRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public ApiResponse<Slot> createNewSlot(CreateSlotRequest request) {
        Slot slot = slotRepository.save(new Slot(0L, 0.0, 0L, request.getDate(), request.getDescription(), request.getDuration(), request.getMaxParticipants(), request.getTitle()));
        return new ApiResponse<>("Slot created successfully", slot);
    }

    public ApiResponse<Slot> updateExistingSlot(Long id, UpdateSlotRequest request) {
        Optional<Slot> existingSlot = slotRepository.findById(id);
        if (existingSlot.isPresent()) {
            Slot newSlot = existingSlot.get();
            if (request.getDescription() != null) newSlot.setDescription(request.getDescription());
            if (request.getMaxParticipants() != null) newSlot.setMaxParticipants(request.getMaxParticipants());
            slotRepository.save(newSlot);
            return new ApiResponse<>("Slot's details updated successfully", newSlot);
        } else {
            return new ApiResponse<>("No slot found to update", null);
        }
    }

    public ApiResponse<String> deleteExistingSlot(Long id) {
        if (slotRepository.existsById(id)) {
            slotRepository.deleteById(id);
            return new ApiResponse<>("Slot deleted successfully", "Deleted Slot Id: " + id);
        } else {
            return new ApiResponse<>("No slot found to delete", null);
        }
    }

    public ApiResponse<List<Slot>> showAllExistingSlots() {
        List<Slot> allSlots = slotRepository.findAll();
        if (allSlots.isEmpty()) {
            return new ApiResponse<>("No slots found", null);
        } else {
            return new ApiResponse<>("Slots' details fetched successfully", allSlots);
        }
    }

    public ApiResponse<Slot> showExistingSlot(Long id) {
        Optional<Slot> slot = slotRepository.findById(id);

        if (slot.isPresent()) {
            return new ApiResponse<>("Slot's details fetched successfully", slot.get());
        }
        else {
            return new ApiResponse<>("No slot found", null);
        }
    }

    public ApiResponse<String> rateExistingSlot(Long id, Double rating) {
        Optional<Slot> slot = slotRepository.findById(id);

        if (slot.isPresent()) {
            Slot newSlot = slot.get();
            newSlot.setNoOfRatings(newSlot.getNoOfRatings() + 1);
            newSlot.setCurrRating(newSlot.getCurrRating() + rating);
            slotRepository.save(newSlot);
            Double updatedRating = (newSlot.getCurrRating() / newSlot.getNoOfRatings());
            return new ApiResponse<>("Slot's rating updated successfully", "Updated Rating: " + updatedRating);
        }
        else {
            return new ApiResponse<>("No slot found", null);
        }
    }
}
