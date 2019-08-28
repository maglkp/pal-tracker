/*
 * Copyright 2019 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> data = new HashMap<>();
    private long index = 1;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(index++);
        data.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return data.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(data.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(!data.containsKey(id)) {
            return null;
        }

        timeEntry.setId(id);
        data.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long timeEntryId) {
        data.remove(timeEntryId);
    }
}
