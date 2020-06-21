package com.ifi.poke_shop.service;


import com.ifi.poke_shop.bo.History;

public interface HistoryService {

        Iterable<History> getHistoryOfTrainer(String trainerName);
        History addHistory(History history);

}
