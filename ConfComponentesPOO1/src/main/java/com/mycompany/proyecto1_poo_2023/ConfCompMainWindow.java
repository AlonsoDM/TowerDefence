
package com.mycompany.proyecto1_poo_2023;

import javax.swing.JOptionPane;


public class ConfCompMainWindow extends javax.swing.JFrame {
    
    public ConfCompMainWindow() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JlUsuario = new javax.swing.JLabel();
        JlTitulo = new javax.swing.JLabel();
        JlContrasena = new javax.swing.JLabel();
        JTFPassword = new javax.swing.JTextField();
        JTFUsuario = new javax.swing.JTextField();
        JLInsertar = new javax.swing.JButton();
        JlBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(697, 439));
        getContentPane().setLayout(null);

        JlUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        JlUsuario.setText("Usuario :");
        getContentPane().add(JlUsuario);
        JlUsuario.setBounds(120, 210, 210, 60);

        JlTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        JlTitulo.setForeground(new java.awt.Color(0, 0, 0));
        JlTitulo.setText("Administracion del juego");
        getContentPane().add(JlTitulo);
        JlTitulo.setBounds(240, 30, 260, 60);

        JlContrasena.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        JlContrasena.setText("Contrasena:");
        getContentPane().add(JlContrasena);
        JlContrasena.setBounds(450, 210, 150, 60);

        JTFPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(JTFPassword);
        JTFPassword.setBounds(450, 280, 140, 30);

        JTFUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(JTFUsuario);
        JTFUsuario.setBounds(120, 280, 140, 24);

        JLInsertar.setText("Insertar");
        JLInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(JLInsertar);
        JLInsertar.setBounds(290, 330, 140, 40);

        JlBackground.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alonso D\\OneDrive\\Documents\\NetBeansProjects\\ConfComponentesPOO1\\ConfComponentesPOO1\\src\\main\\java\\Images\\1980881 (1).jpg")); // NOI18N
        JlBackground.setText("jLabel1");
        JlBackground.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        getContentPane().add(JlBackground);
        JlBackground.setBounds(0, 0, 700, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFPasswordActionPerformed
       
    }//GEN-LAST:event_JTFPasswordActionPerformed

    private void JTFUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFUsuarioActionPerformed
  
    }//GEN-LAST:event_JTFUsuarioActionPerformed

    private void JLInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLInsertarActionPerformed
    String usuario = JTFUsuario.getText().trim().toLowerCase();
    String contrasena = JTFPassword.getText().trim().toLowerCase();

    if (!usuario.isEmpty() && !contrasena.isEmpty()) {
        if ("admin".equals(usuario) && "admin".equals(contrasena)) {
            SelectionWindow selection = new SelectionWindow();
            selection.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Los Credenciales son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Los Credenciales no son válidos", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_JLInsertarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JLInsertar;
    private javax.swing.JTextField JTFPassword;
    private javax.swing.JTextField JTFUsuario;
    private javax.swing.JLabel JlBackground;
    private javax.swing.JLabel JlContrasena;
    private javax.swing.JLabel JlTitulo;
    private javax.swing.JLabel JlUsuario;
    // End of variables declaration//GEN-END:variables
}
