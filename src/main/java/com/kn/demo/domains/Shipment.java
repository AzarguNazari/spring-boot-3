package com.kn.demo.domains;

import java.util.UUID;

public record Shipment(
        UUID id,
        Long trackingNumber,
        String origin,
        String destination
) {}
