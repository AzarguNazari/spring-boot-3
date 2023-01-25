package com.kn.demo.repositories;

import com.kn.demo.domains.Shipment;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ShipmentRepository {

    private final Logger log = LoggerFactory.getLogger(ShipmentRepository.class);


    private static final ConcurrentHashMap<String, Shipment> shipments = new ConcurrentHashMap<>();

    static {
        shipments.put(UUID.randomUUID().toString(), new Shipment(UUID.randomUUID(), 1L, "FR", "CN"));
        shipments.put(UUID.randomUUID().toString(), new Shipment(UUID.randomUUID(), 2L, "HAM", "BRL"));
    }

    public List<Shipment> findAll(){
        return shipments.values().stream().toList();
    }

    public void save(Shipment shipment){
        try{
            shipments.put(UUID.randomUUID().toString(), shipment);
        }
        catch(Exception ex){
            log.error("Shipment {} cannot be stored", shipment);
        }
    }

    public Shipment findById(String shipmentId){
        return shipments.get(shipmentId);
    }

}
