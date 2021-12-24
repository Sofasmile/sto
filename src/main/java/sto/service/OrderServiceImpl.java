package sto.service;

import sto.dao.OrderDao;
import sto.model.Master;
import sto.model.Order;

import java.time.LocalDate;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    @Override
    public Order add(Order order) {
        return orderDao.add(order);
    }

    @Override
    public Order addMaster(Master master, Order order) {
        order.getMasters().add(master);
        if (order.getStatus() == Order.Status.NEW) {
            order.setStatus(Order.Status.PROCESSING);
        }
        return orderDao.update(order);
    }

    @Override
    public Order finish(int price, Order order) {
        order.setPrice(price);
        order.setStatus(Order.Status.DONE);
        order.setEndDate(LocalDate.now());
        return orderDao.update(order);
    }


}
