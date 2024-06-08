package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderItemSN;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    private int qauntity;

    private int StandPrice;
    private int ItemPrice;
    // 其他屬性和方法
    public OrderDetail(int qauntity,Product product) {
        this.qauntity = qauntity;
        this.product = product;
        this.StandPrice = product.getPrice();
        this.ItemPrice =  qauntity*StandPrice;
    }
    
    public Long getID() {
        return OrderItemSN;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public int getQuantity(){
        return qauntity;
    }
    public int getStandPrice(){
        return this.StandPrice;
    }
    public int getItemPrice(){
        return this.ItemPrice;
    }
}
