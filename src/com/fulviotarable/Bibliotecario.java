package com.fulviotarable;

/**
 *
 * @author Fulvio
 */
public class Bibliotecario {
    public static void main(String []args)
    {
          
/** 
 *  Crea gli oggetti del pattern MVC e visualizza il pannello comandi 
 */
        BibliotecarioVista BV = new BibliotecarioVista();        
        BibliotecarioModello BM = new BibliotecarioModello();
        BibliotecarioControllore BC = new BibliotecarioControllore(BV,BM);       
        
        BV.setVisible(true);
    }
        
}