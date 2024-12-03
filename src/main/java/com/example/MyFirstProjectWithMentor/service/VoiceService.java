package com.example.MyFirstProjectWithMentor.service;

import com.example.MyFirstProjectWithMentor.models.Voice;
import com.example.MyFirstProjectWithMentor.repository.VoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoiceService {
    public VoiceRepository voiceRepository;
    public VoiceService(VoiceRepository voiceRepository) {
        this.voiceRepository = voiceRepository;
    }

    //create
    public Voice createVoice(Voice voice) {
        return voiceRepository.save(voice);
    }


    //delete
    public void deleteVoice(Voice voice) {
        voiceRepository.delete(voice);
    }

    //get all
    public List<Voice> getAllVoices() {
        return voiceRepository.findAll();
    }


    // update
    public Voice updateVoice(Long id, Voice updatedVoice) {
        Voice existingVoice = voiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Voice not found"));

        existingVoice.setPetition(updatedVoice.getPetition());
        existingVoice.setUser(updatedVoice.getUser());
        existingVoice.setTimestamp(updatedVoice.getTimestamp());
        return voiceRepository.save(existingVoice);
    }
}
