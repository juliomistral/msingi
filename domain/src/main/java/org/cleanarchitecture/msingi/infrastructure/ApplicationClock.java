package org.cleanarchitecture.msingi.infrastructure;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class ApplicationClock {
    private Clock internalClock;
    private ZoneId internalZoneId;


    public ApplicationClock(Clock systemClock) {
        this.internalClock = systemClock;
        this.internalZoneId = systemClock.getZone();
    }

    public ZonedDateTime now() {
        return this.internalClock
            .instant()
            .atZone(internalZoneId);
    }

    public ZonedDateTime startOfDay() {
        return now().toLocalDate().atStartOfDay().atZone(internalZoneId);
    }

    public ZonedDateTime endOfDay() {
        return now()
            .plusDays(1)
            .toLocalDate()
            .atStartOfDay()
            .atZone(internalZoneId)
            .minusSeconds(1);
    }
}
