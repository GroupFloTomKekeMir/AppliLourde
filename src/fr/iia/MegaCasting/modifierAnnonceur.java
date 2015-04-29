/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.MegaCasting;

import fr.iia.Class.Adresse;
import fr.iia.Class.Annonceur;
import fr.iia.Class.Musique;
import fr.iia.Connection.JavaConnect;
import fr.iia.DAO.AnnonceursDAO;
import fr.iia.DAO.MusiqueDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Flo
 */
public class modifierAnnonceur extends javax.swing.JFrame {

    Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form ajouterAnnonceur
     */
    public modifierAnnonceur() {
        initComponents();
        JavaConnect.ImportDriver();
        cnx = JavaConnect.ConnectDB();

        DefaultListModel listModel;
        listModel = new DefaultListModel();

        // java.util.Arrays.sort(dir);
        AnnonceursDAO annonceursDAO = new AnnonceursDAO();
        Collection<Annonceur> annonceurs = AnnonceursDAO.lister(cnx);

        for (Annonceur annonceur : annonceurs) {
            // listModel.addElement(offre.getTitre());
            listModel.addElement(annonceur.getId() + "-" + annonceur.getNom());

        }

        modifier_liste.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomBox = new javax.swing.JTextField();
        mailBox = new javax.swing.JTextField();
        telephoneBox = new javax.swing.JTextField();
        boutonEnregistrer = new javax.swing.JButton();
        numeroSpinner = new javax.swing.JSpinner();
        nomRueBox = new javax.swing.JTextField();
        cpBox = new javax.swing.JTextField();
        villeBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        modifier_liste = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter Annonceur");

        boutonEnregistrer.setText("Modifier");
        boutonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonEnregistrerActionPerformed(evt);
            }
        });

        cpBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom");

        jLabel3.setText("Mail");

        jLabel4.setText("Telephone");

        jLabel5.setText("N° rue");

        jLabel6.setText("Nom rue");

        jLabel7.setText("Code Postal");

        jLabel8.setText("Ville");

        modifier_liste.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(modifier_liste);

        jButton1.setText("Charger");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telephoneBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cpBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(villeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomRueBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel5)
                                .addGap(76, 76, 76)
                                .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(boutonEnregistrer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(nomBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mailBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(telephoneBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomRueBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(villeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)))
                        .addComponent(boutonEnregistrer)))
                .addGap(4, 4, 4)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonEnregistrerActionPerformed

        String selectedValue = modifier_liste.getSelectedValue().toString();
        String[] str = selectedValue.split("-");
        int id = Integer.parseInt(str[0]);
        // TODO add your handling code here:
        String nom = nomBox.getText();
        String mail = mailBox.getText();
        String numTelephone = telephoneBox.getText();

        int numRue = (int) numeroSpinner.getValue();
        String rue = nomRueBox.getText();
        String codePostal = cpBox.getText();
        String ville = villeBox.getText();
        //String localisation = localisationBox.getText();

        AnnonceursDAO annonceurDAO = new AnnonceursDAO();
        Annonceur annonceur = AnnonceursDAO.trouver(cnx, id);

        if (annonceur != null) {
            Adresse adresse = new Adresse(annonceur.getAdresse().getId(),numRue, codePostal, rue, ville);
            annonceur = new Annonceur(id,nom, mail, rue, adresse);

            try {
                String message = AnnonceursDAO.modifier(cnx, annonceur);
                JOptionPane.showMessageDialog(rootPane, message);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_boutonEnregistrerActionPerformed

    private void cpBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String selectedValue = modifier_liste.getSelectedValue().toString();
        String[] str = selectedValue.split("-");
        int id = Integer.parseInt(str[0]);

        Annonceur annonceur = AnnonceursDAO.trouver(cnx, id);

        String nom = annonceur.getNom();
        String mail = annonceur.getMail();
        String tel = annonceur.getNumeroTel();
        String rue = annonceur.getAdresse().getRue();
        int numero = annonceur.getAdresse().getNumero();
        String cp = annonceur.getAdresse().getCodePostal();
        String ville = annonceur.getAdresse().getVille();

        nomBox.setText(nom);
        mailBox.setText(mail);
        telephoneBox.setText(tel);
        numeroSpinner.setValue(numero);
        nomRueBox.setText(rue);
        cpBox.setText(cp);
        villeBox.setText(ville);


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(modifierAnnonceur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifierAnnonceur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifierAnnonceur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifierAnnonceur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modifierAnnonceur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonEnregistrer;
    private javax.swing.JTextField cpBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mailBox;
    private javax.swing.JList modifier_liste;
    private javax.swing.JTextField nomBox;
    private javax.swing.JTextField nomRueBox;
    private javax.swing.JSpinner numeroSpinner;
    private javax.swing.JTextField telephoneBox;
    private javax.swing.JTextField villeBox;
    // End of variables declaration//GEN-END:variables
}