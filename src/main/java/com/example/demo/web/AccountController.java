package com.example.demo.web;

import com.example.demo.DTO.internDTO.AccountChangeDTO;
import com.example.demo.entity.customer.Company;
import com.example.demo.entity.customer.Customer;
import com.example.demo.entity.customer.Person;
import com.example.demo.entity.customer.Role;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/web")
public class AccountController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/account")
    public String newStorage(Principal principal, Model model){
        String id = principal.getName();
        Customer user = (Customer) customerService.loadUserByUsername(id);
        model.addAttribute("user", user);
        if (user.getRole() == Role.PERSON){
            return "account-person";
        }
        else{
            return "account-company";
        }
    }

    @GetMapping("/account-change")
    public String accountChange(Model model,Principal principal, @Valid AccountChangeDTO accountChangeDTO, BindingResult bindingResult){
        String id = principal.getName();
        Customer user = (Customer) customerService.loadUserByUsername(id);
        //AccountChangeDTO accountChangeDTO;
        String returnPage;
        if(user.getRole()==Role.PERSON){
            accountChangeDTO = new AccountChangeDTO((Person) user);
            returnPage="account-change-person";
        }
        else{
            accountChangeDTO = new AccountChangeDTO((Company) user);
            returnPage="account-change-company";
        }
        System.out.println(accountChangeDTO);
        model.addAttribute("accountChangeDTO",accountChangeDTO);
        return returnPage;
    }
}