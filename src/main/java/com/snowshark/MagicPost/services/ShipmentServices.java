package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Shipment;

import java.util.List;

public interface ShipmentServices {

    List<Shipment> getAllShipments();

    Shipment getShipmentById(String id);

    Shipment createShipment(Shipment shipment);

    Shipment updateShipment(Shipment shipment);

    void deleteShipmentById(String id);
}
