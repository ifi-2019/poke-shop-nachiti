package com.ifi.poke_shop.repository;

import com.ifi.poke_shop.bo.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer,String> {

}
