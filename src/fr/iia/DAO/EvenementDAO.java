/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Adresse;
import fr.iia.Class.Annonceur;
import fr.iia.Class.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Enzo
 */
public class EvenementDAO {

    public static String creer(Connection cnx, Evenement evenement) throws Exception {

        Evenement eve = trouver(cnx, evenement.getNom());
        if (eve != null) {
            throw new Exception("'" + evenement.getNom() + "' existe déjà !");
        }

        AdresseDAO.creer(cnx, evenement.getAdresse());

        PreparedStatement pstmt = null;
        try {

            pstmt = cnx.prepareStatement("INSERT INTO `evenement`(`nom`, `description`, `date`, `id_adresse`, `id_annonceur`) VALUES (?,?,?,?,?)");

            pstmt.setString(1, evenement.getNom());
            pstmt.setString(2, evenement.getDescription());
            pstmt.setString(3, evenement.getDateEvenement());
            pstmt.setInt(4, evenement.getAdresse().getId());
            pstmt.setInt(5, evenement.getAnnonceur().getId());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.executeQuery("SELECT MAX(id_evenement) FROM evenement");
            if (rs.next()) {
                int id = rs.getInt(1);
                evenement.setId(id);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec creer evenement");
            return "Création échouée";
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Création réussie";
    }

    public static void supprimer(Connection cnx, Evenement eve) {
        Statement stmt = null;
        try {

            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE From evenement Where id_evenement = " + eve.getId());

            System.out.println("Suppression réussie.");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Suppression échouée.");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String modifier(Connection cnx, Evenement evenement) throws Exception {
        Evenement event = trouver(cnx, evenement.getId());

        if (event != null) {
            try {
                throw new Exception(evenement.getId() + " existe déja !");
            } catch (Exception ex) {

            }
        }

        PreparedStatement pstmt = null;
        try {
            AdresseDAO.modifier(cnx, evenement.getAdresse());
//            pstmt.executeUpdate("UPDATE media "
//                + "SET nom = '" + evenement.getNom() + "', description = '" + evenement.getDescription() + "', date = '" + evenement.getDateEvenement() + "', id_adresse = '" + evenement.getAdresse() + "', id_annonceur = '" + evenement.getAnnonceur()+ " "
//                + "WHERE id_evenement = " + evenement.getId());

            pstmt = cnx.prepareStatement("UPDATE `evenement` SET `nom`=?,`description`=?,`date`=?,`id_adresse`=?,`id_annonceur`= ? WHERE `id_evenement` = ?");
            pstmt.setString(1, evenement.getNom());
            pstmt.setString(2,evenement.getDescription());
            pstmt.setString(3, evenement.getDateEvenement());
            pstmt.setInt(4, evenement.getAdresse().getId());
            pstmt.setInt(5,evenement.getAnnonceur().getId());
            // pstmt.setInt(5,annonceur.getMedia().getId());
            pstmt.setInt(6, evenement.getId());

            pstmt.executeUpdate();

            return "Modification réussie";
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec modifier evenement");
            return "Modification échouée";
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList<Evenement> lister(Connection cnx) {
        ArrayList<Evenement> listEvenement = new ArrayList();
        Statement stmt = null;
        try {

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_evenement, nom, description, date, id_adresse, id_annonceur FROM evenement");

            while (rs.next()) {
                int id = rs.getInt("id_evenement");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                String date = rs.getString("date");

                int id_adresse = rs.getInt("id_adresse");
                Adresse adresse = AdresseDAO.trouver(cnx, id_adresse);
                int id_annonceur = rs.getInt("id_annonceur");
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, id_annonceur);

                Evenement evenement = new Evenement(nom, description, date, adresse, annonceur);
                evenement.setId(id);
                listEvenement.add(evenement);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec lister");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return listEvenement;
    }

    public static Evenement trouver(Connection cnx, String nom) {
        Evenement evenement = null;
        Statement stmt = null;
        try {

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_evenement, description, date, id_adresse, id_annonceur FROM evenement WHERE nom = '" + nom + "';");

            if (rs.next()) {
                String libelle = rs.getString("libelle");

                int id = rs.getInt("id_evenement");
                String description = rs.getString("description");
                String date = rs.getString("date");
                Adresse adresse = AdresseDAO.trouver(cnx, id);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, nom);

                Evenement eveResult = new Evenement(nom, description, date, adresse, annonceur);

                eveResult = new Evenement(nom, description, date, adresse, annonceur);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec trouver");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return evenement;
    }

    public static Evenement trouver(Connection cnx, int id) {
        Evenement evenement = null;
        Statement stmt = null;
        try {

            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nom, description, date, id_adresse, id_annonceur FROM evenement WHERE id_evenement = " + id + ";");

            if (rs.next()) {
               // String libelle = rs.getString("libelle");

                String nom = rs.getString("nom");
                String description = rs.getString("description");
                String date = rs.getString("date");
                int id_adresse = rs.getInt("id_adresse");
                int id_annonceur = rs.getInt("id_annonceur");
                Adresse adresse = AdresseDAO.trouver(cnx, id_adresse);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, id_annonceur);

                evenement = new Evenement(nom, description, date, adresse, annonceur);

                // eveResult = new Evenement(nom, description, date, adresse, annonceur);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec trouver");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return evenement;
    }
}
