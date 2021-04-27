/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.taller_facade_proxy.domain;

/**
 *
 * @author ASUS
 */
public class Dish {
    private int id;
    private String name;
    private int priece;
    
    public Dish(){
    }

    public Dish(int id, String name, int priece) {
        this.id = id;
        this.name = name;
        this.priece = priece;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriece() {
        return priece;
    }

    public void setPriece(int priece) {
        this.priece = priece;
    }
}
