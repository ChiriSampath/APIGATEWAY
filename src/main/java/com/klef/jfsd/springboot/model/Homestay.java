package com.klef.jfsd.springboot.model;



public class Homestay {

    private Long id;
    private String name;
    private String location;
    private String description;

    // Default constructor
    public Homestay() {
    }

    // Constructor with parameters
    public Homestay(Long id, String name, String location, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Optional: Override toString() for better representation in logs or debugging
    @Override
    public String toString() {
        return "Homestay [id=" + id + ", name=" + name + ", location=" + location + ", description=" + description + "]";
    }
}

