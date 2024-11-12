package com.example.Davidspetitions;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionService {
    private List<Petition> petitions;

    // Initialize petitions list once in the constructor
    public PetitionService() {
        petitions = new ArrayList<>();
        petitions.add(new Petition(1L, "Save the Pandas!", "Description1"));
        petitions.add(new Petition(2L, "Build a Dog Park!", "Description2"));
        petitions.add(new Petition(3L, "More Funding for Schools!", "Description3"));
    }

    public List<Petition> getAllPetitions() {
        return petitions; // Return the current list without reinitializing
    }

    public void addPetition(Petition petition) {
        // Generate a unique ID for the new petition
        petition = new Petition(System.currentTimeMillis(), petition.title, petition.description);
        petitions.add(petition);
    }



    // Other service methods if needed
}
