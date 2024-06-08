package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_ID;
    private String product_name;
    private int price;
    private int qunatity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> OrderDetails;

    public Product(String name, int price, int qunatity) {
    
        this.product_name = name;
        this.price = price;
        this.qunatity = qunatity;
    }
    public Product() {
        // 無參構造函數
    }
    
    public Long getID() {
        return product_ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    // public Date getCreateTime() {
    //     return createTime;
    // }

    // public void setCreateTime(Date createTime) {
    //     this.createTime = createTime;
    // }

    // public Date getUpdateTime() {
    //     return updateTime;
    // }

    // public void setUpdateTime(Date updateTime) {
    //     this.updateTime = updateTime;
    // }

}
