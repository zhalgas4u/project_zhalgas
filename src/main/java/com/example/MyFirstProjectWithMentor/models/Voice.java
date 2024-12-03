package com.example.MyFirstProjectWithMentor.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "new_Voice")
public class Voice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") //  ключ юзерлерге
    private User user;

    @ManyToOne
    @JoinColumn(name = "petition_id") //  ключ питити
    private Pititi petition;


    private LocalDateTime timestamp; //кашан бергени туралы


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pititi getPetition() {
        return petition;
    }

    public void setPetition(Pititi petition) {
        this.petition = petition;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
