package com.example.Davidspetitions;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionService {
    private List<Petition> petitions = new ArrayList<>();

    public List<Petition> getAllPetitions() {
        petitions.clear(); // Clear any existing petitions (optional)
        petitions.add(new Petition(1L,"Save the Pandas!", "Description1"));
        petitions.add(new Petition(2L,"Build a Dog Park!", "Description2"));
        petitions.add(new Petition(3L,"More Funding for Schools!", "Description3"));
        return petitions;
    }

    public void addPetition(Petition petition) {
        petitions.add(petition);
    }

    public List<Petition> getPetitions() {
        return petitions;
    }

    public void setPetitions(List<Petition> petitions) {
        this.petitions = petitions;
    }

    // ... other methods for adding petitions
}
