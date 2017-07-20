package com.sopra.cloud.purchaseorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.cloud.purchaseorder.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

}
