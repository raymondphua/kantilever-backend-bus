package com.infosupport.team2.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Raymond Phua on 26-1-2017.
 */
public class ProductTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void generateKey_DefaultProductFromConstructor_CreatesCorrectlyGeneratedKey() {
        //ARRANGE
        Product product = new Product("1", 2L,"BAT", "Road-150 Red, 62", "This bike is ridden by race winners. Developed with the Adventure Works Cycles professional race team, it has a extremely light heat-treated aluminum frame, and steering that allows precision control.", "http://res.cloudinary.com/kantilever/image/upload/v1484171992/bike3_vhdpgz.png", 1366, LocalDate.now(), LocalDate.now().plusDays(1), "LJ-0192-S", new Brand("2","Jumbo"), null, "road-150-red-62");
        String expectedKey = "prd-BAT-LJ0192S";

        //ASSERT
        assertThat(product.getProductKey(), is(expectedKey));
    }

    @Test
    public void generateKey_DefaultProductFromConstructor_ShouldThrowException() {
        //ARRANGE
        thrown.expect(NullPointerException.class);
        new Product("1", 2L, null, "Road-150 Red, 62", "This bike is ridden by race winners. Developed with the Adventure Works Cycles professional race team, it has a extremely light heat-treated aluminum frame, and steering that allows precision control.", "http://res.cloudinary.com/kantilever/image/upload/v1484171992/bike3_vhdpgz.png", 1366, LocalDate.now(), LocalDate.now().plusDays(1), null, new Brand("2","Jumbo"), null, "road-150-red-62");
    }
}