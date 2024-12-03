package com.example.MyFirstProjectWithMentor.controller;

import com.example.MyFirstProjectWithMentor.models.Pititi;
import com.example.MyFirstProjectWithMentor.service.PititiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/pititi")
public class PititiController {
    private PititiService pititiService;

    @Autowired
    public PititiController(PititiService pititiService) {
        this.pititiService = pititiService;
    }

    @PostMapping("/creat")
    public Pititi creatPititi(@RequestBody Pititi pititi) {
        return pititiService.createPititi(pititi);
    }

    @GetMapping("/get")
    public List<Pititi> getAllPititi() {
        return pititiService.getAllPititis();
    }

    @PutMapping("/update/{id}")
    public Pititi updatePititi(@PathVariable Long id, @RequestBody Pititi pititi) {
        return pititiService.updatePititi(id, pititi);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePititi(@PathVariable Long id) {
        pititiService.deletePititi(id);
    }




}
