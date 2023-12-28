package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Order;
import com.snowshark.MagicPost.entities.Shipment;
import com.snowshark.MagicPost.repositories.OrderRepository;
import com.snowshark.MagicPost.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServicesImplement implements OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        Shipment shipment = shipmentRepository.findById(order.getShipment().getId()).orElse(null);
        if (shipment != null) {
            order.setShipment(shipment);
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Shipment not found");
        }
    }

    @Override
    public Order updateOrder(Order order) {
        Shipment shipment = shipmentRepository.findById(order.getShipment().getId()).orElse(null);
        if (shipment != null) {
            order.setShipment(shipment);
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Shipment not found");
        }
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrdersByShipmentId(String shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId).orElse(null);
        if (shipment != null) {
            return orderRepository.findByShipment(shipment);
        } else {
            return new ArrayList<>();
        }
    }
}
