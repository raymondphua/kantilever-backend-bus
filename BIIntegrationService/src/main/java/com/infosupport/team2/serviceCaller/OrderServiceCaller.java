package com.infosupport.team2.serviceCaller;

import com.infosupport.team2.model.OrderDataModel;
import com.infosupport.team2.util.ConvertUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Robin on 23-1-2017.
 */
@Service
public class OrderServiceCaller {
    private static final String ORDER_URL = "http://localhost:11113/orders?dateAfter=";
    private RestTemplate restTemplate;

    public OrderServiceCaller() {
        restTemplate = new RestTemplate();
    }

    public List<OrderDataModel> getBusinessKeys(HttpServletRequest request, int historyMinutes) {
        ParameterizedTypeReference<List<OrderDataModel>> typeRef = new ParameterizedTypeReference<List<OrderDataModel>>() {
        };

        HttpHeaders headers = new HttpHeaders();
        String authorization = request.getHeader("Authorization");
        headers.add("Authorization", authorization);

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        List<OrderDataModel> orders = restTemplate.exchange(ORDER_URL + ConvertUtil.historyFromMinutes(historyMinutes), HttpMethod.GET, entity, typeRef).getBody();

        return orders;
    }
}
