package com.ifi.poke_shop.bo;

import javax.persistence.Embeddable;

@Embeddable
public class ProductWallet {

    private int price;

    private String id;

    private String label;

    public ProductWallet(int price, String id, String label) {
        this.price = price;
        this.id = id;
        this.label = label;
    }

    public ProductWallet() {
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
