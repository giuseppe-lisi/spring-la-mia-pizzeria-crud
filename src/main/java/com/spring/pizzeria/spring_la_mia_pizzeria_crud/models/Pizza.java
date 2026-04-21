package com.spring.pizzeria.spring_la_mia_pizzeria_crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pizza")
public class Pizza {

    // costruttore vuoto senza argomenti obbligatorio
    public Pizza() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be empty")
    private String name;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "You must enter a description")
    private String description;
    
    private String img;

    @Min(value = 0, message = "Price must be positive")
    private double price;

    // getter e setter
    public int getId() {
      return this.id;
    }
    public void setId(int value) {
      this.id = value;
    }

    public String getName() {
      return this.name;
    }
    public void setName(String value) {
      this.name = value;
    }

    public String getDescription() {
      return this.description;
    }
    public void setDescription(String value) {
      this.description = value;
    }

    public String getImg() {
      return this.img;
    }
    public void setImg(String value) {
      this.img = value;
    }

    public double getPrice() {
      return this.price;
    }
    public void setPrice(double value) {
      this.price = value;
    }

    // override metodo toString
    @Override
    public String toString() {
        return String.format("%s - € %.2f", name, price);
    }
}
