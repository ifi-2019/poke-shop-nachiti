package com.ifi.poke_shop.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class History {
    @Column
    private String productId;
    @Column
    private int price;
    @Column
    private String trainer;
    @Column
    private String label;
    @Id
    private String date;


    public History(String productId, int price, String trainer, String label, String date) {
        this.productId = productId;
        this.price = price;
        this.trainer = trainer;
        this.label = label;
        this.date = date;
    }
     public History(){

     }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductsId() {
        return productId;
    }

    public void setProductsId(String productId) {
        this.productId = productId;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
