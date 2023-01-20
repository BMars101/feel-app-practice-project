package org.launchcode.practiceproject.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.launchcode.practiceproject.data.JournalEntryRepository;
import org.launchcode.practiceproject.data.UserRepository;
import org.launchcode.practiceproject.models.JournalEntry;
import org.launchcode.practiceproject.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
public class HomePageController {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping("")
    public String displayHomePage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        UserInfo user = authenticationController.getUserFromSession(session);
        model.addAttribute("username", "Hi " + user.getUsername() + "!");
        return "index";
    }
    @GetMapping("/entries/allEntries")
    public String displayHomeEntries(Model model){
        model.addAttribute("entries", journalEntryRepository.findAll());
        return "/entries/allEntries";
    }
    @GetMapping("/entries/detail")
    public String displayEntryDetails(@RequestParam Integer entryId, Model model){
        Optional<JournalEntry> result = journalEntryRepository.findById(entryId);
        if(result.isEmpty()){
            model.addAttribute("title", "Invalid Entry ID: " + entryId);
        } else {
            JournalEntry entry = result.get();
            model.addAttribute("title", "Details for " + entry.getToday());
            model.addAttribute("entry", entry);
        }

        return "/entries/detail";
    }
}
