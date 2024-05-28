package com.example.jeeproject.dao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Recette")
@Data
@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="id" )
    private int id;
    @Column(name ="name" )
    private String name;
    @Column(name ="ingredients" )
    private String ingredients;
    @Column(name ="description" )
    private String description;


}
