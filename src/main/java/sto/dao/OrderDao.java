package sto.dao;

import sto.model.Order;

public interface OrderDao {
    Order add(Order order);
    Order update(Order order);
}
