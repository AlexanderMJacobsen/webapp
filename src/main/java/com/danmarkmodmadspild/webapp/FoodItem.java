package com.danmarkmodmadspild.webapp;

import java.time.LocalDateTime;

public class FoodItem {
    private String id;
    private String name;
    private String category;
    private Integer qty; // antal portioner
    private Double kg;   // antal kilo
    private Double price; // pris
    private LocalDateTime pickup;
    private String desc;

    public FoodItem() {}

    public FoodItem(String id, String name, String category, Integer qty, Double kg, Double price, LocalDateTime pickup, String desc) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.qty = qty;
        this.kg = kg;
        this.price = price;
        this.pickup = pickup;
        this.desc = desc;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }

    public Double getKg() { return kg; }
    public void setKg(Double kg) { this.kg = kg; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public LocalDateTime getPickup() { return pickup; }
    public void setPickup(LocalDateTime pickup) { this.pickup = pickup; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
}
