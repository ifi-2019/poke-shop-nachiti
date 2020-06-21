package com.ifi.poke_shop;

import com.ifi.poke_shop.bo.ProductShop;
import com.ifi.poke_shop.bo.ProductWallet;
import com.ifi.poke_shop.bo.Trainer;
import com.ifi.poke_shop.repository.ShopRepository;
import com.ifi.poke_shop.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {
    @Bean
    @Autowired
    public CommandLineRunner demo(TrainerRepository repository, ShopRepository shopRepository) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return (args) -> {

            ProductShop portion=new ProductShop(300,"Potion","Restaure 20 PV d'un Pokemon");
            shopRepository.save(portion);
            ProductShop product=new ProductShop(200,"Pokeball","Permet d'attraper un Pokemo");
            shopRepository.save(product);
            List<ProductWallet> listProduct=new ArrayList<>();
            Trainer ash = new Trainer("Ash", listProduct, 300);
            ash.setPassword(bCryptPasswordEncoder.encode("ash_password"));

            Trainer misty = new Trainer("Misty", listProduct, 0);

            misty.setPassword(bCryptPasswordEncoder.encode("misty_password"));

            // save a couple of trainers
            repository.save(ash);
            repository.save(misty);
        };
    }

    public static void main(String... args){
        SpringApplication.run(Application.class, args);
    }
}
