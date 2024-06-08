package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Model.OrderDetail;
import com.example.demo.Model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.demo.Dao.CustomerRepository;
import com.example.demo.Dao.OrderDetailRepository;
import com.example.demo.Dao.ProductRepository;
import com.example.demo.Dao.OrderRepository;
@Component
public class DataLoader implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ProductRepository ProductRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

    Product Product1 = new Product("osii 舒壓按摩椅",98000,5);
    Product Product2 = new Product(" 網友最愛起司蛋糕",1200,50);
    Product Product3 = new Product("真愛密碼項鍊",8500,20);
    ProductRepository.save(Product1);
    ProductRepository.save(Product2);
    ProductRepository.save(Product3);

    Customer customer1 = new Customer("aaa","1234");
    customerRepository.save(customer1);
    

    OrderDetail orderDetail1 = new OrderDetail(1,Product1);
    OrderDetail orderDetail2 = new OrderDetail(1,Product2);

    orderDetailRepository.save(orderDetail1);
    orderDetailRepository.save(orderDetail2);

    List<OrderDetail> orderDetails = new ArrayList<>();
    orderDetails.add(orderDetail1);
    orderDetails.add(orderDetail2);

    Order order1 = new Order(customer1,orderDetails,0,false);

    orderRepository.save(order1);

    }
}
