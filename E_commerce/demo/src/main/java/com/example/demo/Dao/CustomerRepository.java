package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
