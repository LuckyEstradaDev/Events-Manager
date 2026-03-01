package com.example.eventsmanager.models;

public class EventModel {

    private String id;
    private String eventHandlerId;
    private String eventName;
    private String description;
    private String location;
    private String startDate;
    private String endDate;
    private String category;
    private int capacity;
    private String createdAt;

    // Constructor
    public EventModel(String id, String eventHandlerId, String eventName, String description, String location,
                 String startDate, String endDate, String category, int capacity, String createdAt) {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.capacity = capacity;
        this.createdAt = createdAt;
    }

    // Empty constructor
    public EventModel() {}

    // Getters
    public String getId() {
        return id;
    }

    public String getEventHandlerId() {
        return eventHandlerId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setEventHandlerId(String eventHandlerId) {
        this.eventHandlerId = eventHandlerId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}