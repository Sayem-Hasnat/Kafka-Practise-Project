package com.hasnat.deliveryboy.controller;

import com.hasnat.deliveryboy.dto.OrderDto;
import com.hasnat.deliveryboy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {

        for (int i = 1; i <= 50000; i++) {
            this.kafkaService.updateLocation("( " + i + " , " + Math.round(Math.random() * 100) + " " + ")");
            this.kafkaService.
                    updateOrder(new OrderDto("orderName", Long.valueOf(String.valueOf(i))));
        }

        return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
    }

}
