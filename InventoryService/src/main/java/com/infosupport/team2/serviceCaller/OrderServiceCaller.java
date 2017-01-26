package com.infosupport.team2.serviceCaller;

/**
 * Created by djones on 1/19/17.
 */

import com.infosupport.team2.model.Order;
import com.infosupport.team2.model.Product;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceCaller {

    private static final String ORDER_URL = "http://order-service/orders";
    private static final String AUTH_URL = "http://localhost:11150/oauth/token?grant_type=password&username=dennis@kantilever.nl&password=denny1&client_id=kantilever&client_secret=kantiSecret";

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate localTemplate;

    public List<Product> productList(long refreshRate) {
        Instant date = Instant.now();
        date = date.minusMillis(refreshRate);

        String token = getToken();
        if(token != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token);
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ParameterizedTypeReference<List<Order>> typeRef = new ParameterizedTypeReference<List<Order>>() {
            };
            List<Order> orders = restTemplate.exchange(ORDER_URL + "?dateafter=" + date.toEpochMilli(), HttpMethod.GET, entity, typeRef).getBody();
            List<Product> allProducts = new ArrayList<>();
            orders.forEach(o -> {
                o.getOrderedProducts().forEach(p -> {
                    allProducts.add(p);
                });
            });

            return allProducts;
        }else{
            return new ArrayList<Product>();
        }
    }

    private String getToken(){
        ResponseEntity<String> loginResponse = localTemplate
                .exchange(AUTH_URL, HttpMethod.POST, null, String.class);
        if (loginResponse.getStatusCode() == HttpStatus.OK) {
            JSONObject authJson = new JSONObject(loginResponse.getBody());
            return authJson.getString("access_token");
        } else {
            return null;
        }
    }
}
