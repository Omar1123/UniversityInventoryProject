/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jake
 */
public class Inventary {

    private File ARTICLES = new File("/Users/jake/NetBeansProjects/Inventary/src/inventary/ART.txt");
    private File ORDERS = new File("/Users/jake/NetBeansProjects/Inventary/src/inventary/ORD.txt");
    private File DELIVERIES = new File("/Users/jake/NetBeansProjects/Inventary/src/inventary/DEL.txt");
    private File DEVOLUTION = new File("");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Inventary inventary = new Inventary();
            inventary.start();
        } catch(Exception ex) {
            System.out.println("Error starting the project");
        }
    }
    
    public void start() {
        
    }
    
    public void newArticle(String id, String code, String description, String cost, String price, String type, String amount) {
              
        try {
                   
            BufferedWriter article =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ARTICLES, true), "utf-8"));            
            
            article.write(id + "," + code + "," + description + "," + cost + "," + price + "," + type + "," + amount + "," + getDate() + "\r\n");                                                
            article.close();                                  
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }          
    }
    
    public void newOrder(String id, String orderNumber, String clientName, String direction, String phone, String nit, String articleId,
            String amount, String totalPrice, String dateDelivery) {
              
        try {
                   
            BufferedWriter orders =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ORDERS, true), "utf-8"));            
            
            orders.write(id + "," + orderNumber + "," + clientName + "," + direction + "," + phone + "," + nit + "," + articleId 
                + "," + amount + "," + totalPrice + "," + dateDelivery + "," + getDate() + "\r\n");                                                            
            orders.close();                                  
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }          
    }       
        
    public void newDeliveries(String id, String orderId, String status) {
              
        try {
                   
            BufferedWriter deliveries =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DELIVERIES, true), "utf-8"));            
            
            deliveries.write(id + "," + orderId + "," + status + "," + getDate() + "\r\n");                                                            
            deliveries.close();                                  
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }          
    }       
    
    public String getDate() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();        
        
        return dateFormat.format(date).toString();
    }
}
