package com.infosupport.team2.resource;

import com.infosupport.team2.model.OrderDataModel;
import com.infosupport.team2.serviceCaller.OrderServiceCaller;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Robin on 23-1-2017.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/orders")
public class BusinessResource {

    @Autowired
    BeanFactory beanFactory;

    @RequestMapping(value = "/{historyInMinutes}", method = RequestMethod.GET)
    public List<OrderDataModel> get(@PathVariable("historyInMinutes") int historyInMinutes, HttpServletRequest request) {
        OrderServiceCaller orderServiceCaller = beanFactory.getBean(OrderServiceCaller.class);
        List<OrderDataModel> businessKeys = orderServiceCaller.getBusinessKeys(request, historyInMinutes);

        return businessKeys;
    }
}
