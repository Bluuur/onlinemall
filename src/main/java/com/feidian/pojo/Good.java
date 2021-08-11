package com.feidian.pojo;


import java.util.Objects;

public class Good {

    private Long id;
    private String name;
    private Integer number;
    private Double price;
    private String imageUrl;

    public Good() {
    }

    public Good(Long id, String name, Integer number, Double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(id, good.id) && Objects.equals(name, good.name) && Objects.equals(number, good.number) && Objects.equals(price, good.price) && Objects.equals(imageUrl, good.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, price, imageUrl);
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
