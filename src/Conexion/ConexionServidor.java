    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package Conexion;

import Entidades.Broker;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
import java.net.SocketAddress;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class ConexionServidor extends  Observable implements Runnable {
        Broker informacion;
        String nombre;
        ServerSocket servidor= null;
        private int puerto;
        
        
        
       public ConexionServidor(int puerto){
           this.puerto= puerto; 
            try {
                this.servidor = new ServerSocket(5000);
            } catch (IOException ex) {
                Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
            } 
       }
        public void escuchar() throws IOException
            {
              
                    while(1<2)
                    {
                              Socket sockCliente = this.servidor.accept();
                               new Thread(new Conexion(sockCliente)).start();
                    }
           
    }

    @Override
    public void run()
    {
    ServerSocket servidor = null;
    Socket sock = null;
    DataInputStream entrada;
    DataOutputStream salida;
   // final int puerto = 5000;
    try
    {   
        servidor = new ServerSocket(puerto);
        while(true)
        {
              sock = servidor.accept();
        entrada = new DataInputStream(sock.getInputStream());
       // salida = new DataOutputStream(sock.getOutputStream());
        String recibir = entrada.readUTF(); 
      //ESTO PUEDE CAMBIAR  salida.writeUTF("lo que se desee enviar");
      //puede que se lo envie a todos
      this.setChanged();
       this.notifyObservers(recibir);
       this.clearChanged();
        
      sock.close();
        
        
        }
      
    }catch(IOException excep)
    {
        
    }
    }
    }
