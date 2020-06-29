package com.gavrilol.bootrest.repository;

import com.gavrilol.bootrest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
