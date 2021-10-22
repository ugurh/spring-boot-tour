package io.ugurh.kafka.controller;

import io.ugurh.kafka.model.Shipment;
import io.ugurh.kafka.service.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/shipment")
    public void sendMessageToKafkaTopic(@RequestBody Shipment shipment ) {
        this.producer.sendShipment(shipment);
    }

}