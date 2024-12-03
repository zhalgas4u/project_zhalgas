package com.example.MyFirstProjectWithMentor.service;

import com.example.MyFirstProjectWithMentor.models.Pititi;
import com.example.MyFirstProjectWithMentor.models.User;
import com.example.MyFirstProjectWithMentor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Помечает класс как компонент, который have бизнес-логику.

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //creat
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //delete by id
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    //get all
    public List<User> getAllUser(){
         return userRepository.findAll();
    }

    //update
    public User updateUser(Long id, User updatedUser) {
        // Находим существующего пользователя по id
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User не -> found"));

        // Обновляем поля существующего пользователя
        existingUser.setName(updatedUser.getName());
        existingUser.setLogin(updatedUser.getLogin());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }

}
