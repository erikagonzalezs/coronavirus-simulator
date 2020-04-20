/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Conexion.ConexionCliente;
import Vista.VistaBroker;
import java.net.*;
import java.util.Enumeration;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonel
 */
public class Broker {

    public Broker() {
    }
    private ArrayList<Pais> paises;
    private ArrayList<String> ips;
    private int cantidadPaises;
    private String ip;

    public ArrayList<String> getIps() {
        return ips;
    }

    public void setIps(ArrayList<String> ips) {
        this.ips = ips;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCantidadPaises() {
        return cantidadPaises;
    }

    public void setCantidadPaises(int cantidadPaises) {
        this.cantidadPaises = cantidadPaises;
    }
    private float tasaPropagacionNovulnerable;
    private float tasaPropagacionVulnerable;
    private float tasaMortalidadVulnerable;
    private float tasaMortalidadNovulnerable;

    /*
    --------------------------------------------------
    Setters
    --------------------------------------------------
     */
    public static void main(String[] args) {
       VistaBroker visible;
        Broker principal = new Broker();
        principal.cargarIpLocal();
        ArrayList <Pais> extraP =new ArrayList<>() ;
        ArrayList <Pais> extraPasados =new ArrayList<>() ;
        int contador1 = 0;
        int contador2 = 0;
        int totalPaises = 0;
        int paisesPorHost = 0;
        int modulo;
        int mayor = 0;
        int extra = 0;
        int extraAux = 0;
        int necesarios = 0;
         int contador = 0;
        try {
            principal.LecturaConfig(principal.getIp());
            int arreglos[] = new int[principal.getIps().size()];
            totalPaises = principal.getCantidadPaises();
            //se cuenta la cantidad de paises por host
            for (int b = 0; b < principal.getIps().size(); b++) {
                contador1 = 0;
                for (Pais x : principal.getPaises()) {
                    if (principal.getIps().get(b).equals(x.getIp())) {
                        contador1++;
                    }

                }
                arreglos[b] = contador1;

            }
            int[] menores = new int[arreglos.length];
            menores = arreglos;
            //se obtiene la cantidad de paises del local host
            for (int b = 0; b < principal.getIps().size(); b++) {
                if (principal.getIp().equals(principal.getIps().get(b))) {
                    contador2 = arreglos[b];

                }
            }
            modulo = totalPaises % principal.getIps().size();
            if (modulo == 0) 
            {
                paisesPorHost = totalPaises / principal.getIps().size();

                for (int b = 0; b < principal.getIps().size(); b++) {
                    extraAux = 0;
                    if (arreglos[b] - paisesPorHost > 0) 
                    {
                        extra = arreglos[b] - paisesPorHost + extra;
                        extraAux = arreglos[b] - paisesPorHost;
                        arreglos[b] = arreglos[b] - extraAux;

                    } else if (arreglos[b] - paisesPorHost == 0) 
                    {
                        extraAux = arreglos[b] - paisesPorHost;
                        arreglos[b] = arreglos[b] - extraAux;
                    }
                }
                for (int b = 0; b < principal.getIps().size(); b++) {
                    necesarios = 0;
                    if (arreglos[b] - paisesPorHost < 0) {

                        necesarios = paisesPorHost - arreglos[b];
                        arreglos[b] = necesarios + arreglos[b];
                        extra = extra - necesarios;

                    }
                }
                
             for(int b = 0 ;b<principal.getIps().size();b++)
            {
                contador=0;
                   for(Pais d: principal.getPaises())
                   {
                       if(d.getIp().equals(principal.getIps().get(b)))
                       {
                           if(contador<=paisesPorHost)
                            {
                            contador++;
                            }
                           else
                           {
                               extraP.add(d);
                           }
                       }
                        
                   }
                   
            }
             for(int b = 0 ;b<principal.getIps().size();b++)
                   {
                       if(menores[b] < paisesPorHost)
                       {
                           for(int d = 0; d < paisesPorHost-menores[b];d++ )
                           {
                               extraP.get(d).setIp(principal.getIp());
                               extraPasados.add(extraP.get(d));
                               extraP.remove(d);
                           }
                       }
                   }
             for(Pais p:extraPasados)
             {
                 for(Pais d:principal.getPaises())
                 {
                       if(p.getNombre().equals(d.getNombre()))
                       {
                           if(!p.getIp().equals(d.getIp()))
                           {
                               d.setIp(p.getIp());
                           }
                       }
                 }
             }

            } else {
                paisesPorHost = totalPaises - modulo / principal.getIps().size();
                for (int b = 0; b < principal.getIps().size(); b++) {
                    extraAux = 0;
                    if (arreglos[b] - paisesPorHost > 0) {
                        extra = arreglos[b] - paisesPorHost + extra;
                        extraAux = arreglos[b] - paisesPorHost;
                        arreglos[b] = arreglos[b] - extraAux + modulo;
                        modulo = 0;
                    } else if (arreglos[b] - paisesPorHost == 0) {
                        extraAux = arreglos[b] - paisesPorHost;
                        arreglos[b] = arreglos[b] - extraAux;
                    }
                }
                for (int b = 0; b < principal.getIps().size(); b++) 
                {
                    necesarios = 0;
                    if (arreglos[b] - paisesPorHost < 0)
                    {
                        necesarios = paisesPorHost - arreglos[b];
                        arreglos[b] = necesarios + arreglos[b];
                        extra = extra - necesarios;

                    }

                }
                
                for(int b = 0 ;b<principal.getIps().size();b++)
            {
                contador=0;
                   for(Pais d: principal.getPaises())
                   {
                       if(d.getIp().equals(principal.getIps().get(b)))
                       {
                           if(contador<=paisesPorHost+modulo)
                            {
                            contador++;
                            }
                           else
                           {
                               modulo=0;
                               extraP.add(d);
                           }
                       }
                        
                   }
                   
            }
             for(int b = 0 ;b<principal.getIps().size();b++)
                   {
                       if(menores[b] < paisesPorHost)
                       {
                           for(int d = 0; d < paisesPorHost-menores[b];d++ )
                           {
                               extraP.get(d).setIp(principal.getIp());
                               extraPasados.add(extraP.get(d));
                               extraP.remove(d);
                           }
                       }
                   }
             for(Pais p:extraPasados)
             {
                 for(Pais d:principal.getPaises())
                 {
                       if(p.getNombre().equals(d.getNombre()))
                       {
                           if(!p.getIp().equals(d.getIp()))
                           {
                               d.setIp(p.getIp());
                           }
                       }
                 }
             }  
                
                    
            }
            visible = new VistaBroker();
            principal.emulacion();
            int ips =0;
             final int puerto = 5000;
             
             while(true)
             {      
                if(!principal.getIps().get(ips).equals(principal.getIp()))
                {
                 visible.actCliente(principal.getIps().get(ips),"prueba",puerto);
                }
                
             }
            
        } catch (IOException ex) 
        {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarIpLocal() {
        Enumeration e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        String hamachi = "";
        while (e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                if (i.toString().contains("25")) {
                    hamachi = i.toString();
                }
            }

        }
        String part[] = hamachi.split("/");
        String direccion = part[1];
        this.setIp(direccion);
    }

    public void setPaises(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public void setTasaPropagacionNovulnerable(float tasaPropagacionNovulnerable) {
        this.tasaPropagacionNovulnerable = tasaPropagacionNovulnerable;
    }

    public void setTasaPropagacionVulnerable(float tasaPropagacionVulnerable) {
        this.tasaPropagacionVulnerable = tasaPropagacionVulnerable;
    }

    public void setTasaMortalidadVulnerable(float tasaMortalidadVulnerable) {
        this.tasaMortalidadVulnerable = tasaMortalidadVulnerable;
    }

    public void setTasaMortalidadNovulnerable(float tasaMortalidadNovulnerable) {
        this.tasaMortalidadNovulnerable = tasaMortalidadNovulnerable;
    }

    /*
    --------------------------------------------------
    Getters
    --------------------------------------------------
     */
    public ArrayList<Pais> getPaises() {
        return paises;
    }

    public float getTasaPropagacionNovulnerable() {
        return tasaPropagacionNovulnerable;
    }

    public float getTasaPropagacionVulnerable() {
        return tasaPropagacionVulnerable;
    }

    public float getTasaMortalidadVulnerable() {
        return tasaMortalidadVulnerable;
    }

    public float getTasaMortalidadNovulnerable() {
        return tasaMortalidadNovulnerable;
    }

    /*
    --------------------------------------------------
    Otros metodos
    --------------------------------------------------
     */
    public void LecturaConfig(String ip) throws FileNotFoundException, IOException {

        File archivo = new File("texto/configuracion.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Pais> auxpais = new ArrayList<>();
        ArrayList<String> conexionesAereas = new ArrayList<String>();
        ArrayList<String> conexionesTerrestres = new ArrayList<String>();
        ArrayList<String> paises = new ArrayList<String>();
        int conexionAerea = 0;
        int conexionTerrestre = 0;
        int cantPaises;
        float tasaPropagacionV;
        float tasaPropagacionNV;
        float tasaMortalidadV;
        float tasaMortalidadNV;
        String ipExtra = null;
        int contable = 0;
        String linea = null;
        String conexionAux = null;
        ArrayList<Integer> habitantes = new ArrayList<>();
        ArrayList<Integer> porcentajeContagiados = new ArrayList<>();
        ArrayList<Integer> porcentajePoblacionVulnerable = new ArrayList<>();
        ArrayList<Integer> porcentajeAislamiento = new ArrayList<>();
        //poblacion de paises
        cantPaises = Integer.parseInt(br.readLine());
        this.setCantidadPaises(cantPaises);
        System.out.println("Poblacion: " + cantPaises);

        tasaPropagacionV = Float.parseFloat(br.readLine());
        System.out.println("Propagacion vulnerable " + tasaPropagacionV);
        this.setTasaPropagacionVulnerable(tasaPropagacionV);

        tasaPropagacionNV = Float.parseFloat(br.readLine());
        System.out.println("Propagacion no vulnerable " + tasaPropagacionNV);
        this.setTasaPropagacionNovulnerable(tasaPropagacionNV);

        tasaMortalidadV = Float.parseFloat(br.readLine());
        System.out.println("Mortalidad vulnerable " + tasaMortalidadV);
        this.setTasaMortalidadVulnerable(tasaMortalidadV);

        tasaMortalidadNV = Float.parseFloat(br.readLine());
        System.out.println("Mortalidad no vulnerable " + tasaMortalidadNV);
        this.setTasaMortalidadNovulnerable(tasaMortalidadNV);

        linea = br.readLine();
        while (!linea.equals("aereas")) {
            Pais auxiliar = new Pais();
            if (linea.equals("ipconfig")) {
                linea = br.readLine();
                this.getIps().add(linea);
                ipExtra = linea;
                linea = br.readLine();
            }
            auxiliar.setIp(ipExtra);
            auxiliar.setNombre(linea);
            //paises.add(linea);
            linea = br.readLine();
            auxiliar.setPoblacion(Integer.parseInt(linea));
            linea = br.readLine();
            auxiliar.setPoblacionContagiada(Integer.parseInt(linea));
            linea = br.readLine();

            auxiliar.setPorcentajePoblacionVulnerable(Float.parseFloat(linea));
            linea = br.readLine();
            auxiliar.setPorcentajeAislamiento(Float.parseFloat(linea));
            linea = br.readLine();
            auxiliar.setTasaMortalidadVulnerable(this.getTasaMortalidadVulnerable());
            auxiliar.setTasaMortalidadNovulnerable(this.getTasaMortalidadNovulnerable());
            auxiliar.setTasaPropagacionNovulnerable(this.getTasaPropagacionNovulnerable());
            auxiliar.setTasaPropagacionVulnerable(this.getTasaPropagacionVulnerable());
            auxpais.add(auxiliar);
        }

        this.setPaises(auxpais);
        linea = br.readLine();
        while (!linea.equals("terrestres")) {
            conexionesAereas.add(linea);
            linea = br.readLine();
        }

        linea = br.readLine();
        while (linea != null) {
            conexionesTerrestres.add(linea);
            linea = br.readLine();
        }

        for (Pais p : this.paises) {
            for (int i = 0; i < conexionesAereas.size(); i++) {

                if (conexionesAereas.get(i).contains(p.getNombre())) {
                    String split;
                    String[] partes;
                    String part;
                    partes = conexionesAereas.get(i).split("-");

                    if (partes[0].equals(p.getNombre())) {
                        conexionAux = partes[1];
                    } else {
                        conexionAux = partes[0];
                    }
                    p.getConexionesAereas().add(conexionAux);

                }
                conexionAux = null;
            }

        }

        for (Pais p : this.getPaises()) {
            p.setIdentificador(contable);
            for (int i = 0; i < conexionesTerrestres.size(); i++) {

                if (conexionesTerrestres.get(i).contains(p.getNombre())) {
                    String split;
                    String[] partes;
                    String part;
                    partes = conexionesTerrestres.get(i).split("-");
                    if (partes[0].equals(p.getNombre())) {
                        conexionAux = partes[1];
                    } else {
                        conexionAux = partes[0];
                    }
                    p.getConexionesTerrestres().add(conexionAux);
                    System.out.println("ENTREEE EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + p.getConexionesTerrestres());
                }
                conexionAux = null;
            }

            contable++;

        }

    }

    public void emulacion() {
        System.out.println("Entre a emular");

        Map<String, Integer> auxiliar = new HashMap<>();

        for (Pais p : this.getPaises()) {
            auxiliar.put(p.getNombre(), 0);

        }

        Comunicacion comunica = new Comunicacion(auxiliar);

        for (Pais p : this.getPaises()) {

            p.setConectados(this.getPaises());
            if (p.getIp().equals(this.getIp())) {

                p.setTasaPropagacionNovulnerable(this.getTasaPropagacionNovulnerable());
                p.setTasaPropagacionVulnerable(this.getTasaPropagacionVulnerable());

                System.out.println("ENTREEE EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEdeasdasdawdEE");
                Thread paisH = new Pais(p.getNombre(), p, comunica);

                paisH.start();
            } else {

            }
        }

    }

}
