package com.ifi.poke_shop.controller;


import com.ifi.poke_shop.bo.History;
import com.ifi.poke_shop.service.HistoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@RestController
@RequestMapping(value = "/shop-api")
public class HistoryController {
    private final HistoryService historyService;
    public HistoryController(HistoryService historyService){
        this.historyService=historyService;
    }

    @GetMapping(value="/history")
    public ModelAndView getHistoryOfTrainer(Principal principal){
        Iterable<History> products=historyService.getHistoryOfTrainer(principal.getName());
        ModelAndView modelAndView=new ModelAndView("history");
        modelAndView.addObject("products",products);
        modelAndView.addObject("name",principal.getName());
        return modelAndView;
    }

}
