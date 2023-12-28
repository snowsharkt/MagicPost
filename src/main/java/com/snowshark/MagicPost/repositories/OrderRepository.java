package com.snowshark.MagicPost.repositories;

import com.snowshark.MagicPost.entities.Order;
import com.snowshark.MagicPost.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByShipment(Shipment shipment);
}
