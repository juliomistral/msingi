package org.cleanarchitecture.msingi.infrastructure;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.*;


public class ApplicationClockTest {
    private static Instant TEST_NOW = Instant.parse("2007-12-03T10:15:30Z");
    private static Instant TEST_SOD = Instant.parse("2007-12-03T00:00:00Z");
    private static Instant TEST_EOD = Instant.parse("2007-12-03T23:59:59Z");

    private ApplicationClock clock;


    @Before
    public void setUp() throws Exception {
        Clock testClock = Clock.fixed(TEST_NOW, ZoneId.of("UTC"));
        clock = new ApplicationClock(testClock);
    }

    @Test
    public void nowIsEqualToTheCurrentTimeOfTheProvidedClock() throws Exception {
        Instant result = clock.now().toInstant();

        Assertions.assertThat(result).isEqualByComparingTo(TEST_NOW);
    }

    @Test
    public void startOfDayIsEqualToStartOfDayOfTheProvidedClock() throws Exception {
        Instant result = clock.startOfDay().toInstant();

        Assertions.assertThat(result).isEqualByComparingTo(TEST_SOD);
    }

    @Test
    public void endOfDayIsEqualToEndOfDayOfTheProvidedClock() throws Exception {
        Instant result = clock.endOfDay().toInstant();

        Assertions.assertThat(result).isEqualByComparingTo(TEST_EOD);
    }
}
