package Entidades;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pais extends Thread {
    //---------------------------------------
    //Atributos
    //----------------------------------------

    private ArrayList<String> conexionesAereas;
    private ArrayList<String> conexionesTerrestres;
    private ArrayList<Pais> conectados;

    public ArrayList<Pais> getConectados() {
        return conectados;
    }

    public void setConectados(ArrayList<Pais> conectados) {
        this.conectados = conectados;
    }
    public int poblacion;
    public float porcentajeContagiados;
    public float porcentajePoblacionVulnerable;
    public float porcentajeAislamiento;
    public String ip;
    public String nombre;
    public int poblacionContagiada;
    public int poblacionVulnerable;
    public int poblacionAislamiento;
    public int fallecidosPorVirus;
    public int poblacionContagiadaVulnerable;
    public int poblacionContagiadaNovulnerable;
    public int poblacionNovulnerable;
    public int poblacionSana;

    public float tasaPropagacionNovulnerable;
    public float tasaPropagacionVulnerable;
    public float tasaMortalidadVulnerable;
    public float tasaMortalidadNovulnerable;
    public Comunicacion comu;
    public int identificador;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Comunicacion getComu() {
        return comu;
    }

    public void setComu(Comunicacion comu) {
        this.comu = comu;
    }

    public int getPoblacionContagiadaVulnerable() {
        return poblacionContagiadaVulnerable;
    }

    public void setPoblacionContagiadaVulnerable(int poblacionContagiadaVulnerable) {
        this.poblacionContagiadaVulnerable = poblacionContagiadaVulnerable;
    }

    public int getPoblacionContagiadaNovulnerable() {
        return poblacionContagiadaNovulnerable;
    }

    public void setPoblacionContagiadaNovulnerable(int poblacionContagiadaNovulnerable) {
        this.poblacionContagiadaNovulnerable = poblacionContagiadaNovulnerable;
    }

    public int getFallecidosPorVirus() {
        return fallecidosPorVirus;
    }

    public float getTasaPropagacionNovulnerable() {
        return tasaPropagacionNovulnerable;
    }

    public void setTasaPropagacionNovulnerable(float tasaPropagacionNovulnerable) {
        this.tasaPropagacionNovulnerable = tasaPropagacionNovulnerable;
    }

    public float getTasaPropagacionVulnerable() {
        return tasaPropagacionVulnerable;
    }

    public void setTasaPropagacionVulnerable(float tasaPropagacionVulnerable) {
        this.tasaPropagacionVulnerable = tasaPropagacionVulnerable;
    }

    public float getTasaMortalidadVulnerable() {
        return tasaMortalidadVulnerable;
    }

    public void setTasaMortalidadVulnerable(float tasaMortalidadVulnerable) {
        this.tasaMortalidadVulnerable = tasaMortalidadVulnerable;
    }

    public float getTasaMortalidadNovulnerable() {
        return tasaMortalidadNovulnerable;
    }

    public void setTasaMortalidadNovulnerable(float tasaMortalidadNovulnerable) {
        this.tasaMortalidadNovulnerable = tasaMortalidadNovulnerable;
    }

    public void setFallecidosPorVirus(int fallecidosPorVirus) {
        this.fallecidosPorVirus = fallecidosPorVirus;
    }

    public int getPoblacionContagiada() {
        return poblacionContagiada;
    }

    public void setPoblacionContagiada(int poblacionContagiada) {
        this.poblacionContagiada = poblacionContagiada;
    }

    public int getPoblacionVulnerable() {
        return poblacionVulnerable;
    }

    public void setPoblacionVulnerable(int poblacionVulnerable) {
        this.poblacionVulnerable = poblacionVulnerable;
    }

    public int getPoblacionAislamiento() {
        return poblacionAislamiento;
    }

    public void setPoblacionAislamiento(int poblacionAislamiento) {
        this.poblacionAislamiento = poblacionAislamiento;
    }

    Pais() {
        conexionesAereas = new ArrayList<>();
        conexionesTerrestres = new ArrayList<>();
        conectados = new ArrayList<>();
        poblacion = 0;
        porcentajeAislamiento = 0;
        porcentajeContagiados = 0;
        porcentajePoblacionVulnerable = 0;
        ip = "0";
        nombre = "";
        poblacionContagiada = 0;
        poblacionVulnerable = 0;
        poblacionAislamiento = 0;
        fallecidosPorVirus = 0;
        tasaPropagacionNovulnerable = 0;
        tasaPropagacionVulnerable = 0;
        tasaMortalidadVulnerable = 0;
        tasaMortalidadNovulnerable = 0;
        poblacionContagiadaVulnerable = 0;
        poblacionContagiadaNovulnerable = 0;

    }

    public int getPoblacionNovulnerable() {
        return poblacionNovulnerable;
    }

    public void setPoblacionNovulnerable(int poblacionNovulnerable) {
        this.poblacionNovulnerable = poblacionNovulnerable;
    }

    //---------------------------------------
    //Metodos
    //----------------------------------------
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     *
     * @param pais
     */
    public Pais(String pais2, Pais p, Comunicacion comunica) {
        super(pais2);
        this.conexionesAereas = p.getConexionesAereas();
        this.conexionesTerrestres = p.getConexionesTerrestres();
        this.poblacion = p.getPoblacion();
        this.porcentajeAislamiento = p.getPorcentajeAislamiento();
        this.porcentajeContagiados = p.getPorcentajeContagiados();
        this.porcentajePoblacionVulnerable = p.getPorcentajePoblacionVulnerable();
        this.ip = p.getIp();
        this.nombre = p.getNombre();
        this.poblacionContagiada = p.getPoblacionContagiada();
        this.poblacionVulnerable = p.getPoblacionVulnerable();
        this.poblacionAislamiento = p.getPoblacionAislamiento();
        this.fallecidosPorVirus = p.getFallecidosPorVirus();
        this.tasaPropagacionNovulnerable = p.getTasaPropagacionNovulnerable();
        this.tasaPropagacionVulnerable = p.getTasaPropagacionVulnerable();
        this.tasaMortalidadVulnerable = p.getTasaMortalidadVulnerable();
        this.tasaMortalidadNovulnerable = p.getTasaMortalidadNovulnerable();
        this.poblacionContagiadaVulnerable = p.getPoblacionContagiada();
        this.poblacionContagiadaNovulnerable = 0;
        this.poblacionNovulnerable = 0;
        this.poblacionSana = p.poblacion - p.poblacionContagiada;
        this.comu = comunica;
        this.conectados = p.getConectados();
        this.identificador=p.getIdentificador();

    }
//------------------------------------------------------------------------
    //----------------------Setters--------------------------

    public int getPoblacionSana() {
        return poblacionSana;
    }

    public void setPoblacionSana(int poblacionSana) {
        this.poblacionSana = poblacionSana;
    }

    public void setConexionesAereas(ArrayList<String> conexionesAereas) {
        this.conexionesAereas = conexionesAereas;
    }

    public void setConexionesTerrestres(ArrayList<String> conexionesTerrestres) {
        this.conexionesTerrestres = conexionesTerrestres;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public void setPorcentajeContagiados(float porcentajeContagiados) {
        this.porcentajeContagiados = porcentajeContagiados;
    }

    public void setPorcentajePoblacionVulnerable(float porcentajePoblacionVulnerable) {
        this.porcentajePoblacionVulnerable = porcentajePoblacionVulnerable;
    }

    public void setPorcentajeAislamiento(float porcentajeAislamiento) {
        this.porcentajeAislamiento = porcentajeAislamiento;
    }
    //------------------------------------------------------------------------
    //----------------------Getters--------------------------

    public ArrayList<String> getConexionesAereas() {
        return conexionesAereas;
    }

    public ArrayList<String> getConexionesTerrestres() {
        return conexionesTerrestres;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public float getPorcentajeContagiados() {
        return porcentajeContagiados;
    }

    public float getPorcentajePoblacionVulnerable() {
        return porcentajePoblacionVulnerable;
    }

    public float getPorcentajeAislamiento() {
        return porcentajeAislamiento;
    }

    //------------------------------------------------------------------------
    //----------------------Otros metodos--------------------------
    @Override
    public void run() {
        int cont = 0;
        int cont2 = 0;
        this.porcentajeAcantidad();
        String aux;
        
        while (this.getPoblacionContagiada() == 0) 
        {
            for(Pais x: this.conectados)
            {
            this.Habla(x.getIp(), x.getIdentificador(),"0");
            }
           // aux = this.escucha(this.getIdentificador());
            if (this.comu.getCanal().get(this.getNombre()) != 0) 
            {
               
                cont++;
                this.setPoblacionContagiadaVulnerable(1);
                this.setPoblacionContagiadaNovulnerable(1);
                this.setPoblacionContagiada(this.getPoblacionContagiadaNovulnerable() + this.getPoblacionContagiadaVulnerable());
                this.setPoblacionVulnerable(this.getPoblacionVulnerable() - 1);
                this.setPoblacionNovulnerable(this.getPoblacionNovulnerable() - 1);
            }
            else    
            {
               String recibir = this.escucha(this.getIdentificador());
                if(recibir.contains("1"))
                {
                    cont++;
                    this.setPoblacionContagiadaVulnerable(1);
                    this.setPoblacionContagiadaNovulnerable(1);
                    this.setPoblacionContagiada(this.getPoblacionContagiadaNovulnerable() + this.getPoblacionContagiadaVulnerable());
                    this.setPoblacionVulnerable(this.getPoblacionVulnerable() - 1);
                    this.setPoblacionNovulnerable(this.getPoblacionNovulnerable() - 1);
                    
                }
            }
            // this.comu.getCanal().put(this.getNombre(), 1);
        }

        while (this.getFallecidosPorVirus() <= this.getPoblacion() && this.getPoblacion() > this.getPoblacionAislamiento()) {
            
              for(Pais x: this.conectados)
            {
            this.Habla(x.getIp(), x.getIdentificador(),"0");
            }
            int nuevaPoblacionContagiadaNo = 0;
            int nuevaPoblacionContagiadaVulnerable = 0;
            int auxNuevaPoblacionContagiadaNo = 0;
            int auxNuevaPoblacionContagiadaVulnerable = 0;
            int fallecidosVulnerable = 0;
            int fallecidosNoVulnerable = 0;

            System.out.println("nombre pais en hilos > " + this.getNombre() + "Poblacion inicial: " + this.getPoblacion());

            if (this.getPoblacionContagiada() > 0) {
                if (cont == 0) {
                    this.setPoblacionContagiadaVulnerable(1);
                    this.setPoblacionContagiadaNovulnerable(1);
                    //this.setPoblacionContagiada(this.getPoblacionContagiadaNovulnerable() + this.getPoblacionContagiadaVulnerable());
                    cont++;
                } else {
                    auxNuevaPoblacionContagiadaNo = (int) (this.getPoblacionContagiadaNovulnerable() * this.getTasaPropagacionNovulnerable());
                    auxNuevaPoblacionContagiadaVulnerable = (int) (this.getPoblacionContagiadaVulnerable() * this.getTasaPropagacionVulnerable());
                    if ((auxNuevaPoblacionContagiadaNo + auxNuevaPoblacionContagiadaVulnerable) < this.getPoblacionSana()) {
                        //Se calcula cada cierto tiempo las nuevas personas contagiadas.
                        nuevaPoblacionContagiadaNo = (int) (this.getPoblacionContagiadaNovulnerable() * this.getTasaPropagacionNovulnerable());
                        nuevaPoblacionContagiadaVulnerable = (int) (this.getPoblacionContagiadaVulnerable() * this.getTasaPropagacionVulnerable());
                        this.setPoblacionVulnerable(this.getPoblacionVulnerable() - nuevaPoblacionContagiadaVulnerable);
                        this.setPoblacionNovulnerable(this.getPoblacionNovulnerable() - nuevaPoblacionContagiadaNo);
                    } else {
                        if (cont2 == 0) {
                            this.setPoblacionContagiada(this.getPoblacion());
                            this.setPoblacionContagiadaVulnerable(this.getPoblacionVulnerable() + this.getPoblacionContagiadaVulnerable());
                            this.setPoblacionContagiadaNovulnerable(this.getPoblacionNovulnerable() + this.getPoblacionContagiadaNovulnerable());
                            this.setPoblacionSana(0);
                            cont2++;
                        }
                    }
                }

                //se actualiza en el pais las nuevas personas contagiadas.
                this.setPoblacionContagiada(nuevaPoblacionContagiadaNo + nuevaPoblacionContagiadaVulnerable + this.getPoblacionContagiada());
                this.setPoblacionContagiadaVulnerable(this.getPoblacionContagiadaVulnerable() + nuevaPoblacionContagiadaVulnerable);
                this.setPoblacionContagiadaNovulnerable(this.getPoblacionContagiadaNovulnerable() + nuevaPoblacionContagiadaNo);
                if (this.getPoblacionSana() > 0) {
                    this.setPoblacionSana(this.getPoblacionSana() - this.getPoblacionContagiada());
                }

                this.setPorcentajePoblacionVulnerable(this.porcentaje(this.getPoblacionVulnerable(), this.getPoblacion()));
                this.setPorcentajeContagiados(this.porcentaje(this.getPoblacionContagiada(), this.getPoblacion()));

                fallecidosVulnerable = (int) (this.getPoblacionContagiadaVulnerable() * this.getTasaMortalidadVulnerable() / 100);
                fallecidosNoVulnerable = (int) (this.getPoblacionContagiadaNovulnerable() * this.getTasaMortalidadNovulnerable() / 100);
                if (fallecidosVulnerable >= 1) {
                    this.setFallecidosPorVirus(fallecidosVulnerable + this.getFallecidosPorVirus());
                    this.setPoblacionContagiadaVulnerable(this.getPoblacionContagiadaVulnerable() - fallecidosVulnerable);
                    this.setPoblacion(this.getPoblacion() - fallecidosVulnerable);

                }
                if (fallecidosNoVulnerable >= 1) {
                    this.setFallecidosPorVirus(fallecidosNoVulnerable + this.getFallecidosPorVirus());
                    this.setPoblacionContagiadaNovulnerable(this.getPoblacionContagiadaNovulnerable() - fallecidosNoVulnerable);
                    this.setPoblacion(this.getPoblacion() - fallecidosNoVulnerable);
                }

                System.out.println("----------REPORTE DE " + this.getNombre() + "----------");
                System.out.println(this.getNombre() + " registra " + nuevaPoblacionContagiadaVulnerable + " casos nuevos de personas vulnerables, para un total de " + this.getPoblacionContagiadaVulnerable() + " de casos vulnerables en el pais");
                System.out.println(this.getNombre() + " registra " + nuevaPoblacionContagiadaNo + " casos nuevos de personas NO vulnerables, para un total de " + this.getPoblacionContagiadaNovulnerable() + " de casos NO vulnerables en el pais");
                System.out.println(this.getNombre() + " registra un total de " + (nuevaPoblacionContagiadaVulnerable + nuevaPoblacionContagiadaNo) + " nuevos casos en el país");
                System.out.println(this.getNombre() + " registra un total de " + this.getPoblacionContagiada() + " casos en el pais");
                System.out.println(this.getNombre() + " registra " + fallecidosVulnerable + " nuevos muertos vulnerables en el pais");
                System.out.println(this.getNombre() + " registra " + fallecidosNoVulnerable + " nuevos muertos NO vulnerables en el pais");
                System.out.println(this.getNombre() + " registra un total de " + (fallecidosVulnerable + fallecidosNoVulnerable) + " nuevos fallecidos en el país");
                System.out.println(this.getNombre() + " rgistra un total de " + this.getFallecidosPorVirus() + " fallecidos en el pais");
                System.out.println("----------------------------------------------------------------");
                if (this.getPorcentajeContagiados() >= 10) 
                {
                    for (String s : this.getConexionesTerrestres()) 
                    {
                        for (Pais d : this.conectados) 
                        {
                            if (d.getNombre().equals(s))
                            {
                                if (d.getIp().equals(this.getIp())) 
                                {
                                    if (comu.getCanal().containsKey(s)) 
                                    {

                                        comu.setValor(s, 1);
                                    }

                                }
                                
                                    
                                    this.Habla(d.getIp(),d.getIdentificador(),"1" );
                                
                            }
                        }

                    }
                    for (String s : this.getConexionesAereas()) 
                    {
                        for (Pais d : this.conectados) 
                        {
                            if (d.getNombre().equals(s))
                            {System.out.println("POR EL AMOR A GSUS");
                                if (d.getIp().equals(this.getIp())) 
                                {
                                    if (comu.getCanal().containsKey(s)) 
                                    {

                                        comu.setValor(s, 1);
                                    }

                                }
                                
                                    
                                    this.Habla(d.getIp(),d.getIdentificador(),"1" );
                                
                            }
                        }

                    }

                }

            } else {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pais.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("Nombre del hilo:" + this.getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pais.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    while(true)
    {
     for(Pais x: this.conectados)
            {
            this.Habla(x.getIp(), x.getIdentificador(),"0");
            }
    }
        //ejecutar algoritmo de virus por pais
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public void porcentajeAcantidad() {
        int aislados;
        float contagiados;
        int vulnerable;

        aislados = (int) (this.getPorcentajeAislamiento() * this.getPoblacion() / 100);
        contagiados = this.getPoblacionContagiada() * 100 / this.getPoblacion();
        vulnerable = (int) (this.getPorcentajePoblacionVulnerable() * this.getPoblacion() / 100);
        this.setPoblacionAislamiento(aislados);
        this.setPorcentajeContagiados(contagiados);
        this.setPoblacionVulnerable(vulnerable);
        this.setPoblacionNovulnerable(this.getPoblacion() - this.getPoblacionVulnerable());

    }

    public float porcentaje(int dato, int total) {
        float porcent = 0;
        porcent = dato * 100 / total;
        return porcent;
    }
  public String escucha(int valor)
    {
         final int puerto = 7000 + valor;
         ServerSocket serv = null;
         Socket nuev = null;
         String mensaje = "";
         try {
             serv = new ServerSocket(puerto);
             while(mensaje.contains(""))
             {
                nuev = serv.accept();

                DataInputStream entrada;
                DataOutputStream salida;
                entrada = new DataInputStream(nuev.getInputStream());
                salida = new DataOutputStream(nuev.getOutputStream());
                try {
                    mensaje = entrada.readUTF();
                    System.out.println("Mensaje: " + mensaje);
                    salida.writeUTF("Esponjitas en bikini");
                }catch(EOFException e) {
                    System.out.println("EOF:" + e.getMessage());
                }catch(IOException e){
                    System.out.println("readline:" + e.getMessage());
                }finally{
                    try{
                        nuev.close();
                        System.out.println("Conexion cerrada");
                    }catch(IOException e){
                        System.out.println("close" + e.getMessage());
                    }
                }
                }
             }catch(IOException e){
                 System.out.println("Listen Socket:" + e.getMessage());
             }
         return mensaje;
      }
    public void Habla(String enlace, int puert,String mensaje)
    {
        String respuesta;
        final String ip = enlace;
        final int puerto = 7000+puert;
        System.out.println(puerto+":"+enlace+"PUERTO CON EL ENLACE!!!!!");
          DataInputStream entrada;
          DataOutputStream salida;

        try {
            Socket sock = new Socket(ip,puerto);
           // entrada = new  DataInputStream(sock.getInputStream());
            salida = new DataOutputStream(sock.getOutputStream());
           salida.writeUTF("1");
          //respuesta = entrada.readUTF();
            sock.close();
        } catch (IOException ex) {
          //System.out.println("Conexion: "+ ex.getMessage());
           
        }
        
        
    }
}
