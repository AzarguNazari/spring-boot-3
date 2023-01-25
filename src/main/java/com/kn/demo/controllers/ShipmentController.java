package com.kn.demo.controllers;

import com.kn.demo.domains.Shipment;
import com.kn.demo.services.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/shipments")
public class ShipmentController{

    private final ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getAllShipments(){
        return shipmentService.getAllShipments();
    }

    @PostMapping
    public void addNewShipment(@RequestBody Shipment shipment){
        shipmentService.saveNewShipment(shipment);
    }


}
