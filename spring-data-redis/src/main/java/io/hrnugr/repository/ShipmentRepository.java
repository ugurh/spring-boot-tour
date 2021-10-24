package io.hrnugr.repository;

import io.hrnugr.entity.Shipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

    List<Shipment> findBySenderCustomerId(Long senderCustomerId);
    List<Shipment> findByReceiverCustomerId(Long receiverCustomerId);

}
