package com.snowshark.MagicPost.controllers;

import com.snowshark.MagicPost.entities.Shipment;
import com.snowshark.MagicPost.services.ShipmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentServices shipmentService;

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments() {
        List<Shipment> shipments = shipmentService.getAllShipments();
        return ResponseEntity.ok(shipments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable String id) {
        Shipment shipment = shipmentService.getShipmentById(id);
        return ResponseEntity.ok(shipment);
    }

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
        Shipment createdShipment = shipmentService.createShipment(shipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> updateShipment(@PathVariable String id, @RequestBody Shipment shipment) {
        shipment.setId(id); // Ensure ID is set for update
        Shipment updatedShipment = shipmentService.updateShipment(shipment);
        return ResponseEntity.ok(updatedShipment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipmentById(@PathVariable String id) {
        shipmentService.deleteShipmentById(id);
        return ResponseEntity.noContent().build();
    }
}
