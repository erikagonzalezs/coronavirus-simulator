package Conexion;

import Entidades.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.options.Options;

public class ConexionCliente implements Runnable {
     private static String ip;
     private Socket sock;
     private DataInputStream entrada;
     private DataOutputStream salida;
     private String msj;
     private int puerto;
     
     public ConexionCliente (String ip,int puerto,String mensaje)
     {
             this.puerto = puerto;
             this.msj = mensaje;
             this.ip = ip;
     }  
     
    
     
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    

          public void run() 
    {
        DataInputStream entrada;
        DataOutputStream salida;
        try
        {
        Socket sock = new Socket(ip,puerto);
        entrada = new DataInputStream(sock.getInputStream());
        salida = new DataOutputStream(sock.getOutputStream());
        salida.writeUTF(msj);
        sock.close();
        
        
        }catch(IOException exc)
        {
        
        }

    }

        
        
        
    }

  