/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.ConexionCliente;
import Conexion.ConexionServidor;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Leonel
 */
public class VistaBroker extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form VistaBroker
     */
    public VistaBroker() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaBroker().setVisible(true);
            }
        });
        
        initComponents();
        this.getRootPane().setDefaultButton(this.Actualizar);
        ConexionServidor server = new  ConexionServidor(5000); 
        server.addObserver(this);
        Thread  nuevo = new Thread(server);
        nuevo.start();
    }
    public void actCliente(String ip,String mensaje, int puerto)
    {
        cliente = new ConexionCliente(ip, puerto, mensaje);
        this.jTextArea1.append(mensaje);
        
            Thread nuevo = new Thread(cliente);
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setBackground(new java.awt.Color(255, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleName("areaTexto");

        Actualizar.setLabel("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel1.setText("    Noticias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Actualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Actualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Actualizar.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed


        
    }//GEN-LAST:event_ActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
private ConexionCliente cliente;
    public void update(Observable o, Object arg) 
    {
        this.jTextArea1.append((String) arg);
    } 
}
