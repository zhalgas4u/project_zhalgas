package com.example.MyFirstProjectWithMentor.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "new_Pititi")
public class Pititi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate creationDate;
    //private int votes;

    @OneToMany(mappedBy = "petition", cascade = CascadeType.ALL)
    private List<Voice> voice; // Подписи, связанные с петицией


    public void setVoice(List<Voice> voice) {
        this.voice = voice;
    }

    public List<Voice> getVoice() {
        return voice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

   /* public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }*/
}

