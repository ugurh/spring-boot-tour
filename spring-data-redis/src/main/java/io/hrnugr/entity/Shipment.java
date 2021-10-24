package io.hrnugr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Date;

@RedisHash("Shipment")
public class Shipment {

    @Id
    private Long id;
    private Date deliveryDate;
    @Indexed
    private Long senderCustomerId;
    @Indexed
    private Long receiverCustomerId;

    public Shipment(Long id, Date deliveryDate, Long senderCustomerId, Long receiverCustomerId) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.senderCustomerId = senderCustomerId;
        this.receiverCustomerId = receiverCustomerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getSenderCustomerId() {
        return senderCustomerId;
    }

    public void setSenderCustomerId(Long senderCustomerId) {
        this.senderCustomerId = senderCustomerId;
    }

    public Long getReceiverCustomerId() {
        return receiverCustomerId;
    }

    public void setReceiverCustomerId(Long receiverCustomerId) {
        this.receiverCustomerId = receiverCustomerId;
    }
}