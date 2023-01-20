package org.launchcode.practiceproject.models;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class JournalEntry extends AbstractEntity {

    private String dailyWaterLog;
    private String mood;

    private String detailedEntry;
    private LocalDate today;

    public JournalEntry(String dailyWaterLog, String mood, String detailedEntry) {
        this.dailyWaterLog = dailyWaterLog;
        this.mood = mood;
        this.detailedEntry = detailedEntry;
        this.today = LocalDate.now();
    }

    public JournalEntry(){}

    public String getDailyWaterLog() {
        return dailyWaterLog;
    }

    public void setDailyWaterLog(String dailyWaterLog) {
        this.dailyWaterLog = dailyWaterLog;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getDetailedEntry() {
        return detailedEntry;
    }

    public void setDetailedEntry(String detailedEntry) {
        this.detailedEntry = detailedEntry;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }
}
