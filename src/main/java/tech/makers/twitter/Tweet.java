package tech.makers.twitter;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;

// This is a Spring Entity.
// It represents a Model in MVC.
// And each instance, when saved, will refer to a row in the 'tweet' table in the database.
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String body;
    private LocalDateTime createdAt;

    protected Tweet() {}

    public Tweet(String body) {
        this.body = body;
        this.createdAt = LocalDateTime.now( Clock.systemUTC() ); // This will ensure that any tweet are created with UTC as standard.
    }

    public Tweet(String body, Clock clock) {
        this.body = body;
        this.createdAt = LocalDateTime.now( clock ); // This constructor allows for testing with a mockTime
    }

    @Override
    public String toString() {
        return String.format("Tweet[id=%d, body='%s', createdAt=%s]", id, body, createdAt);
    }

    public Long getId() {
        return this.id;
    }

    public String getBody() {
        return this.body;
    }
    
    public LocalDateTime getCreatedAt() { return this.createdAt; }

}
