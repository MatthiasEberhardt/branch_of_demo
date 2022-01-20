package com.example.demo.extern;

import com.example.demo.DTO.apiDTO.LoginInformation;
import com.example.demo.DTO.apiDTO.Message;
import com.example.demo.entity.misc.Address;
import com.example.demo.entity.delivery.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

    @Autowired
    private RestTemplate restTemplate;
    private static final String PARTNER_SERVER="http://localhost:8080";
    private static final String API_PATH="/restapi/v1";
    private static final String LOGIN_PATH="/auth/login";
    private static final String REQUEST_PATH="/secure";

    public void testService(){
        System.out.println("testService");
        Delivery delivery = new Delivery();
        delivery.setReceiver(new Address(1,"Test street","Test city","00002"));
        System.out.println(delivery);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //URI uri = new URI("http://localhost:8080/restapi/v1/deliveries");


        HttpEntity<Delivery> httpEntity = new HttpEntity<>(delivery, headers);

        ResponseEntity<Delivery> deliveryReturn = restTemplate.postForEntity("http://localhost:8080/restapi/v1/deliveries", delivery, Delivery.class);
        System.out.println(deliveryReturn);
    }

    public void testService2(){
        System.out.println("testService");
        Delivery delivery = new Delivery();
        delivery.setReceiver(new Address(1,"Test street","Test city","00002"));
        System.out.println(delivery);
        delivery = restTemplate.getForObject("http://localhost:8080/restapi/v1/deliveries", Delivery.class);
        System.out.println(delivery);
    }

    public void testService3(){
        System.out.println("testService3");

        //System.out.println(delivery);
        String delivery = restTemplate.postForObject("http://localhost:8080/restapi/v1/deliveries3", "asdhua",String.class);
        System.out.println(delivery);
    }

    public void testService4(){
        System.out.println("testService4");

        //System.out.println(delivery);
        ResponseEntity<TestData> returnData = restTemplate.postForEntity("http://localhost:8080/restapi/v1/post", new TestData("id1","name1"),TestData.class);
        System.out.println(returnData);
        System.out.println(returnData.getBody());
    }

    public void testService5(){
        System.out.println("testService5");
        TestUser testUser=new TestUser();
        testUser.setName("matthias");
        testUser.setName("password");
        //System.out.println(delivery);
        ResponseEntity<TestUser> returnData = restTemplate.postForEntity("http://localhost:8080/login", testUser,TestUser.class);
        System.out.println(returnData);
        System.out.println(returnData.getBody());
    }

    public void testLogin(){
        System.out.println("test api login");
        LoginInformation loginInformation = new LoginInformation();
        loginInformation.setUsername("matthias");
        loginInformation.setPassword("password");
        ResponseEntity<Message> returnData = restTemplate.postForEntity("http://localhost:8080/restapi/v1/auth/login",loginInformation,Message.class);
        System.out.println(returnData.getHeaders());
        System.out.println("getting data");
        System.out.println(returnData.getBody());
    }

    public void testLoginAndRequest(){
        System.out.println("test api login");
        LoginInformation loginInformation = new LoginInformation();
        loginInformation.setUsername("matthias");
        loginInformation.setPassword("password");
        ResponseEntity<Message> returnData = restTemplate.postForEntity("http://localhost:8080/restapi/v1/auth/login",loginInformation,Message.class);
        System.out.println(returnData.getHeaders());
        System.out.println("getting data");
        System.out.println(returnData.getBody());
        HttpHeaders headers = new HttpHeaders();
        String secureCookie=returnData.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        System.out.println(secureCookie);
        headers.add(HttpHeaders.COOKIE,secureCookie);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Delivery delivery = new Delivery();
        delivery.setReceiver(new Address(1,"Test street","Test city","00002"));
        HttpEntity<Delivery> httpEntity = new HttpEntity<>(delivery, headers);
        System.out.println(httpEntity);
        ResponseEntity<Delivery> response = restTemplate.postForEntity(PARTNER_SERVER+API_PATH+REQUEST_PATH+"/deliveries/create",httpEntity,Delivery.class);
        System.out.println(response.getBody());
    }

    public void testRequest(){
        Delivery delivery = new Delivery();
        delivery.setReceiver(new Address(1,"Test street","Test city","00002"));
        ResponseEntity<Message> response = restTemplate.postForEntity(PARTNER_SERVER+API_PATH+REQUEST_PATH+"/deliveries/create",delivery,Message.class);
    }
}
