package com.example.MyFirstProjectWithMentor.controller;

import com.example.MyFirstProjectWithMentor.models.User;
import com.example.MyFirstProjectWithMentor.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RestController: Говорит Spring, что это контроллер, обрабатывающий REST-запросы.

@RequestMapping("/api/user")
//@RequestMapping: Определяет общий путь для всех эндпоинтов.
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@PostMapping: Обрабатывает POST-запросы (создание)
    //@RequestBody: Преобразует JSON-запрос в объект Java.
    @Operation(summary = "Создать нового пользователя")
    @PostMapping("/creat")
    public User createPititi(@RequestBody User user) {
        return userService.createUser(user);
    }

    //@GetMapping: Для получения данных.
    //@PathVariable: Извлекает переменные из URL.
    @Operation(summary = "Получить список всех пользователей")
    @GetMapping("/get")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }


    //@PutMapping: Для обновления.
    @Operation(summary = "Обновить пользователя по ID")
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id ,@RequestBody User user) {
        return userService.updateUser(id, user);

    }

    @Operation(summary = "Удалить пользователя по ID")
    @DeleteMapping("/delete/{id}")
    //@DeleteMapping: Для удаления
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
