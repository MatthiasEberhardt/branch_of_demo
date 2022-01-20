package com.example.demo.web;

import com.example.demo.DTO.internDTO.RegistrationDTO;
import com.example.demo.entity.customer.Company;
import com.example.demo.entity.customer.Customer;
import com.example.demo.entity.customer.Person;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/web")
public class RegisterController {

    @Autowired
    private CustomerService customerService;
    private static final String ERROR_MESSAGE_EMPTY= "%s must not be empty";


    private boolean checkString(String s){
        System.out.println("checking string");
        System.out.println(s!=null);
        System.out.println(!s.isEmpty());
        System.out.println((s!=null)&&(!s.isEmpty()));
        return (s!=null)&&(!s.isEmpty());
    }

    @GetMapping("/register")
    public String start(RegistrationDTO registrationDTO){
        //model.addAttribute("user", new RegistrationDTO());
        return "register";
    }

    /*
    processRegistration partially copied from https://www.javadevjournal.com/spring-security/registration-with-spring-security/
    */
    @PostMapping("/register")
    public String processRegistration(@Valid RegistrationDTO data, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }

        /*
        password matching is checked below
         */
        if(!data.getPassword().equals(data.getPasswordConfirmed())){
            bindingResult.rejectValue("passwordConfirmed","data.passwordConfirmed",
                    "password and password confirmed do not match");
            return "register";
        }

        System.out.println(data);

        Customer customer;
        if(data.getRole().equals("company")){
            if(!checkString(data.getCompanyName())){
                bindingResult.rejectValue("companyName","data.companyName",
                        String.format(ERROR_MESSAGE_EMPTY,"Company Name"));
                return "register";
            }
            customer = new Company(data);
        }
        else{
            boolean reject = false;
            if(!checkString(data.getFirstName())){
                reject = true;
                bindingResult.rejectValue("firstName","data.firstName",
                        String.format(ERROR_MESSAGE_EMPTY,"First Name"));
                //return "register";
            }
            if(!checkString(data.getFamilyName())){
                reject = true;
                bindingResult.rejectValue("familyName","data.familyName",
                        String.format(ERROR_MESSAGE_EMPTY,"Family Name"));
                //return "register";
            }
            if(reject){
                return "register";
            }
            customer = new Person(data);
        }



        try{
            System.out.println("Creating Customer");
            customerService.createCustomer(customer);
            System.out.println("creation successful");
        } catch (ServiceException e) {
            bindingResult.rejectValue("username", "data.username",
                    "An account already exists for this username.");
            return "register";
        }
        return "index";
    }

}
