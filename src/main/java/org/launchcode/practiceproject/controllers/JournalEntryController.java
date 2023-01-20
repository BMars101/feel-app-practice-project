package org.launchcode.practiceproject.controllers;

import org.launchcode.practiceproject.data.JournalEntryRepository;
import org.launchcode.practiceproject.models.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JournalEntryController {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @GetMapping("addEntry")
    public String displayJournalEntryForm(Model model){
        model.addAttribute("title", "Daily Entry");
        return "addEntry";
    }

    @PostMapping("allEntries")
    public String processJournalEntry(@RequestParam String dailyWaterLog,@RequestParam String mood, @RequestParam String detailedEntry){
        journalEntryRepository.save(new JournalEntry(dailyWaterLog, mood, detailedEntry));
        return "redirect:allEntries";
    }

    @GetMapping("delete")
    public String deleteEventForm(Model model){
        model.addAttribute("delete", "Delete Events");
        model.addAttribute("entries", journalEntryRepository.findAll());
        return "delete";
    }

    @PostMapping("delete")
    public String deleteEvents(@RequestParam(required = false) int[] entryIds){

        if(entryIds != null){
            for(int id : entryIds){
                journalEntryRepository.deleteById(id);
            }
        }
        return "redirect:allEntries";
    }

}
