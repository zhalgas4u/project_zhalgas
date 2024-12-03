package com.example.MyFirstProjectWithMentor.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionIdMutability;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity(name = "new_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(
            name = "name",
            nullable = false, // означае что бул жер не нулл
            unique = false,
            columnDefinition = "TEXT" // тип данных
    )
    private String name;

    @Column(
            name = "login",
            nullable = false, // означае что бул жер не нулл
            unique = true,
            columnDefinition = "TEXT" // тип данных
    )
    private String login;


    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Voice> voice; // Подписи пользователя











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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


