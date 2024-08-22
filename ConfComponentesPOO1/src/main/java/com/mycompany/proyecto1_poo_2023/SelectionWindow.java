
package com.mycompany.proyecto1_poo_2023;

import java.awt.Window;
import javax.swing.JFrame;


public class SelectionWindow extends javax.swing.JFrame {


    public SelectionWindow() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JlMain = new javax.swing.JLabel();
        CreateDefensesSelection = new javax.swing.JButton();
        SelectionCrearZombies = new javax.swing.JButton();
        JBTNExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 440));
        getContentPane().setLayout(null);

        JlMain.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        JlMain.setForeground(new java.awt.Color(204, 204, 204));
        JlMain.setText("Selecciona que deseas crear");
        JlMain.setToolTipText("");
        getContentPane().add(JlMain);
        JlMain.setBounds(200, 10, 300, 110);

        CreateDefensesSelection.setText("Crear Defensas");
        CreateDefensesSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateDefensesSelectionActionPerformed(evt);
            }
        });
        getContentPane().add(CreateDefensesSelection);
        CreateDefensesSelection.setBounds(90, 210, 230, 60);

        SelectionCrearZombies.setText("Crear Zombies");
        SelectionCrearZombies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionCrearZombiesActionPerformed(evt);
            }
        });
        getContentPane().add(SelectionCrearZombies);
        SelectionCrearZombies.setBounds(400, 210, 230, 60);

        JBTNExit.setText("Salir de la Configuracion");
        JBTNExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNExitActionPerformed(evt);
            }
        });
        getContentPane().add(JBTNExit);
        JBTNExit.setBounds(220, 310, 230, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alonso D\\OneDrive\\Documents\\NetBeansProjects\\ConfComponentesPOO1\\ConfComponentesPOO1\\src\\main\\java\\Images\\KC22_HOME_BG_2023.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateDefensesSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateDefensesSelectionActionPerformed
        CreateDefenses CrearDefensas = new CreateDefenses();
        CrearDefensas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CreateDefensesSelectionActionPerformed

    private void SelectionCrearZombiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectionCrearZombiesActionPerformed
        CreateZombies CrearZombies = new CreateZombies();
        CrearZombies.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SelectionCrearZombiesActionPerformed

    private void JBTNExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNExitActionPerformed
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
        if (window instanceof JFrame) {
            ((JFrame) window).dispose();
        }
    System.out.println("Se salio del programa de configuracion exitosamente");
    }
    }//GEN-LAST:event_JBTNExitActionPerformed

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
            java.util.logging.Logger.getLogger(SelectionWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateDefensesSelection;
    private javax.swing.JButton JBTNExit;
    private javax.swing.JLabel JlMain;
    private javax.swing.JButton SelectionCrearZombies;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
