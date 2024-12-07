package com.example.MyFirstProjectWithMentor.controller;

import com.example.MyFirstProjectWithMentor.models.Pititi;
import com.example.MyFirstProjectWithMentor.service.PititiService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pititi")
public class PititiController {
    private PititiService pititiService;

    @Autowired
    public PititiController(PititiService pititiService) {
        this.pititiService = pititiService;
    }

    @Operation(summary = "Создать нового Pitition")
    @PostMapping("/creat")
    public Pititi creatPititi(@RequestBody Pititi pititi) {
        return pititiService.createPititi(pititi);
    }

    @Operation(summary = "get all list of pititi")
    @GetMapping("/get")
    public List<Pititi> getAllPititi() {
        return pititiService.getAllPititis();
    }

    @Operation(summary ="update pitition")
    @PutMapping("/update/{id}")
    public Pititi updatePititi(@PathVariable Long id, @RequestBody Pititi pititi) {
        return pititiService.updatePititi(id, pititi);
    }

    @Operation(summary = "delete pititon")
    @DeleteMapping("/delete/{id}")
    public void deletePititi(@PathVariable Long id) {
        pititiService.deletePititi(id);
    }




}
