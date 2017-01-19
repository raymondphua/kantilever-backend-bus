package com.infosupport.team2.serviceCaller;

/**
 * Created by djones on 1/19/17.
 */

import com.infosupport.team2.model.CsvModel;
import com.infosupport.team2.model.Order;
import com.infosupport.team2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.lang.time.DateUtils;

import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceCaller {

    private static final String ORDER_URL = "http://order-service/orders";

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> productList(long refreshRate) {
        Date date = new Date();
        Date refreshRateDate = DateUtils.addMinutes(date, (int) -refreshRate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = simpleDateFormat.format(refreshRateDate);
        CsvModel csvModel = new CsvModel(dateString);

        ParameterizedTypeReference<List<Order>> typeRef = new ParameterizedTypeReference<List<Order>>() {
        };

        List<Order> orders = restTemplate.exchange(ORDER_URL + "/date", HttpMethod.POST, new HttpEntity<CsvModel>(csvModel), typeRef).getBody();

        return null;
    }
}
