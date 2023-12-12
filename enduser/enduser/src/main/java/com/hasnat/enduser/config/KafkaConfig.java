package com.hasnat.enduser.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hasnat.enduser.AppConstants;
import com.hasnat.enduser.dto.OrderDto;
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

    //    OrderDto orderDto = new OrderDtoBuilder().createOrderDto().parseResponse(value);
        OrderDto orderDto = new OrderDto().parseResponse(value);

        if (orderDto != null) {
            System.out.println("Parsed OrderDtoName : " + orderDto.getOrderName());
            System.out.println("Parsed OrderDtoId : " + orderDto.getOrderId());
        } else {
            System.out.println("Failed to parse the response.");
        }

        System.out.println(orderDto);
    }


}
