package com.example.jeeproject.dao.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Favorit")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Favorit {
    @Id
    @Column(name ="id" )
    private int id;
    @Column(name ="name" )
    private String name;
    @Column(name ="ingredients" )
    private String ingredients;
    @Column(name ="description" )
    private String description;

}
