package com.example.demo.extern;

import com.example.demo.DTO.apiDTO.Message;
import com.example.demo.entity.misc.Address;
import com.example.demo.entity.delivery.Delivery;
import com.example.demo.service.LogisticsServiceExtern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/restapi/v1/secure")
public class ApiRequestController {

    @Autowired
    private LogisticsServiceExtern logisticsServiceExtern;
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test(){
        System.out.println("called");
        testService.testService();
        return "index";
    }

    @GetMapping("/testA")
    @PreAuthorize("hasAuthority('PERSON') or hasAuthority('COMPANY')")
    private String a(){
        return "success";
    }

    @GetMapping("/test2")
    public String test2(){
        System.out.println("called");
        testService.testService2();
        return "index";
    }

    @GetMapping("/test3")
    public String test3(){
        System.out.println("called test3");
        testService.testService3();
        System.out.println();
        return "index";
    }

    @GetMapping("/test4")
    public String test4(){
        System.out.println("called test4");
        testService.testService4();
        System.out.println();
        return "index";
    }

    @GetMapping("/test5")
    public String test5(){
        System.out.println("called test5");
        testService.testService5();
        System.out.println();
        return "index";
    }

    @GetMapping("/testLogin")
    public String testLogin(){
        System.out.println("testLogin called");
        testService.testLogin();
        System.out.println();
        return "/login";
    }

    @GetMapping("/testLoginAndRequest")
    public String testLoginAndRequest(){
        System.out.println("login and request called");
        testService.testLoginAndRequest();
        System.out.println();
        return "test";
    }

    @GetMapping("/testRequest")
    public String testRequest(){
        System.out.println("request called");
        testService.testRequest();
        System.out.println();
        return "test";
    }

    @PostMapping("/post")
    public TestData testPost(@RequestBody TestData testData){
        System.out.println("test post api called");
        TestData newData=new TestData();
        newData.setId(testData.getId()+"_expanded");
        newData.setName(testData.getName()+"_expanded");
        return newData;
    }

    @PostMapping("/post2")
    public TestData testUserPost(@RequestBody TestUser TestUser){
        System.out.println("test post api called");
        TestData newData=new TestData();
        //newData.setId(testData.getId()+"_expanded");
        //newData.setName(testData.getName()+"_expanded");
        return newData;
    }


    @PostMapping("/deliveries/")//,headers="content-type=application/json",method = RequestMethod.POST)
    public Delivery createDelivery(@RequestBody Delivery delivery){
        System.out.println("api called");
        Delivery newDelivery = logisticsServiceExtern.createDelivery(delivery);
        return newDelivery;
    }

    @PostMapping("/deliveries3")
    public String test(@RequestBody String delivery){
        System.out.println("api called (3)");
        //Delivery newDelivery = logisticsServiceExtern.createDelivery(delivery);
        return "String";
    }

    @GetMapping("/deliveries")
    public Delivery getDelivery(){
        System.out.println("api get called");
        return new Delivery();
    }

    @PostMapping("/deliveries/create")
    @PreAuthorize("hasAuthority('PERSON') or hasAuthority('COMPANY')")
    public Delivery createDelivery(@RequestBody Delivery delivery, Principal principal){
        System.out.println("creating delivery "+delivery+" for user "+principal.getName());
        Delivery newDelivery = new Delivery();
        Address address = new Address(1,"hibl","ijb","0007");
        newDelivery.setReceiver(address);
        return newDelivery;
    }

    @PostMapping("/deliveries/create2")
    @PreAuthorize("hasAuthority('PERSON') or hasAuthority('COMPANY')")
    public Message testSecurePost(@RequestBody Message message, Principal principal){
        //System.out.println(httpMessage);
        //Message message = httpMessage.getBody();
        //System.out.println(httpMessage.getHeaders());
        Message message1 =new Message("creating delivery "+message.getMessage()+" for user "+principal.getName());
        return message1;
    }
}
