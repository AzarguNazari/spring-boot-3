package com.kn.demo.controllers;

import com.kn.demo.domains.Shipment;
import com.kn.demo.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/shipments")
public class ShipmentController{

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getAllShipments(){
        return shipmentService.getAllShipments();
    }

    @PostMapping
    public void addNewShipment(@RequestBody Shipment shipment){
        shipmentService.saveNewShipment(shipment);
    }


}
