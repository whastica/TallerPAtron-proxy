/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.taller_facade_proxy.access;

import co.edu.unicauca.taller_facade_proxy.domain.Customer;
import co.edu.unicauca.taller_facade_proxy.domain.Item;
import co.edu.unicauca.taller_facade_proxy.domain.Order;
import co.edu.unicauca.taller_facade_proxy.domain.State;
import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class OrderRepository implements IOrderRepository{
    
    private Connection conn;

    public OrderRepository(){
        initDataBase();
    }

    /**
     * save vehicle data
     * this method saves the vehicle in the database
     * @param newOrder
     * @return 
     */
    @Override
    public boolean save(Order newOrder) {
        try {
            //Validate product
            if (newOrder == null) {
                return false;
            }
            
            String sql = "INSERT INTO Order ( despatch, customer_id, "
                    + "                     customer_name, customer_adress, "
                    + "                     customer_mobile, customer_city, "
                    + "                     date, state, details ) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (int) newOrder.getDespatch());
            pstmt.setInt(2, (int) newOrder.getCustomer().getId());
            pstmt.setString(3, newOrder.getCustomer().getName());
            pstmt.setString(4, newOrder.getCustomer().getAdress());
            pstmt.setString(5, newOrder.getCustomer().getMobile());
            pstmt.setString(6, newOrder.getCustomer().getCity());
            pstmt.setString(7, newOrder.getDate().toString());
            pstmt.setString(8, newOrder.getState().toString());
            pstmt.setString(9, newOrder.getDetails().toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Display vehicle data
     * this method displays a list of the vehicles in the database
     * @return 
     */
    
    @Override
    public void createOrder(Order order){
    
    }
    @Override
    public List<Order> list() {
        List<Order> orders = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Order";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Order newOrder = new Order();
                Customer newCustomer = new Customer();
                
                newOrder.setDespatch(rs.getInt("despatch"));
                newCustomer.setId(rs.getInt("customer_id"));
                newCustomer.setName(rs.getString("customer_name"));
                newCustomer.setAdress(rs.getString("customer_adress"));
                newCustomer.setMobile(rs.getString("customer_mobile"));
                newCustomer.setCity(rs.getString("customer_city"));
                newOrder.setCustomer(newCustomer);
                newOrder.setDate(LocalDate.parse(rs.getString("date"), 
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                newOrder.setState(State.valueOf(rs.getString("state")));
                newOrder.setDetails((List<Item>) rs.getArray("details"));

                orders.add(newOrder);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
    
    /**
     * start the database
     * this method create a table and and makes the connection with the database
     */
    private void initDataBase(){
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Order (\n"
                + "     despatch integer PRIMARY KEY,\n"
                + "	customer_id integer NOT NULL,\n"
                + "     customer_name text NOT NULL,\n"
                + "     customer_adress text NOT NULL,\n"
                + "     customer_mobile text NOT NULL,\n"
                + "     customer_city text NOT NULL,\n"
                + "	date text NOT NULL,\n"
                + "     state text NOT NULL,\n"
                + "     details text NOT NULL\n"
                + "     "
                + ");";
        
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Connect the database
     * this method create a connection to an SQLite database 
     */
    public void connect(){
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Connect the database
     * this method create the disconnection to the database
     */
    public void disconnect(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
