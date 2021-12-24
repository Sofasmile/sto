package sto.service;

import sto.model.Master;
import sto.model.Order;
// update order(PROCESSING, add masters)
// update order (DONE, price, endDate)
public interface OrderService {
    Order add(Order order);
    Order addMaster(Master master, Order order);
    Order finish(int price, Order order);
}
