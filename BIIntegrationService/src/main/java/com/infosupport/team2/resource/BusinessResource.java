package com.infosupport.team2.resource;

import com.infosupport.team2.model.BusinessKeyModel;
import com.infosupport.team2.model.DateRequestModel;
import com.infosupport.team2.serviceCaller.OrderServiceCaller;
import com.infosupport.team2.util.ConvertUtil;
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
public class BusinessResource{

    @Autowired
    BeanFactory beanFactory;

    @RequestMapping(value= "/{historyInMinutes}", method = RequestMethod.GET)
    public List<BusinessKeyModel> get(@PathVariable("historyInMinutes") int historyInMinutes, HttpServletRequest request) {
        OrderServiceCaller orderServiceCaller = beanFactory.getBean(OrderServiceCaller.class);
        DateRequestModel model = new DateRequestModel(ConvertUtil.historyFromMinutes(historyInMinutes), "besteld");
        List<BusinessKeyModel> businessKeys = orderServiceCaller.getBusinessKeys(request, model);

        return businessKeys;
    }
}
