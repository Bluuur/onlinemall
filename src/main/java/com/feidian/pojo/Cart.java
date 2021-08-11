package com.feidian.pojo;

import java.util.Objects;

public
class Cart {

    private Long cid;
    private Long uid;
    private Long id;
    private String name;
    private Integer amount;
    private Double price;
    private String imageUrl;
    private Double totalPrice;

    public Cart() {
    }

    public Cart(Long cid, Long uid, Long id, String name, Integer amount, Double price, String imageUrl, Double totalPrice) {
        this.cid = cid;
        this.uid = uid;
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.imageUrl = imageUrl;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cid, cart.cid) && Objects.equals(uid, cart.uid) && Objects.equals(id, cart.id) && Objects.equals(name, cart.name) && Objects.equals(amount, cart.amount) && Objects.equals(price, cart.price) && Objects.equals(imageUrl, cart.imageUrl) && Objects.equals(totalPrice, cart.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, uid, id, name, amount, price, imageUrl, totalPrice);
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
