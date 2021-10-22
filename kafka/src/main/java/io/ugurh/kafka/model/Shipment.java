package io.ugurh.kafka.model;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class Shipment {

    private String id = UUID.randomUUID().toString();
    private String senderCustomerName;
    private String receiverCustomerName;

}
