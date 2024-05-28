package com.example.jeeproject.service;

import com.example.jeeproject.dao.entity.Recette;
import com.example.jeeproject.dao.repository.RecetteRepository;
import com.example.jeeproject.manager.RecetteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteService implements RecetteManager {

    @Autowired
    private RecetteRepository recetteRepository;

    public void save(Recette r) {

        recetteRepository.save(r);
    }

    public List<Recette> getAllrecette(){

        return recetteRepository.findAll();
    }

    public Recette getRecetteById(int id) {
        return recetteRepository.findById(id).get();
    }
    public void deleteById(int id) {

        recetteRepository.deleteById(id);
    }
}
