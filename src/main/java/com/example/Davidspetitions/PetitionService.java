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

    public Petition getPetitionById(Long id) {
        return petitions.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addPetition(Petition petition) {
        // Generate a unique ID for the new petition
        petition = new Petition(System.currentTimeMillis(), petition.title, petition.description);
        petitions.add(petition);
    }

    public void addSignature(Long petitionId, String name, String email) {
        Petition petition = getPetitionById(petitionId);
        if (petition != null) {
            // Add logic to store signatures (e.g., a list of signature objects)
            System.out.println("Signature added: " + name + " (" + email + ")");
        }
    }

    public List<Petition> searchPetitions(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return petitions; // Return all petitions if no keyword is provided
        }
        return petitions.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        p.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    // Other service methods if needed
}
