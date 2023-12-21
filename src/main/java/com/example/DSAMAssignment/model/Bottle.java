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

public class Bottle {
    @Id
    private Long id;
    private String name;
    private String bottlePic;
    private double volume;
    private boolean isAlcoholic;
    private double volumePercent;
    private double price;
    private String supplier;
    private int inStock;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getBottlePic() {
//        return bottlePic;
//    }
//
//    public void setBottlePic(String bottlePic) {
//        this.bottlePic = bottlePic;
//    }
//
//    public double getVolume() {
//        return volume;
//    }
//
//    public void setVolume(double volume) {
//        this.volume = volume;
//    }
//
//    public boolean isAlcoholic() {
//        return isAlcoholic;
//    }
//
//    public void setAlcoholic(boolean alcoholic) {
//        isAlcoholic = alcoholic;
//    }
//
//    public double getVolumePercent() {
//        return volumePercent;
//    }
//
//    public void setVolumePercent(double volumePercent) {
//        this.volumePercent = volumePercent;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(String supplier) {
//        this.supplier = supplier;
//    }
//
//    public int getInStock() {
//        return inStock;
//    }
//
//    public void setInStock(int inStock) {
//        this.inStock = inStock;
//    }

}
