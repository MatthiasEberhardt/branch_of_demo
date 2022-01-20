package com.example.demo.web;

import com.example.demo.DTO.internDTO.DeliveryDTO2;
import com.example.demo.entity.customer.Customer;
import com.example.demo.entity.delivery.Delivery;
import com.example.demo.service.CustomerService;
import com.example.demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/web")
public class NewDeliveryController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DeliveryService deliveryService;
    private static final String NEW_DELIVERY_PAGE="new-delivery-simplified";//"new-delivery2";
    private static final String DELIVERIES_PAGE="deliveries";

    /*
    some attributes of deliveryDTO are checked here for errors
    the reason for doing it this way instead of with annotations is that the attributes checked here
    are not always required. if those attributes were checked with annotations(like @Min) they could
    throw an error, even if the value of the attribute is irrelevant
     */
    private void checkDeliveryForErrors(DeliveryDTO2 deliveryDTO2, BindingResult bindingResult){
        boolean[] truthValues={deliveryDTO2.getArticleHeight()>0,deliveryDTO2.getArticleWeight()>0,deliveryDTO2.getArticleWidth()>0,
                deliveryDTO2.getArticleLength()>0,deliveryDTO2.getArticleNumber()>0};
        String[] names ={"Article height", "Article weight", "Article width", "Article length", "Article number"};
        String[] fieldNames ={"articleHeight", "articleWeight", "articleWidth", "articleLength", "articleNumber"};
        String errorMessage = " must be greater than 0";
        for(int i = 0; i< 5; i++){
            if(!truthValues[i]){
                String fieldName = fieldNames[i];
                String name = names[i];
                //System.out.println(name);
                bindingResult.rejectValue(fieldName,"deliveryDTO2."+fieldName,name+errorMessage);
            }
        }
    }

    @GetMapping("/new-delivery")
    public String newDelivery(DeliveryDTO2 deliveryDTO2){
        return NEW_DELIVERY_PAGE;
    }

    @PostMapping("new-delivery")
    public String newDeliveryPost(Principal principal, @Valid DeliveryDTO2 deliveryDTO2, BindingResult bindingResult, @RequestParam(required = false) String create,
                                  @RequestParam(required = false) String delete){
        //System.out.println(deliveryDTO2);
        //System.out.println(delete);
        if(create==null&&delete==null) {
            checkDeliveryForErrors(deliveryDTO2,bindingResult);
            if(!bindingResult.hasErrors()) {
                deliveryDTO2.add();
            }
            return NEW_DELIVERY_PAGE;
        }
        else if(create!=null&&create.equals("create")){
            if(deliveryDTO2.getArticles().size()==0){
                bindingResult.rejectValue("articles","deliveryDTO2.articles","delivery must contain at least 1 article");
                return NEW_DELIVERY_PAGE;
            }
            if(bindingResult.hasErrors()){
                return NEW_DELIVERY_PAGE;
            }
            String id = principal.getName();
            Customer sender = (Customer) customerService.loadUserByUsername(id);
            deliveryDTO2.setSender(sender);
            //System.out.println(deliveryDTO2);
            Delivery delivery = new Delivery(deliveryDTO2);
            //System.out.println(delivery);
            deliveryService.createDelivery(delivery);
            return DELIVERIES_PAGE;
        }
        else if(delete!=null){
            int articleToDelete=Integer.parseInt(delete);
            deliveryDTO2.getArticles().remove(articleToDelete);
            return NEW_DELIVERY_PAGE;
        }
        else{
            return NEW_DELIVERY_PAGE;
        }
    }

}