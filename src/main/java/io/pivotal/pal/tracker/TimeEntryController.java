/*
 * Copyright 2019 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository repo;

    public TimeEntryController(@Autowired TimeEntryRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        return new ResponseEntity<>(repo.create(timeEntry), HttpStatus.CREATED);
    }

    @GetMapping("/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeEntry = repo.find(timeEntryId);
        return new ResponseEntity<>(timeEntry, timeEntry == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

        return new ResponseEntity<>(repo.list(), HttpStatus.OK);

    }

    @PutMapping("/{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {

        TimeEntry update = repo.update(timeEntryId, expected);
        return new ResponseEntity<>(update
                , update == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);

    }

    @DeleteMapping("/{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        repo.delete(timeEntryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
