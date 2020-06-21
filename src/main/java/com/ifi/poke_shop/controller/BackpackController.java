package com.ifi.poke_shop.controller;

import com.ifi.poke_shop.bo.ProductWallet;
import com.ifi.poke_shop.bo.Trainer;
import com.ifi.poke_shop.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class BackpackController {
    private final TrainerService trainerService;

    BackpackController(TrainerService trainerService){
        this.trainerService = trainerService;
    }
    @GetMapping(value = "/")
    public String index() {
        return "redirect:/shop-api/products";
    }
    @GetMapping(value="/backpack")
    public ModelAndView backPack(Principal principal){
        Trainer trainer=trainerService.getTrainer(principal.getName());
        List<ProductWallet> products=trainer.getProducts();
        int pokeDollar=trainer.getPokeDollar();
        ModelAndView modelAndView=new ModelAndView("backpack");
        modelAndView.addObject("name",principal.getName());
        modelAndView.addObject("products",products);
        modelAndView.addObject("pokeDollar",pokeDollar);
        return modelAndView;
    }

}
