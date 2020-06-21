package com.ifi.poke_shop.controller;

import com.ifi.poke_shop.bo.Trainer;
import com.ifi.poke_shop.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class WalletController {

    private final TrainerService trainerService;
    WalletController(TrainerService trainerService){
        this.trainerService = trainerService;
    }
    @PostMapping(value = "/wallet")
    public String rechargePokeDollar(Principal principal,int euro) {
        Trainer trainer=trainerService.getTrainer(principal.getName());
        trainer.setPokeDollar(trainer.getPokeDollar()+euro*1000);
        trainerService.updateTrainer(trainer);
        return "redirect:/wallet";
    }

    @GetMapping(value = "/wallet")
    public ModelAndView walletPage(Principal principal) {
        ModelAndView modelAndView=new ModelAndView("wallet");
        modelAndView.addObject("name",principal.getName());
        return modelAndView;
    }

}
