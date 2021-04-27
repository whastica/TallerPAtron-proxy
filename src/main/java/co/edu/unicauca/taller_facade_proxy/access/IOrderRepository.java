/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.taller_facade_proxy.access;

import co.edu.unicauca.taller_facade_proxy.domain.Customer;
import co.edu.unicauca.taller_facade_proxy.domain.Order;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IOrderRepository {
    public boolean save(Order newOrder);
    public void createOrder(Order order);
    List<Order>list();
}
