package org.scoula;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration
@Log4j
class RestaurantTest {
    @Autowired
    private Restaurant restaurant;

    @Test
    void getChef(){
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("----------------------");
        log.info(restaurant.getChef());

    }
}