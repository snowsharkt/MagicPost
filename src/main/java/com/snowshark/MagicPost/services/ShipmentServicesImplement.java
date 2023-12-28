package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Shipment;
import com.snowshark.MagicPost.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServicesImplement implements ShipmentServices {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipmentById(String id) {
        return shipmentRepository.findById(id).orElse(null);
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment updateShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public void deleteShipmentById(String id) {
        shipmentRepository.deleteById(id);
    }
}
