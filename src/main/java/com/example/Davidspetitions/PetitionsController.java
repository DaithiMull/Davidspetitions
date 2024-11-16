package com.example.Davidspetitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Controller
public class PetitionsController {

    @Autowired
    private PetitionService petitionService;

    @GetMapping("/")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("/petitions")
    public String viewAllPetitions(Model model) {
        List<Petition> petitions = petitionService.getAllPetitions();
        System.out.println("Number of petitions: " + petitions.size()); // Debug statement
        model.addAttribute("petitions", petitions);
        return "petitions";
    }

    @GetMapping("/petitions/{id}")
    public String viewPetition(@PathVariable Long id, Model model) {
        Petition petition = petitionService.getPetitionById(id);
        if (petition == null) {
            return "error"; // Add an error page if the petition is not found
        }
        model.addAttribute("petition", petition);
        return "petition-details";
    }


    @GetMapping("/create-petition")
    public String createPetitionForm() {
        return "create-petition";
    }

    @GetMapping("/search")
    public String searchPetitions(String keyword, Model model) {
        List<Petition> searchResults = petitionService.searchPetitions(keyword);
        model.addAttribute("petitions", searchResults);
        model.addAttribute("keyword", keyword);
        return "search-results";
    }



    @PostMapping("/create-petition")
    public String createPetition(Petition petition) {
        petitionService.addPetition(petition);
        return "redirect:/petitions";
    }

    @PostMapping("/petitions/{id}/sign")
    public String signPetition(@PathVariable Long id, String name, String email) {
        Petition petition = petitionService.getPetitionById(id);
        if (petition != null) {
            petitionService.addSignature(id, name, email);
            return "redirect:/thank-you";
        }
        return "error";
    }

    @GetMapping("/thank-you")
    public String thankYou() {
        return "thank-you";
    }



    // ... other methods for searching, viewing individual petitions, and signing petitions
}
