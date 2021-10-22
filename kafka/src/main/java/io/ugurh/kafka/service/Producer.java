package io.ugurh.kafka.service;

import io.ugurh.kafka.model.Shipment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {
    private static final String TOPIC = "shipment";

    @Autowired
    KafkaTemplate<String, Shipment> kafkaTemplate;

    public void sendShipment(Shipment shipment) {
        log.info(String.format("# -> Producer -> %s", shipment));
        kafkaTemplate.send(TOPIC, shipment);
    }
}
