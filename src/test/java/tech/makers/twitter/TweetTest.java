package tech.makers.twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TweetTest {

    private Clock mockTime; // 'Hoisted' this bad-boy out from the setup to allow it to be used throughout this script!

    @BeforeEach
        void setup() {
        String expectedTime = "1989-06-22T16:00:00Z"; // This is a generic TIMESTAMP view to the millisecond.
        ZoneId zoneId = ZoneId.systemDefault();
        mockTime = Clock.fixed(Instant.parse(expectedTime), zoneId);
    }

    @Test
    void testConstructs() {
        Tweet subject = new Tweet("Hello, world!", mockTime);
        assertEquals("Hello, world!", subject.getBody());
        assertEquals(null, subject.getId());
        assertEquals(LocalDateTime.now(mockTime), subject.getCreatedAt());
    }

    @Test
    void testToString() {
        Tweet subject = new Tweet("Hello, world!", mockTime);
        assertEquals("Tweet[id=null, body='Hello, world!', createdAt=" + LocalDateTime.now(mockTime) + "]", subject.toString());
    }
}
