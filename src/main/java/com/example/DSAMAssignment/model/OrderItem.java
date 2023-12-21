package com.example.DSAMAssignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private double price;

    @ManyToOne
    private Bottle bottle;
    @ManyToOne
    private Crate crate;
    @ManyToOne
    private Orders order;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public Bottle getBottle() {
//        return bottle;
//    }
//
//    public void setBottle(Bottle bottle) {
//        this.bottle = bottle;
//    }
//
//    public Crate getCrate() {
//        return crate;
//    }
//
//    public void setCrate(Crate crate) {
//        this.crate = crate;
//    }
//
//    public Orders getOrder() {
//        return order;
//    }
//
//    public void setOrder(Orders order) {
//        this.order = order;
//    }

}
