package com.ifi.poke_shop.service;


import com.ifi.poke_shop.bo.ProductShop;
import com.ifi.poke_shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService{
    private ShopRepository shopRepository;
    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository=shopRepository;
    }


    @Override
    public Iterable<ProductShop> listProducts() {
        return shopRepository.findAll();
    }

    @Override
    public Optional<ProductShop> getProduct(String id) {
        return shopRepository.findById(id);
    }

    @Override
    public ProductShop createProduct(ProductShop product) {
        return shopRepository.save(product);
    }
    @Override
    public void deleteProduct(String id) {
         shopRepository.deleteById(id);
    }
}
