package com.example.MyFirstProjectWithMentor.service;

import com.example.MyFirstProjectWithMentor.models.Pititi;
import com.example.MyFirstProjectWithMentor.repository.PititiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Service: Помечает класс как компонент, содержащий бизнес-логику.
public class PititiService {
    private PititiRepository pititiRepository;

    public PititiService(PititiRepository pititiRepository) {
        this.pititiRepository = pititiRepository;
    }

    //creat
    public Pititi createPititi(Pititi pititi) {
        return pititiRepository.save(pititi);
    }

    //delete
    public void deletePititi(Long id) {
        pititiRepository.deleteById(id);
    }

    //get all
    public List<Pititi> getAllPititis() {
        return pititiRepository.findAll();
    }

    //update
    public Pititi updatePititi(Long id,Pititi updatedPititi){
        //находим по сущетсв айди
        Pititi exestingPititi = pititiRepository.findById(id).orElseThrow(() -> new RuntimeException("Pititi not found"));

        // we are updating
        exestingPititi.setDescription(updatedPititi.getDescription());
        exestingPititi.setName(updatedPititi.getName());
        exestingPititi.setCreationDate(updatedPititi.getCreationDate());
        return pititiRepository.save(exestingPititi);


    }
}
