/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.MegaCasting;

import fr.iia.Class.Adresse;
import fr.iia.Class.Annonceur;
import fr.iia.Class.Evenement;
import fr.iia.Class.Musique;
import fr.iia.Connection.JavaConnect;
import fr.iia.DAO.AnnonceursDAO;
import fr.iia.DAO.EvenementDAO;
import fr.iia.DAO.MusiqueDAO;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Flo
 */
public class modifierEvenement extends javax.swing.JFrame {

    Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form ajouterEvenement
     */
    public modifierEvenement() {
        initComponents();
        JavaConnect.ImportDriver();
        cnx = JavaConnect.ConnectDB();
        annonceurBoxActionPerformed(null);

        DefaultListModel listModel;
        listModel = new DefaultListModel();

        // java.util.Arrays.sort(dir);
        EvenementDAO evenementDAO = new EvenementDAO();
        Collection<Evenement> evenements = EvenementDAO.lister(cnx);

        for (Evenement evenement : evenements) {
            // listModel.addElement(offre.getTitre());
            listModel.addElement(evenement.getId() + "-" + evenement.getNom());

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

        jLabel2 = new javax.swing.JLabel();
        nomBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numeroSpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        nomRueBox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cpBox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        villeBox = new javax.swing.JTextField();
        boutonEnregistrer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionBox = new javax.swing.JTextArea();
        annonceurBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        dateBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        latitudeBox = new javax.swing.JTextField();
        longitudeBox = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        modifier_liste = new javax.swing.JList();
        charger = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter evenement");

        jLabel2.setText("Nom");

        jLabel3.setText("Description");

        jLabel5.setText("N° rue");

        jLabel6.setText("Nom rue");

        jLabel7.setText("Code Postal");

        cpBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpBoxActionPerformed(evt);
            }
        });

        jLabel8.setText("Ville");

        villeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villeBoxActionPerformed(evt);
            }
        });

        boutonEnregistrer.setText("Modifier");
        boutonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonEnregistrerActionPerformed(evt);
            }
        });

        descriptionBox.setColumns(20);
        descriptionBox.setRows(5);
        jScrollPane1.setViewportView(descriptionBox);

        annonceurBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annonceurBoxActionPerformed(evt);
            }
        });

        jLabel10.setText("Annonceur");

        dateBox.setText("jj/mm/aaaa");
        dateBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        jLabel4.setText("Latitude");

        jLabel11.setText("Longitude");

        modifier_liste.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(modifier_liste);

        charger.setText("Charger");
        charger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(latitudeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(annonceurBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cpBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(villeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addComponent(nomRueBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(dateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(longitudeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(boutonEnregistrer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(charger)
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomRueBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(latitudeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(longitudeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(villeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(annonceurBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boutonEnregistrer)
                        .addGap(31, 31, 31))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(charger)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonEnregistrerActionPerformed

        // TODO add your handling code here:
        String selectedValue = modifier_liste.getSelectedValue().toString();
        String[] str = selectedValue.split("-");
        int id = Integer.parseInt(str[0]);

        String nom = nomBox.getText();
        String description = descriptionBox.getText();
        String dateEvenement = dateBox.getText();

        int numRue = (int) numeroSpinner.getValue();
        String rue = nomRueBox.getText();
        String codePostal = cpBox.getText();
        String ville = villeBox.getText();
        String latitude = latitudeBox.getText();
        String longitude = longitudeBox.getText();

        String nomAnnonceur = (String) annonceurBox.getSelectedItem();

        EvenementDAO evenementDAO = new EvenementDAO();
        Evenement evenement = EvenementDAO.trouver(cnx, id);
        AnnonceursDAO annonceurDAO = new AnnonceursDAO();

        if (evenement != null) {
            Adresse adresse = new Adresse(evenement.getAdresse().getId(),numRue, codePostal, rue, ville, latitude, longitude);
            Annonceur annonceur = AnnonceursDAO.trouver(cnx, nomAnnonceur);
            evenement = new Evenement(id,nom, description, dateEvenement, adresse, annonceur);

            try {
                String message = EvenementDAO.modifier(cnx, evenement);
                JOptionPane.showMessageDialog(rootPane, message);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_boutonEnregistrerActionPerformed

    private void annonceurBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annonceurBoxActionPerformed
        try {
            String sql = "Select nom from annonceur";
            pst = cnx.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String nom = rs.getString("nom");
                annonceurBox.addItem(nom);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_annonceurBoxActionPerformed

    private void dateBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateBoxActionPerformed

    private void villeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villeBoxActionPerformed

    private void cpBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpBoxActionPerformed

    private void chargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargerActionPerformed
        // TODO add your handling code here:
        String selectedValue = modifier_liste.getSelectedValue().toString();
        String[] str = selectedValue.split("-");
        int id = Integer.parseInt(str[0]);
        Evenement evenement = EvenementDAO.trouver(cnx, id);
        String Nom = evenement.getNom();
        String description = evenement.getDescription();
        String latitude = evenement.getAdresse().getLatitude();
        String longitude = evenement.getAdresse().getLongitude();
        String date = evenement.getDateEvenement();
        int numero = evenement.getAdresse().getNumero();
        String rue = evenement.getAdresse().getRue();
        String cp = evenement.getAdresse().getCodePostal();
        String ville = evenement.getAdresse().getVille();
        String annonceur = evenement.getAnnonceur().getNom();

        nomBox.setText(Nom);
        descriptionBox.setText(description);
        latitudeBox.setText(latitude);
        longitudeBox.setText(longitude);
        dateBox.setText(date);
        numeroSpinner.setValue(numero);
        nomRueBox.setText(rue);
        villeBox.setText(ville);
        annonceurBox.setSelectedItem(annonceur);
        cpBox.setText(cp);

    }//GEN-LAST:event_chargerActionPerformed

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
            java.util.logging.Logger.getLogger(modifierEvenement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifierEvenement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifierEvenement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifierEvenement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modifierEvenement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox annonceurBox;
    private javax.swing.JButton boutonEnregistrer;
    private javax.swing.JButton charger;
    private javax.swing.JTextField cpBox;
    private javax.swing.JTextField dateBox;
    private javax.swing.JTextArea descriptionBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField latitudeBox;
    private javax.swing.JTextField longitudeBox;
    private javax.swing.JList modifier_liste;
    private javax.swing.JTextField nomBox;
    private javax.swing.JTextField nomRueBox;
    private javax.swing.JSpinner numeroSpinner;
    private javax.swing.JTextField villeBox;
    // End of variables declaration//GEN-END:variables
}
