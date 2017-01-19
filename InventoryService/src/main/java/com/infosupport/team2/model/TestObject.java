package com.infosupport.team2.model;

/**
 * Created by djones on 1/17/17.
 */

public class TestObject {

    private String id;
    private String quantity;

    public TestObject() {

    }

    public TestObject(String id, String quantity) {
        this.id = id;
        this.quantity = quantity;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
