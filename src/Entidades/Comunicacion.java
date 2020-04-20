/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Leonel
 */


public class Comunicacion
{

    /**
     *
     */
    public Map<String,Integer> canal;
    
    Comunicacion()
    {
        canal=null;
    }
    public Comunicacion(Map auxiliar) 
    {
    canal=auxiliar;
   
    }

    public Map<String, Integer> getCanal() {
        return canal;
    }

    public void setCanal(Map<String, Integer> canal) {
        this.canal = canal;
    }
    public void setValor(String key,int value)
    {int dato;
        
                    if(canal.containsKey(key))
                    {
                        canal.put(key, value);
                    }
  
           
    }

}
