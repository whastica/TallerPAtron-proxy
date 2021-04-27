/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unicauca.taller_facade_proxy.proxy;

import co.edu.unicauca.taller_facade_proxy.access.IOrderRepository;
import co.edu.unicauca.taller_facade_proxy.access.RepositoryFactory;

/**
 * 
 * @author Whalen Stiven Caicedo  <whastica@unicauca.edu.co>
 */
public class ProxyClient implements IOrderService {
    private IOrderService orderService;

    public ProxyClient(IOrderService orderService) {
        this.orderService = orderService;
    }

    public ProxyClient() {
    }
    
    public void save(IOrderRepository repo){
    
    }
    
    public void ProxyClient(IOrderService orderService){
    }
    
    public void createOrder(){
        IOrderRepository repo = RepositoryFactory.getInstance().getRepository("default");
        orderService.save(repo);
    }
}
