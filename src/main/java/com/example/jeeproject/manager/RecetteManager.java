package com.example.jeeproject.manager;

import com.example.jeeproject.dao.entity.Recette;

import java.util.List;

public interface RecetteManager {
    public void save(Recette r);
    public List<Recette> getAllrecette();
    public Recette getRecetteById(int id);
    public void deleteById(int id);
}
