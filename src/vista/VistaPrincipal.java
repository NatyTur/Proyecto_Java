/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;


import controlador.Controlador;
import javax.swing.JFrame;




public class VistaPrincipal extends javax.swing.JFrame {

    //instancio el objeto controlador para unir controlador y vista
    private Controlador miControlador;
     
 
 
 public VistaPrincipal(){
     initComponents();
         
  }
 
   
 
 //operaciones de inicialización
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GestionarClientes = new javax.swing.JButton();
        CargarPedidos = new javax.swing.JButton();
        ListaProductos = new javax.swing.JButton();
        VerInformes = new javax.swing.JButton();
        MenuPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Pedidos");
        setMinimumSize(new java.awt.Dimension(314, 172));
        setName("MenuPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(314, 172));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GestionarClientes.setText("Clientes");
        GestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(GestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 40));

        CargarPedidos.setText("Pedidos");
        CargarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(CargarPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 130, 40));

        ListaProductos.setText("Productos ");
        ListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaProductosActionPerformed(evt);
            }
        });
        getContentPane().add(ListaProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 40));

        VerInformes.setText("Informes");
        VerInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInformesActionPerformed(evt);
            }
        });
        getContentPane().add(VerInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 130, 40));

        MenuPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MenuPrincipal.setText("Menu principal");
        getContentPane().add(MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 130, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarClientesActionPerformed
        miControlador.abrirPantallaGestionClientes();
    }//GEN-LAST:event_GestionarClientesActionPerformed

    private void ListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaProductosActionPerformed
        miControlador.abrirPantallaGestionProductos();
    }//GEN-LAST:event_ListaProductosActionPerformed

    private void VerInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VerInformesActionPerformed

    private void CargarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarPedidosActionPerformed
        miControlador.abrirPantallaGestionPedidos();
    }//GEN-LAST:event_CargarPedidosActionPerformed
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
        
       
    }
    
     public void setmiControlador(Controlador miControlador) {
      this.miControlador = miControlador;
    }
    
    
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CargarPedidos;
    public javax.swing.JButton GestionarClientes;
    public javax.swing.JButton ListaProductos;
    public javax.swing.JLabel MenuPrincipal;
    public javax.swing.JButton VerInformes;
    // End of variables declaration//GEN-END:variables

    public void setControlador(Controlador miControlador) {
        this.miControlador=miControlador;
    }
}


