package com.example.Davidspetitions;

public class Petition {
    private Long id; // Remove final
    public String title;
    public String description;

    // Default constructor required for form binding
    public Petition() {}

    public Petition(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and setters for title and description if needed
}