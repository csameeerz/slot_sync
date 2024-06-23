package com.project.slotsync.model;

import com.project.slotsync.constants.BookingStatus;

import java.time.LocalDateTime;

public class Booking {

    private Long id;

    private Long slotId;

    private Long userId;

    private LocalDateTime date;

    private BookingStatus status;

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", slotId=" + slotId +
                ", userId=" + userId +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
