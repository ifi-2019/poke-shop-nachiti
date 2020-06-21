package com.ifi.poke_shop.controller;



import com.ifi.poke_shop.bo.History;
import com.ifi.poke_shop.bo.ProductShop;
import com.ifi.poke_shop.bo.ProductWallet;
import com.ifi.poke_shop.bo.Trainer;
import com.ifi.poke_shop.service.HistoryService;
import com.ifi.poke_shop.service.ShopService;
import com.ifi.poke_shop.service.TrainerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/shop-api")
public class ShopController {
    private final ShopService shopService;
    private final TrainerService trainerService;
    private final HistoryService historyService;

    public ShopController(ShopService shopService,TrainerService trainerService,HistoryService historyService){
        this.shopService=shopService;
        this.trainerService=trainerService;
        this.historyService=historyService;
    }
    @GetMapping(value="/products")
    public ModelAndView getAllProducts(Principal principal){
        Iterable<ProductShop> products=shopService.listProducts();
        ModelAndView modelAndView=new ModelAndView("shop");
        modelAndView.addObject("products",products);
        modelAndView.addObject("name",principal.getName());
        return modelAndView;
    }
    @PostMapping(value = "/buy/{id}")
    public ModelAndView buy(@PathVariable String id,Principal principal){
        ProductShop product=shopService.getProduct(id).get();
        int price=product.getPrice();

        Trainer trainer=trainerService.getTrainer(principal.getName());
        if(trainer.getPokeDollar()>=price) {
            trainer.setPokeDollar(trainer.getPokeDollar() - price);
            trainer.getProducts().add(new ProductWallet(product.getPrice(),product.getId(),product.getLabel()));
            trainerService.updateTrainer(trainer);
            shopService.deleteProduct(id);
            String dateStr = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
            History history = new History(id, price, principal.getName(), product.getLabel(), dateStr);
            historyService.addHistory(history);
        }
        Iterable<ProductShop> products=shopService.listProducts();
        ModelAndView modelAndView=new ModelAndView("shop");
        modelAndView.addObject("products",products);
        modelAndView.addObject("name",principal.getName());
        return modelAndView;
    }


}
