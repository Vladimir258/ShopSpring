package com.geekbrains.springweb.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   Long id;

   @Column(name = "title")
   String title;

   @Column(name = "cost")
   Float cost;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Float getCost() {
      return cost;
   }

   public void setCost(Float cost) {
      this.cost = cost;
   }

   public Product(Long id, String title, Float cost) {
      this.id = id;
      this.title = title;
      this.cost = cost;
   }

   public Product(String title, Float cost) {
      this.title = title;
      this.cost = cost;
   }

   public Product() {
   }

   @Override
   public String toString() {
      return "Product{" +
              "id = " + id +
              ", title = '" + title + '\'' +
              ", cost = " + cost +
              '}';
   }
}
