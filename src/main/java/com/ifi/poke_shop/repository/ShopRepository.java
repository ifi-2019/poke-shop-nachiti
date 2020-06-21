package com.ifi.poke_shop.repository;

import com.ifi.poke_shop.bo.ProductShop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<ProductShop, String> {

}


