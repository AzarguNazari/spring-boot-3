package com.kn.demo.services;

import com.kn.demo.domains.Shipment;
import com.kn.demo.exceptions.InvalidShipmentException;
import com.kn.demo.repositories.ShipmentRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public record ShipmentService(
        ShipmentRepository shipmentRepository
) {

    public List<Shipment> getAllShipments(){
        return shipmentRepository.findAll();
    }

    public void saveNewShipment(Shipment shipment){
        if(shipment.origin().equalsIgnoreCase(shipment.destination())){
            throw new InvalidShipmentException();
        }
        else{
            shipmentRepository.save(shipment);
        }
    }

}
