/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Musique;
import fr.iia.Class.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Enzo
 */
public class MusiqueDAO {

    public static String creer(Connection cnx, Musique mus) throws Exception {

        Musique m = trouver(cnx, mus.getTitre());
        if (m != null) {
            throw new Exception("'" + mus.getTitre() + " " + mus.getUtilisateur().getNom_artiste() + "' existe déja !");
        }

        Statement stmt = null;

        try {
            stmt = cnx.createStatement();
            stmt.executeUpdate("INSERT INTO musique (titre, description, genre,date_ajout,lien_yt, id_utilisateur) "
                    + "Values ('" + mus.getTitre() + "', '" + mus.getDescription() + "', '" + mus.getGenre() + "','" + mus.getDate_ajout() + "','" + mus.getLien_yt() + "','" + mus.getUtilisateur().getId() + "')");

            ResultSet rs = stmt.executeQuery("SELECT MAX(id_musique) FROM musique");
            if (rs.next()) {
                int id = rs.getInt(1);
                mus.setId(id);

                System.out.println("Création réussie.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec creer musique");
            return "Création échouée";
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Création réussie";
    }

    public static Musique trouver(Connection cnx, String titre) {

        Musique musique = null;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_musique, description, genre,date_ajout,lien_yt, id_utilisateur "
                    + "From musique "
                    + "WHERE titre = '" + titre + "';");
            if (rs.next()) {

                int id = rs.getInt("id_musique");
                String description = rs.getString("description");
                String genre = rs.getString("genre");
                String date = rs.getDate("date_ajout").toString();
                String lien_yt = rs.getString("lien_yt");
                int idUtil = rs.getInt("id_utilisateur");

                Utilisateur utilisateur = UtilisateurDAO.trouver(cnx, idUtil);

                musique = new Musique(titre, description, genre, date, lien_yt, utilisateur);
                //personne.setAge(age);
                musique.setId(id);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec trouver musique");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return musique;
    }

    public static Musique trouver(Connection cnx, int id) {

        Musique musique = null;

        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select titre, description,date_ajout,lien_yt, genre, id_utilisateur From musique WHERE id_musique = '" + id + "';");
            if (rs.next()) {

                int idArtiste = rs.getInt("id_utilisateur");

                Utilisateur utilisateur = UtilisateurDAO.trouver(cnx, idArtiste);

                String titre = rs.getString("titre");
                String description = rs.getString("description");
                String date = rs.getDate("date_ajout").toString();
                String lien_yt = rs.getString("lien_yt");
                String genre = rs.getString("genre");

                musique = new Musique(titre, description, genre, date, lien_yt, utilisateur);
                //personne.setAge(age);
                musique.setId(id);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec trouver musique");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return musique;
    }

    public static String modifier(Connection cnx, Musique musique) throws Exception {
        Musique m = trouver(cnx, musique.getId());

        if (m != null) {
            try {
                throw new Exception(musique.getId() + " existe déja !");
            } catch (Exception ex) {

            }
        }

        PreparedStatement pstmt = null;
        try {
         UtilisateurDAO.modifier(cnx, musique.getUtilisateur());
            
//            stmt.executeUpdate("UPDATE musique "
//                    + "SET titre = '" + musique.getTitre() + "', description = '" + musique.getDescription() + "', genre = '" + musique.getGenre() + "', id_utilisateur = '" + musique.getUtilisateur() + " "
//                    + "WHERE id_musique = " + musique.getId());
         
          pstmt = cnx.prepareStatement("UPDATE `musique` SET `titre`=?,`description`=?,`genre`=?,`date_ajout`=?,`lien_yt`=?,`id_utilisateur`=? WHERE `id_musique`= ?");
             pstmt.setString(1,musique.getTitre());
             pstmt.setString(2,musique.getDescription());
             pstmt.setString(3,musique.getGenre());
             pstmt.setString(4,musique.getDate_ajout());
             pstmt.setString(5,musique.getLien_yt());
             pstmt.setInt(6, musique.getUtilisateur().getId());
             pstmt.setInt(7,musique.getId());
             
             pstmt.executeUpdate();

            return "Modificatino réussie";
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec modifier musique");
            return "Modification échouée";
          
          
            
        }finally{
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void supprimer(Connection cnx, Musique musique) {

        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM musique WHERE id_musique = " + musique.getId());

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec supprimer musique");
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

    public static ArrayList<Musique> lister(Connection cnx) {

        ArrayList<Musique> liste = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_musique, titre, description, genre, id_utilisateur FROM musique");
            while (rs.next()) {
                int id = rs.getInt("id_musique");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                String genre = rs.getString("genre");

                int idUtil = rs.getInt("id_utilisateur");

                Utilisateur utilisateur = UtilisateurDAO.trouver(cnx, idUtil);

                Musique musique = new Musique(titre, description, genre, utilisateur);
                musique.setId(id);

                liste.add(musique);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec lister musique");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return liste;
    }
}
