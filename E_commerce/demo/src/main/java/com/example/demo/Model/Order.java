package com.example.demo.Model;


import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;
    private int price;
    private Boolean PayStatus;

    @ManyToOne
    @JoinColumn(name = "Member_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    private List<OrderDetail> OrderDetails;

    public Order(Customer customer,List<OrderDetail> OrderDetails,int price,boolean PayStatus) {
    
        this.OrderDetails = OrderDetails;
        price = this.OrderDetails.stream()
        .mapToInt(OrderDetail -> OrderDetail.getItemPrice())
        .sum();
        this.price = price;
        this.customer = customer;
        this.PayStatus = false;
        
    }
    public Order() {
        // 無參構造函數
    }
    
    public Long getID() {
        return orderID;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getPayStatus() {
        return PayStatus;
    }


    public void setPayStatus(Boolean PayStatus) {
        this.PayStatus = PayStatus;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<Product> getProducts() {
        
        return this.OrderDetails.stream()
        .map(OrderDetail::getProduct)
        .distinct()
        .collect(Collectors.toList());
    }
    public List<OrderDetail> getOrderDetails(){
        return this.OrderDetails;
    };
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
