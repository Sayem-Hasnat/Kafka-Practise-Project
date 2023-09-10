package com.hasnat.deliveryboy.service;

import com.hasnat.deliveryboy.config.AppConstants;
import com.hasnat.deliveryboy.dto.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location) {

        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);

        return true;
    }

    public boolean updateOrder(OrderDto orderDto) {
        this.kafkaTemplate.send(AppConstants.ORDER_TOPIC_NAME, orderDto.toString());
        return true;
    }



}
