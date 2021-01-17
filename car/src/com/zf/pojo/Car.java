package com.zf.pojo;

public class Car {
    private String name;
    private String type;
    private double price;
    private Integer stock ; //库存
    private String img_path = "static/img/default.jpg";

    public Car() {
    }

    public Car(String name, String type, double price, Integer stock, String img_path) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
        this.img_path = img_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
