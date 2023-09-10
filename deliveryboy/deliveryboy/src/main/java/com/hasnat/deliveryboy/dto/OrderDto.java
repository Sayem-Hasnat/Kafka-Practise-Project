package com.hasnat.deliveryboy.dto;

public class OrderDto {
   private final String orderName;
   private final Long orderId;

    public OrderDto(String orderName, Long orderId) {
        this.orderName = orderName;
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public Long getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}

