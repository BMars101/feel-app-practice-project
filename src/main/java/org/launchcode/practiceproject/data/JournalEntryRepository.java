package org.launchcode.practiceproject.data;

import org.launchcode.practiceproject.models.JournalEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends CrudRepository<JournalEntry, Integer> {
}
