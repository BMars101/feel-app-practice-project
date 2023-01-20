package org.launchcode.practiceproject.controllers;

import org.launchcode.practiceproject.data.ProfileRepository;
import org.launchcode.practiceproject.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profile/user-profile")
    public String displayProfileForm(Model model){
        model.addAttribute("title", "Profile");
        return "/profile/user-profile";
    }

    @PostMapping("/profile/profile-view")
    public String processProfileEntry(@ModelAttribute @Valid Profile newProfile, Model model){
        Profile profile = profileRepository.findById(newProfile.getId()).orElse(new Profile());
        profile.setName(newProfile.getName());
        profile.setAge(newProfile.getAge());
        profile.setActivityLevel(newProfile.getActivityLevel());
        profile.setEmotionalGoals(newProfile.getEmotionalGoals());

        profileRepository.save(newProfile);
        return "redirect:/profile/profile-view";
    }

    @GetMapping("/profile/profile-view")
    public String displayEntryDetails(Model model){

        model.addAttribute("profileDetails", profileRepository.findAll());
        return "/profile/profile-view";
    }
}
