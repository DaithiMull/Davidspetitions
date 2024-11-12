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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}