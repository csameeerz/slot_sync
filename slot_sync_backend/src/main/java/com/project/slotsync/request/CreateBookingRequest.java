package com.project.slotsync.request;

import com.project.slotsync.constants.BookingStatus;

import java.time.LocalDateTime;

public class CreateBookingRequest {

    private Long slotId;

    private Long userId;

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
