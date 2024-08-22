
package com.mycompany.proyecto1_poo_2023;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CreateZombies extends javax.swing.JFrame {


    public CreateZombies() {
    JLValidation = new javax.swing.JLabel();
    getContentPane().add(JLValidation);
    JLValidation.setBounds(365, 550, 400, 16);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLAppearanceLevel = new javax.swing.JLabel();
        JLSpace = new javax.swing.JLabel();
        JlTitle = new javax.swing.JLabel();
        JLZombieType = new javax.swing.JLabel();
        JlName = new javax.swing.JLabel();
        JlAppearance = new javax.swing.JLabel();
        JlInfo = new javax.swing.JLabel();
        JLActionRange = new javax.swing.JLabel();
        JLLifeUnit = new javax.swing.JLabel();
        JlInforequest = new javax.swing.JLabel();
        JlDPS = new javax.swing.JLabel();
        JTFLevelAppearance = new javax.swing.JTextField();
        JTFName = new javax.swing.JTextField();
        JTFLife = new javax.swing.JTextField();
        JTFDamage = new javax.swing.JTextField();
        JFTSpace = new javax.swing.JTextField();
        JTFDPS = new javax.swing.JTextField();
        CBoxZombieType = new javax.swing.JComboBox<>();
        ImageChooser = new javax.swing.JButton();
        JButCrearZombie = new javax.swing.JButton();
        JlBackgroundZom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(899, 610));
        getContentPane().setLayout(null);

        JLAppearanceLevel.setText("Nivel de aparicion:");
        getContentPane().add(JLAppearanceLevel);
        JLAppearanceLevel.setBounds(600, 450, 130, 16);

        JLSpace.setText("Campos");
        getContentPane().add(JLSpace);
        JLSpace.setBounds(600, 290, 100, 16);

        JlTitle.setText("Crear Zombies");
        getContentPane().add(JlTitle);
        JlTitle.setBounds(378, 45, 140, 16);

        JLZombieType.setText("Tipo de Zombie:");
        getContentPane().add(JLZombieType);
        JLZombieType.setBounds(120, 370, 110, 16);

        JlName.setText("Nombre:");
        getContentPane().add(JlName);
        JlName.setBounds(120, 170, 100, 16);

        JlAppearance.setText("Apariencia");
        getContentPane().add(JlAppearance);
        JlAppearance.setBounds(120, 280, 110, 16);

        JlInfo.setText("En esta ventana podra crear un elemento del juego de tipo Zombie");
        getContentPane().add(JlInfo);
        JlInfo.setBounds(250, 80, 400, 16);

        JLActionRange.setText("Golpes por ataque");
        getContentPane().add(JLActionRange);
        JLActionRange.setBounds(600, 370, 120, 16);

        JLLifeUnit.setText("Unidad de vida");
        getContentPane().add(JLLifeUnit);
        JLLifeUnit.setBounds(120, 450, 110, 16);

        JlInforequest.setText("Ingrese los datos solicitados para crear un Zombie");
        getContentPane().add(JlInforequest);
        JlInforequest.setBounds(290, 120, 290, 16);

        JlDPS.setText("Damage");
        getContentPane().add(JlDPS);
        JlDPS.setBounds(600, 210, 170, 16);

        JTFLevelAppearance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFLevelAppearanceActionPerformed(evt);
            }
        });
        getContentPane().add(JTFLevelAppearance);
        JTFLevelAppearance.setBounds(600, 480, 90, 24);

        JTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNameActionPerformed(evt);
            }
        });
        getContentPane().add(JTFName);
        JTFName.setBounds(120, 200, 90, 24);

        JTFLife.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFLifeActionPerformed(evt);
            }
        });
        getContentPane().add(JTFLife);
        JTFLife.setBounds(120, 480, 90, 24);

        JTFDamage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFDamageActionPerformed(evt);
            }
        });
        getContentPane().add(JTFDamage);
        JTFDamage.setBounds(600, 240, 90, 24);

        JFTSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFTSpaceActionPerformed(evt);
            }
        });
        getContentPane().add(JFTSpace);
        JFTSpace.setBounds(600, 320, 90, 24);

        JTFDPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFDPSActionPerformed(evt);
            }
        });
        getContentPane().add(JTFDPS);
        JTFDPS.setBounds(600, 400, 90, 24);

        CBoxZombieType.setBackground(new java.awt.Color(0, 102, 153));
        CBoxZombieType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "melee", "airtype", "mediumRange", "kamikaze" }));
        CBoxZombieType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBoxZombieTypeActionPerformed(evt);
            }
        });
        getContentPane().add(CBoxZombieType);
        CBoxZombieType.setBounds(120, 400, 150, 26);

        ImageChooser.setBackground(new java.awt.Color(0, 153, 153));
        ImageChooser.setForeground(new java.awt.Color(255, 255, 255));
        ImageChooser.setText("Choose a file!");
        ImageChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageChooserActionPerformed(evt);
            }
        });
        getContentPane().add(ImageChooser);
        ImageChooser.setBounds(120, 310, 160, 50);

        JButCrearZombie.setBackground(new java.awt.Color(102, 0, 0));
        JButCrearZombie.setText("Terminar Zombie");
        JButCrearZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButCrearZombieActionPerformed(evt);
            }
        });
        getContentPane().add(JButCrearZombie);
        JButCrearZombie.setBounds(360, 510, 140, 24);

        JlBackgroundZom.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alonso D\\OneDrive\\Documents\\NetBeansProjects\\ConfComponentesPOO1\\ConfComponentesPOO1\\src\\main\\java\\Images\\zombie-drugs-960x640.jpg")); // NOI18N
        JlBackgroundZom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        getContentPane().add(JlBackgroundZom);
        JlBackgroundZom.setBounds(0, 0, 900, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void JTFLevelAppearanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFLevelAppearanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFLevelAppearanceActionPerformed

    private void JTFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNameActionPerformed

    private void JTFLifeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFLifeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFLifeActionPerformed

    private void JTFDamageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFDamageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFDamageActionPerformed

    private void JFTSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFTSpaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JFTSpaceActionPerformed

    private void JTFDPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFDPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFDPSActionPerformed

    private void CBoxZombieTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBoxZombieTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBoxZombieTypeActionPerformed
    private String selectedImagePath;
    
    private void ImageChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageChooserActionPerformed
    SwingUtilities.invokeLater(() -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose a file");
            fileChooser.setPreferredSize(new Dimension(700, 700));

            int result = fileChooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                if (isValidImageFile(selectedFile)) {
                    System.out.println("Valid image file selected: " + selectedFile);
                    selectedImagePath = selectedFile.getAbsolutePath(); // Save the selected image path
                } else {
                    System.out.println("Invalid image file selected");
                    showValidationMessage("Please choose a valid image file (e.g., PNG, JPG).");
                }
            } else {
                System.out.println("No file selected");
            }
        });
    }//GEN-LAST:event_ImageChooserActionPerformed

    private void JButCrearZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButCrearZombieActionPerformed
            // Validate fields before proceeding
    if (!validateFields() || selectedImagePath == null) {
        if (selectedImagePath == null) {
            showValidationMessage("Please choose an image file.");
        }
        return;  // Stop execution if fields are not valid
    }

    String name = JTFName.getText();
    int levelAppearance = Integer.parseInt(JTFLevelAppearance.getText());
    int life = Integer.parseInt(JTFLife.getText());
    int damage = Integer.parseInt(JTFDamage.getText());
    int spaces = Integer.parseInt(JFTSpace.getText());
    int dps = Integer.parseInt(JTFDPS.getText());

    // Get the selected ZombieType directly from the JComboBox
    String zombieTypeString = CBoxZombieType.getSelectedItem().toString();

    // Map the String to the ZombieType enum
    Zombie.ZombieType zombieTypeEnum = Zombie.ZombieType.valueOf(zombieTypeString.toUpperCase());

    // Create a Zombie object
    Zombie zombie = new Zombie(zombieTypeEnum, name,0,0, 
                          levelAppearance, damage, spaces, dps, "", selectedImagePath);
    JFileChooser fileChooser = new JFileChooser();
    // Configura el filtro de extensiones (opcional)
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos.ser", "ser");
    fileChooser.setFileFilter(filter);
    int userChoice = fileChooser.showSaveDialog(this); // 'this' refers to the current JFrame
    
    if (userChoice == JFileChooser.APPROVE_OPTION) {
        // El usuario ha elegido guardar el archivo en la ubicación seleccionada
        String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".ser";
        FileManager.writeObject(zombie, filePath);
        System.out.println("Zombie guardado exitosamente en: " + filePath);
    } else if (userChoice == JFileChooser.CANCEL_OPTION) {
        // El usuario ha cancelado la operación
        System.out.println("Operación de guardar cancelada.");
    }
            
    // For demonstration purposes, let's just print the details
    System.out.println("Zombie created successfully!");
    System.out.println("Name: " + name);
    System.out.println("Level of Appearance: " + levelAppearance);
    System.out.println("Life: " + life);
    System.out.println("Damage: " + damage);
    System.out.println("Spaces: " + spaces);
    System.out.println("DPS: " + dps);
    System.out.println("Zombie Type: " + zombie.getType());
    System.out.println("Image Path:" + selectedImagePath);
    // Clear validation message after successful validation
    clearValidationMessage();
    
    this.dispose(); // Assuming this is your JFrame

    // Open or show the selection window
    SelectionWindow selectionWindow = new SelectionWindow();
    selectionWindow.setVisible(true);
    }//GEN-LAST:event_JButCrearZombieActionPerformed

    private boolean validateFields() {
    if (JTFName.getText().isEmpty()) {
        showValidationMessage("Please enter a name.");
        return false;
    }
    String name = JTFName.getText();
    if (name.length() < 2 || name.length() > 15) {
        showValidationMessage("Please enter a name between 2 and 15 characters.");
        return false;
    }
    
    if (JTFLevelAppearance.getText().isEmpty()) {
        showValidationMessage("Please enter a level of appearance.");
        return false;
    }

    // Validate that the level of appearance is a positive integer
    try {
        int levelAppearance = Integer.parseInt(JTFLevelAppearance.getText());
        if (levelAppearance <= 0) {
            showValidationMessage("Please enter a valid positive level of appearance.");
            return false;
        }
    } catch (NumberFormatException e) {
        showValidationMessage("Please enter a valid numeric value for the level of appearance.");
        return false;
    }

    if (JTFLife.getText().isEmpty()) {
        showValidationMessage("Please enter a life unit.");
        return false;
    }

    // Validate that life is a non-negative integer
    if (!isNonNegativeInteger(JTFLife.getText())) {
        showValidationMessage("Please enter a valid non-negative integer for life.");
        return false;
    }

    if (JTFDamage.getText().isEmpty()) {
        showValidationMessage("Please enter DPS (Damage Per Second).");
        return false;
    }

    // Validate that DPS is a non-negative integer
    if (!isNonNegativeInteger(JTFDamage.getText())) {
        showValidationMessage("Please enter a valid non-negative integer for DPS.");
        return false;
    }

    if (JFTSpace.getText().isEmpty()) {
        showValidationMessage("Please enter the number of spaces.");
        return false;
    }

    // Validate that spaces is a non-negative integer
    if (!isNonNegativeInteger(JFTSpace.getText())) {
        showValidationMessage("Please enter a valid non-negative integer for spaces.");
        return false;
    }

    if (JTFDPS.getText().isEmpty()) {
        showValidationMessage("Please enter the action range.");
        return false;
    }

    // Validate that action range is a non-negative integer
    if (!isNonNegativeInteger(JTFDPS.getText())) {
        showValidationMessage("Please enter a valid non-negative integer for action range.");
        return false;
    }

    // Add similar checks for other fields...

    return true;
}

