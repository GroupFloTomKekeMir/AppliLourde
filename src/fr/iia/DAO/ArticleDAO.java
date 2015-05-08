/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Enzo
 */
public class ArticleDAO {

    public static String creer(Connection cnx, Article article) throws Exception {

        Article a = trouver(cnx, article.getId());
        if (a != null) {
            throw new Exception("'" + a.getNom() + "' existe déja !");
        }

        PreparedStatement pstmt = null;

        try {

            pstmt = cnx.prepareStatement("INSERT INTO `article`(`nom`, `prix`, `description`) VALUES (?,?,?)");
            pstmt.setString(1, article.getNom());
            pstmt.setFloat(2, article.getPrix());
            pstmt.setString(3, article.getDescription());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.executeQuery("SELECT MAX(id_article) FROM article");

            if (rs.next()) {
                int id = rs.getInt(1);
                article.setId(id);

                System.out.println("Création réussie.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec creer article");
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

    public static Article trouver(Connection cnx, String nom) {

        Article article = null;
        PreparedStatement pstmt = null;
        try {

//            ResultSet rs = stmt.executeQuery("Select id_musique, description, genre,date_ajout,lien_yt, id_utilisateur "
//                    + "From musique "
//                    + "WHERE titre = '" + titre + "';");
            pstmt = cnx.prepareStatement("Select id_article , prix , description FROM article WHERE nom = ?");
            pstmt.setString(1, nom);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id_article");
                float prix = rs.getFloat("prix");
                String description = rs.getString("description");

                article = new Article(nom, prix, description);
                //personne.setAge(age);
                article.setId(id);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec trouver article");
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return article;
    }

    public static Article trouver(Connection cnx, int id) {

        Article article = null;

        PreparedStatement pstmt = null;
        try {

//            ResultSet rs = stmt.executeQuery("Select titre, description,date_ajout,lien_yt, genre, id_utilisateur From musique WHERE id_musique = '" + id + "';");
            pstmt = cnx.prepareStatement("Select nom , prix , description FROM article WHERE id_article = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String nom = rs.getString("nom");
                float prix = rs.getFloat("prix");
                String description = rs.getString("description");


                article = new Article(nom, prix, description);
                //personne.setAge(age);
                article.setId(id);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec trouver article");
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return article;
    }

    public static String modifier(Connection cnx, Article article) throws Exception {
        Article a = trouver(cnx, article.getId());

        if (a != null) {
            try {
                throw new Exception(article.getId() + " existe déja !");
            } catch (Exception ex) {

            }
        }

        PreparedStatement pstmt = null;
        try {

//            stmt.executeUpdate("UPDATE musique "
//                    + "SET titre = '" + musique.getTitre() + "', description = '" + musique.getDescription() + "', genre = '" + musique.getGenre() + "', id_utilisateur = '" + musique.getUtilisateur() + " "
//                    + "WHERE id_musique = " + musique.getId());
            pstmt = cnx.prepareStatement("UPDATE `article` SET `nom`=?,`prix`=?,`description`=? WHERE `id_article`= ?");
            pstmt.setString(1, article.getNom());
            pstmt.setFloat(2, article.getPrix());
            pstmt.setString(3, article.getDescription());
            pstmt.setInt(4, article.getId());

            pstmt.executeUpdate();

            return "Modification réussie";
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec modifier article");
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

    public static void supprimer(Connection cnx, Article article) {

       PreparedStatement pstmt = null;
        try {

            pstmt = cnx.prepareStatement("DELETE FROM article WHERE id_article= " + article.getId());
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec supprimer article");
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

    public static ArrayList<Article> lister(Connection cnx) {

        ArrayList<Article> liste = new ArrayList<>();

        PreparedStatement pstmt = null;
        try {

           pstmt = cnx.prepareStatement("SELECT id_article, nom, prix, description FROM article");
           ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_article");
                String nom = rs.getString("nom");
                float prix = rs.getFloat("prix");
                String description = rs.getString("description");



                Article article = new Article(nom, prix, description);
                article.setId(id);

                liste.add(article);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Echec lister article");
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return liste;
    }
}
