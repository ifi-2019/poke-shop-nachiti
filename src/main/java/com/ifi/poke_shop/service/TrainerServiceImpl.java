package com.ifi.poke_shop.service;

import com.ifi.poke_shop.bo.Trainer;
import com.ifi.poke_shop.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService{


    TrainerRepository trainerRepository;

    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepo) {
        trainerRepository=trainerRepo;
    }

    public Iterable<Trainer> listTrainer() {
       return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name) {
        return trainerRepository.findById(name).get();
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(String name){
        trainerRepository.deleteById(name);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }
}
