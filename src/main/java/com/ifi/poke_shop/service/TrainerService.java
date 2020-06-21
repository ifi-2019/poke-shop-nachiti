package com.ifi.poke_shop.service;

import com.ifi.poke_shop.bo.Trainer;

public interface TrainerService {

    Trainer getTrainer(String name);
    Trainer createTrainer(Trainer trainer);
    void deleteTrainer(String name);
    void updateTrainer(Trainer trainer);
}


