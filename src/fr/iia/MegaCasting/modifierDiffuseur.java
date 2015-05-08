/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.MegaCasting;

import fr.iia.Class.Adresse;
import fr.iia.Class.Diffuseur;
import fr.iia.Class.Musique;
import fr.iia.Connection.JavaConnect;
import fr.iia.DAO.DiffuseursDAO;
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
public class modifierDiffuseur extends javax.swing.JFrame {

    Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form ajouterDiffuseur
     */
    public modifierDiffuseur() {
        initComponents();
        JavaConnect.ImportDriver();
        cnx = JavaConnect.ConnectDB();

        DefaultListModel listModel;
        listModel = new DefaultListModel();

        // java.util.Arrays.sort(dir);
        DiffuseursDAO diffuseurDAO = new DiffuseursDAO();
        Collection<Diffuseur> diffuseurs = DiffuseursDAO.lister(cnx);

        for (Diffuseur diffuseur : diffuseurs) {
            // listModel.addElement(offre.getTitre());
            listModel.addElement(diffuseur.getId() + "-" + diffuseur.getNom());

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomBox = new javax.swing.JTextField();
        mailBox = new javax.swing.JTextField();
        telephoneBox = new javax.swing.JTextField();
        boutonEnregistrer = new javax.swing.JButton();
        numeroSpinner = new javax.swing.JSpinner();
        nomRueBox = new javax.swing.JTextField();
        cpBox = new javax.swing.JTextField();
        villeBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        modifier_liste = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter diffuseur");

        jLabel2.setText("Nom");

        jLabel3.setText("Mail");

        jLabel4.setText("Telephone");

        jLabel5.setText("N° rue");

        jLabel6.setText("Nom rue");

        jLabel7.setText("Code Postal");

        jLabel8.setText("Ville");

        boutonEnregistrer.setText("Modifier");
        boutonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonEnregistrerActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telephoneBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(villeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cpBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(boutonEnregistrer)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(211, 211, 211)
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomRueBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(66, 66, 66))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(villeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telephoneBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(boutonEnregistrer)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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
        // String localisation = localisationBox.getText();

        DiffuseursDAO diffuseursDAO = new DiffuseursDAO();
        Diffuseur diffuseur = DiffuseursDAO.trouver(cnx, id);

        if (diffuseur != null) {
            Adresse adresse = new Adresse(diffuseur.getAdresse().getId(), numRue, codePostal, rue, ville);
            diffuseur = new Diffuseur(id,nom, mail, numTelephone, adresse);

            try {
                String message = DiffuseursDAO.modifier(cnx, diffuseur);
                JOptionPane.showMessageDialog(rootPane, message);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_boutonEnregistrerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String selectedValue = modifier_liste.getSelectedValue().toString();
        String[] str = selectedValue.split("-");
        int id = Integer.parseInt(str[0]);
        Diffuseur diffuseur = DiffuseursDAO.trouver(cnx, id);

        String nom = diffuseur.getNom();
        String mail = diffuseur.getMail();
        String tel = diffuseur.getNumeroTel();
        int numero = diffuseur.getAdresse().getNumero();
        String rue = diffuseur.getAdresse().getRue();
        String ville = diffuseur.getAdresse().getVille();
        String cp = diffuseur.getAdresse().getCodePostal();

        nomBox.setText(nom);
        mailBox.setText(mail);
        telephoneBox.setText(tel);
        numeroSpinner.setValue(numero);
        nomRueBox.setText(rue);
        villeBox.setText(ville);
        cpBox.setText(cp);


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
            java.util.logging.Logger.getLogger(modifierDiffuseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifierDiffuseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifierDiffuseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifierDiffuseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modifierDiffuseur().setVisible(true);
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
