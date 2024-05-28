package com.example.jeeproject.dao.repository;

import com.example.jeeproject.dao.entity.Favorit;
import com.example.jeeproject.dao.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {
}
