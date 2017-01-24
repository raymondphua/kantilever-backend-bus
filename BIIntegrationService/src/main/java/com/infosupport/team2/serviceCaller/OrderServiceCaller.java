package com.infosupport.team2.serviceCaller;

import com.google.gson.Gson;
import com.infosupport.team2.model.BusinessKeyModel;
import com.infosupport.team2.model.DateRequestModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Robin on 23-1-2017.
 */
@Service
public class OrderServiceCaller {
    private static final String ORDER_URL = "http://localhost:11113/orders";
    private RestTemplate restTemplate;

    public OrderServiceCaller() {
        restTemplate = new RestTemplate();
    }

    public List<BusinessKeyModel> getBusinessKeys(HttpServletRequest request, DateRequestModel fromDate) {
        ParameterizedTypeReference<List<BusinessKeyModel>> typeRef = new ParameterizedTypeReference<List<BusinessKeyModel>>() {};

        HttpHeaders headers = new HttpHeaders();
        String authotization = request.getHeader("Authorization");
        headers.add("Authorization", authotization);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> map = new HashMap<String, String>();
        map.put("date", fromDate.getDate());
        map.put("status", fromDate.getStatus());


        Gson gson = new Gson();
        String json = gson.toJson(map);


        HttpEntity<String> entity = new HttpEntity<String>(json, headers);

        List<BusinessKeyModel> orders = restTemplate.exchange(ORDER_URL + "/date", HttpMethod.POST, entity, typeRef).getBody();

        return orders;
    }
}
