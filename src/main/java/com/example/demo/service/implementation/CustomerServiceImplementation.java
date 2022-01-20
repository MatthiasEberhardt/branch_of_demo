package com.example.demo.service.implementation;

import com.example.demo.entity.customer.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Customer createCustomer(Customer customer) throws ServiceException{
        String username = customer.getUsername();
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        boolean usernameTaken = customerRepository.existsById(username);
        if(usernameTaken){
            throw new ServiceException("Username "+username+" already taken.");
        }
        else {
            return customerRepository.save(customer);
        }
    }

    @Override
    public Customer getCustomerByUsername(String username) throws ServiceException {
        return customerRepository.findById(username).orElseThrow(
                () -> new ServiceException("Customer with username "+username+" not found.")
        );
    }

    @Override
    public void login() {

    }

    @Override
    public void logoff() {

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return customerRepository.findById(s).orElseThrow(
                () -> new UsernameNotFoundException("Customer with username "+s+" not found.")
        );
    }
}
