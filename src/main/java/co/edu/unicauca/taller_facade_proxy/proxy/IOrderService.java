/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.taller_facade_proxy.proxy;

import co.edu.unicauca.taller_facade_proxy.access.IOrderRepository;

/**
 *
 * @author Whalen Stiven Caicedo  <whastica@unicauca.edu.co>
 */
public interface IOrderService {
    public void save(IOrderRepository repo);
}
