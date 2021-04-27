/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unicauca.taller_facade_proxy.proxy;

import co.edu.unicauca.taller_facade_proxy.access.IOrderRepository;
import co.edu.unicauca.taller_facade_proxy.facade.OrderFacade;

/**
 * 
 * @author Whalen Stiven Caicedo  <whastica@unicauca.edu.co>
 */
public class OrderServiceLogger implements IOrderService {
    private OrderFacade OrderFacade;

    public OrderServiceLogger(OrderFacade OrderFacade) {
        this.OrderFacade = OrderFacade;
    }
    public void save(IOrderRepository repo){
        repo.createOrder(OrderFacade.getOrder());
        System.out.println("Pedido Guardado en la base de datos");
    }
}
