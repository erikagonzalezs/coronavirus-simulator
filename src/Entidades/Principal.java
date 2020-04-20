/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Leonel
 */
public class Principal {

    public Principal() 
    {
    }
    private ArrayList<Pais> paises;
    private int cantidadPaises;
    private String ip;

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
    private float tasaMortalidadNoulnerable;

    /*
    --------------------------------------------------
    Setters
    --------------------------------------------------
     */
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

    public void setTasaMortalidadNoulnerable(float tasaMortalidadNoulnerable) {
        this.tasaMortalidadNoulnerable = tasaMortalidadNoulnerable;
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

    public float getTasaMortalidadNoulnerable() {
        return tasaMortalidadNoulnerable;
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
        int poblacion;
        float tasaPropagacionV;
        float tasaPropagacionNV;
        float tasaMortalidadV;
        float tasaMortalidadNV;

        Pais auxiliar = new Pais();
        String linea = null;
        ArrayList<String> conexionAux = new ArrayList<>();
        ArrayList<Integer> habitantes = new ArrayList<>();
        ArrayList<Integer> porcentajeContagiados = new ArrayList<>();
        ArrayList<Integer> porcentajePoblacionVulnerable = new ArrayList<>();
        ArrayList<Integer> porcentajeAislamiento = new ArrayList<>();
        //poblacion de paises
        poblacion = Integer.parseInt(br.readLine());
        this.setCantidadPaises(poblacion);
        System.out.println("Poblacion: " + poblacion);

        tasaPropagacionV = Float.parseFloat(br.readLine());
        System.out.println("Propagacion vulnerable " + tasaPropagacionV);
        this.setTasaPropagacionVulnerable(tasaPropagacionV);
   
        
        tasaPropagacionNV = Float.parseFloat(br.readLine());
        System.out.println("Propagacion no vulnerable " + tasaPropagacionNV);
        this.setTasaPropagacionVulnerable(tasaPropagacionNV);
        
        tasaMortalidadV = Float.parseFloat(br.readLine());
        System.out.println("Mortalidad vulnerable " + tasaMortalidadV);
        this.setTasaMortalidadVulnerable(tasaMortalidadV);
        
        tasaMortalidadNV = Float.parseFloat(br.readLine());
        System.out.println("Mortalidad no vulnerable " + tasaMortalidadNV);
        this.setTasaMortalidadNoulnerable(tasaMortalidadNV);
        
        linea = br.readLine();
        while (!linea.equals("aereas")) {
            if (linea.equals("ipconfig"))
            {
                linea = br.readLine();
                auxiliar.setIp(linea);
                linea = br.readLine();
            }
            auxiliar.setNombre(linea);
            //paises.add(linea);
            linea = br.readLine();
            auxiliar.setPoblacion(Integer.parseInt(linea));
            linea = br.readLine();
            auxiliar.setPorcentajeContagiados(Float.parseFloat(linea));
            linea = br.readLine();
           
            auxiliar.setPorcentajePoblacionVulnerable(Float.parseFloat(linea));
            linea = br.readLine();
            auxiliar.setPorcentajeAislamiento(Float.parseFloat(linea));
            linea = br.readLine();
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
                    System.out.println(p.getNombre());
                    if(partes[0].equals(p.getNombre()))
                    {
                        conexionAux.add(partes[1]);
                    }
                    else
                    {
                        conexionAux.add(partes[0]);
                    }
                    

                }
            }
            p.setConexionesAereas(conexionAux);
            conexionAux.clear();
        }

        for (Pais p : this.paises) 
        {
            for (int i = 0; i < conexionesTerrestres.size(); i++) {

                if (conexionesTerrestres.get(i).contains(p.getNombre())) {
                    String split;
                    String[] partes;
                    String part;
                    partes = conexionesTerrestres.get(i).split("-");
                  if(partes[0].equals(p.getNombre()))
                    {
                        conexionAux.add(partes[1]);
                    }
                    else
                    {
                        conexionAux.add(partes[0]);
                    }

                }
            }
            p.setConexionesTerrestres(conexionAux);
            conexionAux.clear();
        }

    }
    public void emulacion()
    {
        for(Pais p: this.getPaises())
        {
            if(p.getIp().equals(this.getIp()))
            {
              Thread paisH = new Pais(p.getNombre());  
              
              paisH.start();
            }
        }
        
    }

}
