#!/bin/bash

#http :8080/v1/shipments

#http :8080/v1/shipments shipment:='{ "destination": "BRL", "id": "04e4457a-075a-486e-b9ce-807a25c6208a", "origin": "HAM", "trackingNumber": 2 }'
http POST :8080/v1/shipments <<<'{ "destination": "BRL", "id": "04e4457a-075a-486e-b9ce-807a25c6208a", "origin": "BRL", "trackingNumber": 4 }'
