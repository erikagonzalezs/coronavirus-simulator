/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Conexion implements Runnable {
  
    private DataInputStream in;
    private DataOutputStream out;
     private Socket clientSocket;

    public Conexion(Socket aClientSocket)//Constructor
    {
        try
        {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            //this.start();
        }catch(IOException e)
        {
            System.out.println("Conexion: "+ e.getMessage());
        }
        
    }
    
    public void run()
    {
        boolean conectado = true;
        while(conectado)
        {
            try {
                conectado = this.menu(conectado);
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
    }

    private boolean menu(boolean conectado) throws IOException {
        TipoConexion auxiliar = TipoConexion.valueOf(this.in.readUTF());
        switch(auxiliar)
        {
            case IP:
                this.mensaje();
                    break;
            case BALANCEO:
                this.mensaje();
                    break;
            case CERRAR:
                conectado = false;
                break; 
            default:
                break;
        }
        
        
    return conectado;
    }

    private void mensaje() throws IOException {
        this.out.writeUTF("Balanceo correcto");
    }
}
