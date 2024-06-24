package com.project.slotsync.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class UpdateSlotRequest {

    private String description;

    private Long maxParticipants;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Long maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
}
