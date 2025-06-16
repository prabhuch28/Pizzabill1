package com.pizza.repository;

import com.pizza.model.PizzaOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaOrderRepository extends MongoRepository<PizzaOrder, String> {
}
