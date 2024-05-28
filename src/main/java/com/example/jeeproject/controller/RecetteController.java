package com.example.jeeproject.controller;


import com.example.jeeproject.dao.entity.Favorit;
import com.example.jeeproject.dao.entity.Recette;
import com.example.jeeproject.manager.FavoritManager;
import com.example.jeeproject.manager.RecetteManager;
import com.example.jeeproject.service.FavoritService;
import com.example.jeeproject.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RecetteController {
    @Autowired
    private RecetteManager recetteManager;
    @Autowired
    private FavoritManager favoritManager;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/home")
    public String home2() {
        return "home";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/new_recipe")
    public String newRecipe() {
        return "newrecipe";
    }

    /*@GetMapping("/add")
    public String add() {
        return "add";
    }*/

    @GetMapping("/available_recipes")
    public ModelAndView getAllrecette() {
        List<Recette> list= recetteManager.getAllrecette();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("recetteList");
//		m.addObject("recette",list);
        return new ModelAndView("recetteList","recette",list);
    }

    @PostMapping("/save")
    public String addrecette(@ModelAttribute Recette b) {
        recetteManager.save(b);
        return "redirect:/available_recipes";
    }
   @GetMapping("/favorit")
    public String getFavorit(Model model)
    {
        List<Favorit>list= favoritManager.getFavorit();
        model.addAttribute("recette",list);
        return "favorit";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
    Recette b=recetteManager.getRecetteById(id);
        Favorit mb=new Favorit(b.getId(),b.getName(),b.getIngredients(),b.getDescription());
        favoritManager.saveFavorit(mb);
        return "redirect:/favorit";
}

    @RequestMapping("/editRecette/{id}")
    public String editRecette(@PathVariable("id") int id,Model model) {
        Recette b=recetteManager.getRecetteById(id);
        model.addAttribute("recette",b);
        return "recetteEdit";
    }
    @RequestMapping("/deleteRecette/{id}")
    public String deleteRecette(@PathVariable("id")int id) {
        recetteManager.deleteById(id);
        return "redirect:/available_recipes";
    }
}
