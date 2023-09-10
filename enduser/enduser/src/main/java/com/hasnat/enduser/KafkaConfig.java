package com.hasnat.enduser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String value) {
        System.out.println(value);
    }

    @KafkaListener(topics = AppConstants.ORDER_TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void updatedOrder(String value) {
        System.out.println(value);
    }


}
