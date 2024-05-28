package com.example.jeeproject.controller;


import com.example.jeeproject.manager.FavoritManager;
import com.example.jeeproject.service.FavoritService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FavoritController {
    @Autowired
    private FavoritManager favoritManager;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        favoritManager.deleteById(id);
        return "redirect:/favorit";
    }
}
