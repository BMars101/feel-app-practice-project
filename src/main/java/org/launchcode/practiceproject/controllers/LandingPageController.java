package org.launchcode.practiceproject.controllers;

import org.launchcode.practiceproject.models.WaterNeeds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LandingPageController {

    private WaterNeeds waterNeeds = new WaterNeeds();
    @GetMapping("check-needs")
    public String displayLandingPage(Model model){
        model.addAttribute("waterNeeds", new WaterNeeds());
        return "check-needs";
    }
    @GetMapping("water-needs-teaser")
    public String displayWaterNeeds(Model model){
        model.addAttribute("waterNeeds", waterNeeds.getWaterNeeds());
        return "water-needs-result";
    }

    @PostMapping("water-needs-teaser")
    public String calculateWaterFromForm(@RequestParam double weight, @RequestParam(required = false) double dailyActivityTime){
        waterNeeds = new WaterNeeds(weight, dailyActivityTime);
        //System.out.println(waterNeeds.getWaterNeeds());
        return "redirect:water-needs-teaser";

    }





}
