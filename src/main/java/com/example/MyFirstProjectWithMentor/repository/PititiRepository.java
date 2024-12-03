package com.example.MyFirstProjectWithMentor.repository;

import com.example.MyFirstProjectWithMentor.models.Pititi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//Обозначает, что интерфейс является репозиторием, который обрабатывает доступ к данным.

public interface PititiRepository extends JpaRepository<Pititi, Long> {
    // JpaRepository_включает основные методы CRUD:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
}
