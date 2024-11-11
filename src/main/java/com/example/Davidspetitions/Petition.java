package com.example.Davidspetitions;

public class Petition {
    private final Long id;
    public String title;
    public String description;

    public Petition(long l, String climateChangePetition, String s) {
        this.id = l;
        this.title = climateChangePetition;
        this.description = s;
    }

    // ... other fields as needed

    // Add the getter method for id
    public Long getId() {
        return id;
    }
}
