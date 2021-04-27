/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.taller_facade_proxy.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Order {
    int despatch;
    private Customer customer;
    private LocalDate date;
    private State state;
    private List<Item> details;

    public Order(Customer customer) {
        this.customer = customer;
        this.details = new ArrayList<Item>();
    }

    public Order() {
        this.details = new ArrayList<Item>();
    }

    public void addDish(Dish dish, int amount){
        details.add(new Item(dish, amount));
    }
    
    public int CalculateTotal(){
        int i = 0, detSize = details.size(), total = 0;
        
        while(i<detSize){
            total += details.get(i).getAmount();
        }
        return total;
    }
    
    public int getDespatch() {
        return despatch;
    }

    public void setDespatch(int despatch) {
        this.despatch = despatch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Item> getDetails() {
        return details;
    }

    public void setDetails(List<Item> details) {
        this.details = details;
    }
}
