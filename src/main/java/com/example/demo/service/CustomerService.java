package com.example.demo.service;


import com.example.demo.entity.customer.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomerService extends UserDetailsService {
    Customer createCustomer(Customer customer) throws ServiceException;
    Customer getCustomerByUsername(String username) throws ServiceException;
    void login();
    void logoff();

}
