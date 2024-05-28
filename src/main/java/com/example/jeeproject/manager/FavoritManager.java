package com.example.jeeproject.manager;

import com.example.jeeproject.dao.entity.Favorit;

import java.util.List;

public interface FavoritManager {

    public void saveFavorit(Favorit recette);

    public List<Favorit> getFavorit();

    public void deleteById(int id);
}
