package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "pizzas")
public class Pizza  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="name")
    public String name;
    @Column(name="diameter")
    public int diameter;

    @Column
    public float cost;

    public Pizza() {
        name = "no_pizza";
        diameter = -1;
    }

    public Pizza(Long id, String name, int diameter, float cost){
        this.id = id;
        this.name = name;
        this.diameter = diameter;
        this.cost = cost;
    }
    public Pizza(String name, int diameter){
        this.name = name;
        this.diameter = diameter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public float getCost() { return cost; }
    public void setCost(float cost) {
        this.cost = cost;
    }
}
