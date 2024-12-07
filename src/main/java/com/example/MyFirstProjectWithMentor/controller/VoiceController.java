package com.example.MyFirstProjectWithMentor.controller;

import com.example.MyFirstProjectWithMentor.models.Voice;
import com.example.MyFirstProjectWithMentor.service.VoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Голоса", description = "Управление голосами")
@RestController
@RequestMapping("/api/voice")
public class VoiceController {
    private VoiceService voiceService;

    public VoiceController(VoiceService voiceService) {
        this.voiceService = voiceService;
    }

    @Operation(summary = "Создать голос")
    @PostMapping("/creat")
    public Voice createVoice(@RequestBody Voice voice) {
        return voiceService.createVoice(voice);
    }

    @Operation(summary = "Получить все голоса")
    @GetMapping("/get")
    public List<Voice> getAllVoice() {
        return voiceService.getAllVoices();
    }

    @Operation(summary = "Обновить голос")
    @PutMapping("/update/{id}")
    public Voice updateVoice(@PathVariable Long id,@RequestBody Voice voice) {
        return voiceService.updateVoice(id, voice);
    }

    @Operation(summary = "Удалить голос")
    @DeleteMapping("/delete")
    public void deleteVoice(@RequestBody Voice voice) {
        voiceService.deleteVoice(voice);
    }
}
