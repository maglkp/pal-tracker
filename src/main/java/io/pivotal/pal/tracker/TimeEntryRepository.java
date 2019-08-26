/*
 * Copyright 2019 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package io.pivotal.pal.tracker;

import java.util.List;

public class TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry) {

        return timeEntry;
    }

    public TimeEntry find(long timeEntryId) {

        return null;
    }

    public List<TimeEntry> list() {

        return null;
    }

    public TimeEntry update(long eq, TimeEntry any) {

        return any;
    }

    public void delete(long timeEntryId) {

    }
}
