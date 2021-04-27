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
public class Customer {
    private int id;
    private String name;
    private String adress;
    private String mobile;
    private String city;

    public Customer(){}
    
    public Customer(int id, String name, String adress, String mobile, String city) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.mobile = mobile;
        this.city = city;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
