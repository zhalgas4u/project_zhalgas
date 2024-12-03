package com.example.MyFirstProjectWithMentor.repository;

import com.example.MyFirstProjectWithMentor.models.Voice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
//Обозначает, что интерфейс является репозиторием, который обрабатывает доступ к данным.

public interface VoiceRepository extends JpaRepository<Voice, Long> {
    // JpaRepository_включает основные методы CRUD:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
}
