/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.MegaCasting;

/**
 *
 * @author Enzo
 */
import fr.iia.Class.Compte;
import fr.iia.Class.Contrat;
import fr.iia.Connection.JavaConnect;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Login extends javax.swing.JFrame {

    Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form Login
     */
    
    public Login() {
        initComponents();
        JavaConnect.ImportDriver();
        cnx = JavaConnect.ConnectDB();
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        loginTextField = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        loginMenu = new javax.swing.JMenuBar();
        aideMenu = new javax.swing.JMenu();
        aideEnLigneMenuAide = new javax.swing.JMenuItem();
        aProposMenuAide = new javax.swing.JMenuItem();
        quitterMenuAide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        loginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mega Casting", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 20), new java.awt.Color(0, 102, 204))); // NOI18N

        userNameLabel.setText("Identifiant");

        passwordLabel.setText("Mot de Passe");

        loginButton.setText("Se Connecter");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLabel)
                    .addComponent(passwordLabel))
                .addGap(59, 59, 59)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton)
                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(loginTextField)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(loginButton))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/petitLogo.png"))); // NOI18N

        aideMenu.setText("Aide");
        aideMenu.setToolTipText("");

        aideEnLigneMenuAide.setText("Docs en ligne et Support");
        aideEnLigneMenuAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aideEnLigneMenuAideActionPerformed(evt);
            }
        });
        aideMenu.add(aideEnLigneMenuAide);

        aProposMenuAide.setText("A propos de");
        aProposMenuAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aProposMenuAideActionPerformed(evt);
            }
        });
        aideMenu.add(aProposMenuAide);

        quitterMenuAide.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        quitterMenuAide.setText("Quitter");
        quitterMenuAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterMenuAideActionPerformed(evt);
            }
        });
        aideMenu.add(quitterMenuAide);

        loginMenu.add(aideMenu);
        aideMenu.getAccessibleContext().setAccessibleName("AideMenu");

        setJMenuBar(loginMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT * FROM compte WHERE login = ? AND password = ?";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, loginTextField.getText());
            pst.setString(2, passwordField.getText());
            
            rs = pst.executeQuery();
            
            if(rs.next()) {
                //Compte compte = new Compte();
                MegaCastingMain mc = new MegaCastingMain();
                
                this.setVisible(false);

                mc.setVisible(true);
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Identifiant ou Mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void quitterMenuAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterMenuAideActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_quitterMenuAideActionPerformed

    private void aideEnLigneMenuAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aideEnLigneMenuAideActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_aideEnLigneMenuAideActionPerformed

    private void aProposMenuAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aProposMenuAideActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_aProposMenuAideActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aProposMenuAide;
    private javax.swing.JMenuItem aideEnLigneMenuAide;
    private javax.swing.JMenu aideMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JMenuBar loginMenu;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JMenuItem quitterMenuAide;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