// Utility method to check if a string is a non-negative integer
private boolean isNonNegativeInteger(String str) {
    try {
        int value = Integer.parseInt(str);
        return value >= 0;
    } catch (NumberFormatException e) {
        return false;
    }
}

private void showValidationMessage(String message) {
    JLValidation.setText(message);
    JLValidation.setForeground(Color.RED);
}

private void clearValidationMessage() {
    JLValidation.setText("");
}
private boolean isValidImageFile(File file) {
    //Check if the file has a valid image format 
    return file != null && file.isFile() && isImageFile(file.getName());
}

// Utility method to check if a file has an image extension
private boolean isImageFile(String fileName) {
    String[] allowedExtensions = {".png", ".jpg", ".jpeg", ".gif", ".bmp"}; 
    String lowerCaseFileName = fileName.toLowerCase();

    for (String extension : allowedExtensions) {
        if (lowerCaseFileName.endsWith(extension)) {
            return true;
        }
    }

    return false;
}
    private static void readSerializedZombie(String filePath1) {
        // Read the serialized Defense object from the file
        Object obj = FileManager.readObject(filePath1);

        if (obj instanceof Zombie) {
            // Cast the object to Defense type
            Zombie zombie= (Zombie) obj;

            // Now you can access the properties of the Defense object
            System.out.println("Zombie Name: " + zombie.getId());
            System.out.println("Level of Appearance: " + zombie.getUnlockLevel());
            // Add more properties as needed...

        } else {
            System.out.println("The file does not contain a valid Defense object: " + filePath1);
        }
    }

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
            java.util.logging.Logger.getLogger(CreateZombies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateZombies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateZombies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateZombies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateZombies().setVisible(true);
            }
        });
    }
    private javax.swing.JLabel JLValidation;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBoxZombieType;
    private javax.swing.JButton ImageChooser;
    private javax.swing.JButton JButCrearZombie;
    private javax.swing.JTextField JFTSpace;
    private javax.swing.JLabel JLActionRange;
    private javax.swing.JLabel JLAppearanceLevel;
    private javax.swing.JLabel JLLifeUnit;
    private javax.swing.JLabel JLSpace;
    private javax.swing.JLabel JLZombieType;
    private javax.swing.JTextField JTFDPS;
    private javax.swing.JTextField JTFDamage;
    private javax.swing.JTextField JTFLevelAppearance;
    private javax.swing.JTextField JTFLife;
    private javax.swing.JTextField JTFName;
    private javax.swing.JLabel JlAppearance;
    private javax.swing.JLabel JlBackgroundZom;
    private javax.swing.JLabel JlDPS;
    private javax.swing.JLabel JlInfo;
    private javax.swing.JLabel JlInforequest;
    private javax.swing.JLabel JlName;
    private javax.swing.JLabel JlTitle;
    // End of variables declaration//GEN-END:variables
}

