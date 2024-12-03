package com.example.MyFirstProjectWithMentor.controller;

import com.example.MyFirstProjectWithMentor.models.Voice;
import com.example.MyFirstProjectWithMentor.service.VoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voice")
public class VoiceController {
    private VoiceService voiceService;

    public VoiceController(VoiceService voiceService) {
        this.voiceService = voiceService;
    }

    @PostMapping("/creat")
    public Voice createVoice(@RequestBody Voice voice) {
        return voiceService.createVoice(voice);
    }

    @GetMapping("/get")
    public List<Voice> getAllVoice() {
        return voiceService.getAllVoices();
    }

    @PutMapping("/update/{id}")
    public Voice updateVoice(@PathVariable Long id,@RequestBody Voice voice) {
        return voiceService.updateVoice(id, voice);
    }

    @DeleteMapping("/delete")
    public void deleteVoice(@RequestBody Voice voice) {
        voiceService.deleteVoice(voice);
    }
}
