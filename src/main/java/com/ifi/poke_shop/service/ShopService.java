package com.ifi.poke_shop.service;

import com.ifi.poke_shop.bo.ProductShop;

import java.util.Optional;

public interface ShopService {
    Iterable<ProductShop> listProducts();
    Optional<ProductShop> getProduct(String id);
    ProductShop createProduct(ProductShop product);
    void deleteProduct(String id);
}
