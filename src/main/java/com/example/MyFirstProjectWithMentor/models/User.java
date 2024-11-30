package com.example.MyFirstProjectWithMentor.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionIdMutability;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_login_unique", columnNames ="login")
        }
)
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;






    @Column(
            name = "login",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
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
}


