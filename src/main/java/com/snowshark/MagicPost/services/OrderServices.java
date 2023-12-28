package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Order;

import java.util.List;

public interface OrderServices {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrderById(Long id);

    List<Order> getOrdersByShipmentId(String shipmentId);

}
