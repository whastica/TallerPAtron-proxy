/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.taller_facade_proxy.facade;

import co.edu.unicauca.taller_facade_proxy.access.IOrderRepository;
import co.edu.unicauca.taller_facade_proxy.access.OrderRepository;
import co.edu.unicauca.taller_facade_proxy.domain.Customer;
import co.edu.unicauca.taller_facade_proxy.domain.Dish;
import co.edu.unicauca.taller_facade_proxy.domain.Order;
import co.edu.unicauca.taller_facade_proxy.domain.State;
import co.edu.unicauca.taller_facade_proxy.proxy.ProxyClient;

/**
 *
 * @author ASUS
 */
public class OrderFacade {
    private Order order = new Order();
    private Dish dish = new Dish();
    private ProxyClient proxy = new ProxyClient();
    
    
    public void createOrder(Customer customer){
        proxy.createOrder();
    }
    
    public void addDish(Dish dish, int amount){
        order.addDish(dish, amount);
    }
    
    public void changeState(State state){
        order.setState(state);
    }
    
    public void cancelOrder(State CANCELED){
        order.setState(CANCELED);
    }
    
    public int calculateTota(){
        return order.CalculateTotal();
    }
    
    public Order getOrder(){
        return order;
    }
    
    public int totalDishes(){
        int total = 0;
        for(int i=0; i<order.getDetails().size();i++){
            total+= order.getDetails().get(i).getDish().getPriece();
        }
        return total;
    }
    
    public void save(IOrderRepository repo){
        repo.save(order);
    }

    public String calculateTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
