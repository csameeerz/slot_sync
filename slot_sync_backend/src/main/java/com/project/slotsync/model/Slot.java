package com.project.slotsync.model;

import java.time.LocalDateTime;

public class Slot {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime date;

    private Long duration;

    private Long maxParticipants;

    private Long currParticipants;

    public Slot() {

    }

    public Long getCurrParticipants() {
        return currParticipants;
    }

    public void setCurrParticipants(Long currParticipants) {
        this.currParticipants = currParticipants;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Long maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "currParticipants=" + currParticipants +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
