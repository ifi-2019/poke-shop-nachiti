package com.ifi.poke_shop.service;


import com.ifi.poke_shop.bo.History;
import com.ifi.poke_shop.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class HistoryServiceImpl  implements  HistoryService{
    private HistoryRepository historyRepository;
    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository=historyRepository;
    }


    @Override
    public Iterable<History> getHistoryOfTrainer(String trainerName) {
        List<History> result=new ArrayList<History>();
        Iterator<History> iterator=historyRepository.findAll().iterator();
        while(iterator.hasNext()){
            History history=iterator.next();
            if (history.getTrainer().equals(trainerName)){
                result.add(history);
            }
        }
        return result;
    }

    @Override
    public History addHistory(History history) {
        return historyRepository.save(history);
    }
}
