/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Controlador;
import javax.swing.JOptionPane;


public class VistaNuevoCliente extends javax.swing.JFrame {

    private Controlador miControlador;

    /**
     * Creates new form VistaNuevoCliente
     */
    public VistaNuevoCliente() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Empresa = new javax.swing.JLabel();
        EmpresaEntry = new javax.swing.JTextField();
        Direccion = new javax.swing.JLabel();
        DireccionEntry = new javax.swing.JTextField();
        Provincia = new javax.swing.JLabel();
        ProvinciaEntry = new javax.swing.JTextField();
        Telefono = new javax.swing.JLabel();
        TelefonoEntry = new javax.swing.JTextField();
        Responsable = new javax.swing.JLabel();
        ResponsableEntry = new javax.swing.JTextField();
        GuardarCliente = new javax.swing.JButton();
        Nota = new javax.swing.JLabel();

        jLabel1.setText("Borrar Label");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Cliente");
        setName("NuevoCliente"); // NOI18N
        setResizable(false);

        Empresa.setText("Empresa");

        EmpresaEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EmpresaEntryKeyTyped(evt);
            }
        });

        Direccion.setText("Dirección");

        DireccionEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DireccionEntryKeyTyped(evt);
            }
        });

        Provincia.setText("Provincia");

        ProvinciaEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ProvinciaEntryKeyTyped(evt);
            }
        });

        Telefono.setText("Teléfono");

        TelefonoEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelefonoEntryKeyTyped(evt);
            }
        });

        Responsable.setText("Responsable");

        ResponsableEntry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ResponsableEntryKeyTyped(evt);
            }
        });

        GuardarCliente.setText("Guardar");
        GuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarClienteActionPerformed(evt);
            }
        });

        Nota.setText("Todos los campos son obligatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ResponsableEntry, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(EmpresaEntry, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Direccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Empresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Provincia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Telefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Responsable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProvinciaEntry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(TelefonoEntry, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DireccionEntry, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Nota, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(GuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Empresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpresaEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Direccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DireccionEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Provincia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProvinciaEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Telefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TelefonoEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Responsable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResponsableEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(GuardarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nota)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    /*VALIDACIONES Y LIMPIEZA DE DATOS*/
    private void EmpresaEntryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmpresaEntryKeyTyped
        // Evento que se dispara cuando se ingresa un caracter en el cuadro de texto
        if(EmpresaEntry.getText().length() >= 30)
        {
            evt.consume(); //evt.consume() eso quiere decir que el evento se consumirá e impide en este caso, el ingreso de mas caracteres.
            System.out.println("Ha llegado al maximo de caracteres en el campo");
        }
    }//GEN-LAST:event_EmpresaEntryKeyTyped

    private void DireccionEntryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DireccionEntryKeyTyped
        // Evento que se dispara cuando se ingresa un caracter en el cuadro de texto
        if(DireccionEntry.getText().length() >= 30)
        {
            evt.consume(); //evt.consume() eso quiere decir que el evento se consumirá e impide en este caso, el ingreso de mas caracteres.
            System.out.println("Ha llegado al maximo de caracteres en el campo");
        }
    }//GEN-LAST:event_DireccionEntryKeyTyped

    private void GuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarClienteActionPerformed
        // Se presiona el botón de guardar cliente. Se debe validar que los campos estén completos
        if(!EmpresaEntry.getText().isEmpty() && !DireccionEntry.getText().isEmpty() && !ProvinciaEntry.getText().isEmpty() && !TelefonoEntry.getText().isEmpty() && !ResponsableEntry.getText().isEmpty())
        {
            //llamo al metodo del controlador encargado de guardar un nuevo cliente
            miControlador.guardarNuevoCliente(EmpresaEntry.getText(), DireccionEntry.getText(), ProvinciaEntry.getText(), TelefonoEntry.getText(), ResponsableEntry.getText());
            
            JOptionPane.showMessageDialog(null, "Se creó el cliente correctamente");
            //Limpia los campos de texto en la vista para poder cargar un nuevo cliente.
            EmpresaEntry.setText(null);   
            DireccionEntry.setText(null);
            ProvinciaEntry.setText(null);
            TelefonoEntry.setText(null);
            ResponsableEntry.setText(null);//limpia los cudros de texto usados
            dispose(); //Dispone el frame
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Algún campo se encuentra vacío");
        }
        
    }//GEN-LAST:event_GuardarClienteActionPerformed

    private void ProvinciaEntryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProvinciaEntryKeyTyped
        // Evento que se dispara cuando se ingresa un caracter en el cuadro de texto
        if(ProvinciaEntry.getText().length() >= 20)
        {
            evt.consume(); //evt.consume() eso quiere decir que el evento se consumirá e impide en este caso, el ingreso de mas caracteres.
            System.out.println("Ha llegado al maximo de caracteres en el campo");
        }
    }//GEN-LAST:event_ProvinciaEntryKeyTyped

    private void TelefonoEntryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoEntryKeyTyped
        /// Evento que se dispara cuando se ingresa un caracter en el cuadro de texto
        char CaracterAValidar = evt.getKeyChar();
        if((TelefonoEntry.getText().length() >= 12) || (Character.isLetter(CaracterAValidar))) //Limita a un máximo de 12 caracteres solo numéricos
        {
            evt.consume(); //evt.consume() eso quiere decir que el evento se consumirá e impide en este caso, el ingreso de mas caracteres.
            System.out.println("Ha llegado al maximo de caracteres en el campo o no es un caracter numerico");
        }
    }//GEN-LAST:event_TelefonoEntryKeyTyped

    private void ResponsableEntryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ResponsableEntryKeyTyped
        // Evento que se dispara cuando se ingresa un caracter en el cuadro de texto
        if(ResponsableEntry.getText().length() >= 30)
        {
            evt.consume(); //evt.consume() eso quiere decir que el evento se consumirá e impide en este caso, el ingreso de mas caracteres.
            System.out.println("Ha llegado al maximo de caracteres en el campo");
        }
    }//GEN-LAST:event_ResponsableEntryKeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VistaNuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaNuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaNuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaNuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaNuevoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Direccion;
    private javax.swing.JTextField DireccionEntry;
    private javax.swing.JLabel Empresa;
    private javax.swing.JTextField EmpresaEntry;
    private javax.swing.JButton GuardarCliente;
    private javax.swing.JLabel Nota;
    private javax.swing.JLabel Provincia;
    private javax.swing.JTextField ProvinciaEntry;
    private javax.swing.JLabel Responsable;
    private javax.swing.JTextField ResponsableEntry;
    private javax.swing.JLabel Telefono;
    private javax.swing.JTextField TelefonoEntry;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void setControlador(Controlador miControlador) {
        this.miControlador=miControlador;
    }
}
