package com.ifi.poke_shop.bo;


import javax.persistence.*;
import java.util.List;
@Entity
public class Trainer {
    @Id
    private String name;
    @ElementCollection
    private List<ProductWallet> products;
    @Column
    private int pokeDollar;

    @Column
    private String password;

    public Trainer() {
    }

    public Trainer(String name, List<ProductWallet> products, int pokeDollar) {
        this.name = name;
        this.products = products;
        this.pokeDollar = pokeDollar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProductWallet> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWallet> products) {
        this.products = products;
    }

    public int getPokeDollar() {
        return pokeDollar;
    }

    public void setPokeDollar(int pokeDollar) {
        this.pokeDollar = pokeDollar;
    }


}
