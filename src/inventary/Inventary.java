/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
    private File DEVOLUTION = new File("/Users/jake/NetBeansProjects/Inventary/src/inventary/DEV.txt");
    
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
            
            status = "INICIADO";
                   
            BufferedWriter deliveries =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DELIVERIES, true), "utf-8"));            
            
            deliveries.write(id + "," + orderId + "," + status + "," + getDate() + "\r\n");                                                            
            deliveries.close();                                  
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }          
    }     
    
    public void newDevolution(String id, String idOldArticle, String idNewArticle) {
              
        try {
                   
            BufferedWriter devolution =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DEVOLUTION, true), "utf-8"));            
            
            devolution.write(id + "," + idOldArticle + "," + idNewArticle + "," + getDate() + "\r\n");                                                            
            devolution.close();                                  
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }          
    } 
    
    public void allOrders() {
        
        try {            
            if(ORDERS.exists()){
                
                BufferedReader buffer = new BufferedReader(new FileReader(ORDERS));                
                String lines;
                                
                while((lines = buffer.readLine())!= null) {                
                    System.out.println("Id: " + lines.split(",")[0]);
                    System.out.println("Order: " + lines.split(",")[1]);
                    System.out.println("Client: " + lines.split(",")[2]);
                    System.out.println("Direction: " + lines.split(",")[3]);
                    System.out.println("Phone: " + lines.split(",")[4]);
                    System.out.println("NIT: " + lines.split(",")[5]);
                    System.out.println("Article: " + lines.split(",")[6]);
                    System.out.println("Amount: " + lines.split(",")[7]);
                    System.out.println("Price: " + lines.split(",")[8]);
                    System.out.println("Date: " + lines.split(",")[9]);
                }
                
                buffer.close();
              }else{
                System.out.println("Fichero No Existe");
              }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
    }
    
    public void allOrdersPerDay(String date) {
        try {            
            if(ORDERS.exists()){
                
                BufferedReader buffer = new BufferedReader(new FileReader(ORDERS));                
                String lines;
                
                while((lines = buffer.readLine())!= null) {
                    if(lines.indexOf(",")!= -1){
                        if (lines.split(",")[9].equalsIgnoreCase(date)) {                        
                            System.out.println("Id: " + lines.split(",")[0]);
                            System.out.println("Order: " + lines.split(",")[1]);
                            System.out.println("Client: " + lines.split(",")[2]);
                            System.out.println("Direction: " + lines.split(",")[3]);
                            System.out.println("Phone: " + lines.split(",")[4]);
                            System.out.println("NIT: " + lines.split(",")[5]);
                            System.out.println("Article: " + lines.split(",")[6]);
                            System.out.println("Amount: " + lines.split(",")[7]);
                            System.out.println("Price: " + lines.split(",")[8]);
                            System.out.println("Date: " + lines.split(",")[9]);
                        } 
                    }
                }                                               
                
                buffer.close();
              }else{
                System.out.println("Fichero No Existe");
              }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
    }
    
    public void allDeliveriesByStatus(String status) {
        try {            
            if(ORDERS.exists()){
                
                BufferedReader buffer = new BufferedReader(new FileReader(DELIVERIES));                
                String lines;
                
                while((lines = buffer.readLine())!= null) {
                    if(lines.indexOf(",")!= -1){
                        if (lines.split(",")[2].equalsIgnoreCase(status)) {                        
                                                       
                            System.out.println("Id: " + lines.split(",")[0]);
                            System.out.println("Order: " + lines.split(",")[1]);
                            System.out.println("Status: " + lines.split(",")[2]);                           
                        } 
                    }
                }                                               
                
                buffer.close();
              }else{
                System.out.println("Fichero No Existe");
              }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
    }
    
    public void allSustitutions() {
        
    }
    
    public void generalReport() {
        
    }
    
    
    
    public String getDate() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();        
        
        return dateFormat.format(date).toString();
    }
}
