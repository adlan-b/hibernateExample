package main.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private SubKey id = new SubKey();

    @Column(name = "subscription_date")
    private LocalDateTime date;

    public SubKey getId() {
        return id;
    }

    public void setId(SubKey id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

}

