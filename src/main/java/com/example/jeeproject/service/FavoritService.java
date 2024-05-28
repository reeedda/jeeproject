package com.example.jeeproject.service;

import com.example.jeeproject.dao.entity.Favorit;
import com.example.jeeproject.dao.repository.FavoritRepository;
import com.example.jeeproject.manager.FavoritManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritService implements FavoritManager {
    @Autowired
     FavoritRepository favoritRepository;

    public void saveFavorit(Favorit recette) {
        favoritRepository.save(recette);
    }


    public List<Favorit> getFavorit(){
        return favoritRepository.findAll();
    }

    public void deleteById(int id) {
        favoritRepository.deleteById(id);
    }

}
