package com.example.jeeproject.dao.repository;

import com.example.jeeproject.dao.entity.Favorit;
import com.example.jeeproject.dao.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritRepository extends JpaRepository<Favorit, Integer> {
}

