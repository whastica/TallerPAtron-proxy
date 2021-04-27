/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.taller_facade_proxy.access;

/**
 *
 * @author ASUS
 */
public class RepositoryFactory {
    private static RepositoryFactory instance;
    
    private RepositoryFactory(){
        
    }
    
    /**
     * create instance for RepositoryFactory
     * this method get instance of  the factory
     * @return 
     */
    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

    }
    
    /**
     * this method get repository
     * @param type
     * @return 
     */
    public IOrderRepository getRepository(String type) {

        IOrderRepository result = null;

        switch (type) {
            case "default":
                result = new OrderRepository();
                break;
        }

        return result;
    }
}
