/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.DAO;

import fr.iia.Class.Annonceur;
import fr.iia.Class.Contrat;
import fr.iia.Class.Diffuseur;
import fr.iia.Class.Metier;
import fr.iia.Class.Offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;


/**
 *
 * @author Enzo
 */
public class OffreDAO {
    public static String creer(Connection cnx, Offre off) throws Exception{
               
        Offre o = trouver(cnx, off.getReference());
        
        if(o != null){
            throw new Exception("'" + off.getReference() + "' existe déja !");
        }
        
        Statement stmt = null;

        try{
            stmt = cnx.createStatement();
            String sql = "INSERT INTO offre (titre, reference, date_debut_publi, fin_publi, nbr_poste, descr_poste, descr_profil, duree_contrat, id_contrat, id_annonceur, id_diffuseur, id_metier) "
                + "Values ('" + off.getTitre() + "', '" + off.getReference() + "', '" +  off.getDate_debut_publi() + "', '" + off.getFin_publi() + "', " + off.getNbr_poste() + ", '" + off.getDescription_poste() + "', '" + off.getDescription_profil() + "', " + off.getDuree() + ", " + off.getContrat().getId() + ", " + off.getAnnonceur().getId() + ", " + off.getDiffuseur().getId() + ", " + off.getMetier().getId() + ")";
                                                                                                                                                                                                                                                                                            
            stmt.executeUpdate(sql);

            ResultSet rs = stmt.executeQuery("SELECT MAX(id_offre) FROM offre");
            if (rs.next()){
                int id = rs.getInt(1);
                off.setId(id);

            System.out.println("Création réussie.");
            
            }	 
        }

        catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Echec creer offre");
                return "Création échouée";
        }

        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Création réussi";
    } 
    
    public static Offre trouver(Connection cnx, String reference){
        
        Offre offre = null;
        
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_offre, titre, date_debut_publi, fin_publi, nbr_poste, descr_poste, descr_profil, duree_contrat, c.libelle, d.nom, a.nom, m.libelle From offre o, contrat c, annonceur a, diffuseur d, metier m WHERE o.id_contrat = c.id_contrat AND o.id_annonceur = a.id_annonceur AND o.id_diffuseur = d.id_diffuseur AND o.id_metier = m.id_metier AND reference = '" + reference + "';");
            if(rs.next()){
                
                String libelleMetier = rs.getString("m.libelle");
                String libelleContrat = rs.getString("c.libelle");
                String nomAnnonceur = rs.getString("a.nom");
                String nomDiffuseur = rs.getString("d.nom");
               
                Metier metier = MetierDAO.trouver(cnx, libelleMetier);
                Contrat contrat = ContratDAO.trouver(cnx, libelleContrat);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, nomAnnonceur);
                Diffuseur diffuseur = DiffuseursDAO.trouver(cnx, nomDiffuseur);

                
                int id = rs.getInt("id_offre");
                String titre = rs.getString("titre");
                String dateDebutPubli = rs.getString("date_debut_publi");
                String dateFinPubli = rs.getString("fin_publi");
                int nbrPoste = rs.getInt("nbr_poste");
                String descrPoste = rs.getString("descr_poste");
                String descrProfil = rs.getString("descr_profil");
                int dureeContrat = rs.getInt("duree_contrat");
                
                offre = new Offre(titre, reference, dateDebutPubli, dateFinPubli, nbrPoste, descrPoste, descrProfil, dureeContrat, contrat, annonceur, diffuseur, metier);
                //personne.setAge(age);
                offre.setId(id);
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver musique");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return offre;
    }
    
    public static Offre trouver(Connection cnx, int id){
        
        Offre offre = null;
        
        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("Select titre, reference, date_debut_publi, fin_publi, nbr_poste, descr_poste, descr_profil, duree_contrat, id_contrat, id_annonceur, id_diffuseur, id_metier From offre WHERE id_offre = '" + id + "';");
            if(rs.next()){
                
                int idMetier = rs.getInt("id_metier");
                int idContrat = rs.getInt("id_contrat");
                int idAnnonceur = rs.getInt("id_annonceur");
                int idDiffuseur = rs.getInt("id_diffuseur");
               
                Metier metier = MetierDAO.trouver(cnx, idMetier);
                Contrat contrat = ContratDAO.trouver(cnx, idContrat);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, idAnnonceur);
                Diffuseur diffuseur = DiffuseursDAO.trouver(cnx, idDiffuseur);
               
                String titre = rs.getString("titre");
                String reference = rs.getString("reference");
                String dateDebutPubli = rs.getString("date_debut_publi");
                String dateFinPubli = rs.getString("fin_publi");
                int nbrPoste = rs.getInt("nbr_poste");
                String descrPoste = rs.getString("descr_poste");
                String descrProfil = rs.getString("descr_profil");
                int dureeContrat = rs.getInt("duree_contrat");
                
                offre = new Offre(titre, reference, dateDebutPubli, dateFinPubli, nbrPoste, descrPoste, descrProfil, dureeContrat, contrat, annonceur, diffuseur, metier);
                //personne.setAge(age);
                offre.setId(id);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec trouver musique");
        }
        finally{
            if(stmt != null){
                try {
                    stmt.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }   
        }

        return offre;
    }
    
    public static String modifier(Connection cnx, Offre offre) throws Exception {
        Offre o = trouver(cnx,offre.getReference());

        if(o != null){
            try{
                throw new Exception(offre.getId() + " existe déja !");
            }
            catch(Exception ex){	

            }
        }		

        PreparedStatement pstmt = null;
        try{			
           pstmt = cnx.prepareStatement("UPDATE offre SET titre = ? , reference = ? , date_debut_publi = ? , fin_publi = ? , nbr_poste = ? , descr_poste = ? , descr_profil = ? , duree_contrat = ? , id_contrat = ? , id_annonceur = ? , id_diffuseur = ? , id_metier = ? WHERE  id_offre = ?  ");
           
           pstmt.setString(1,offre.getTitre());
           pstmt.setString(2,offre.getReference());
           pstmt.setString(3,offre.getDate_debut_publi());
           pstmt.setString(4,offre.getFin_publi());
           pstmt.setInt(5,offre.getNbr_poste());
           pstmt.setString(6,offre.getDescription_poste());
           pstmt.setString(7,offre.getDescription_profil());
           pstmt.setInt(8,offre.getDuree());
           pstmt.setInt(9,offre.getContrat().getId());
           pstmt.setInt(10,offre.getAnnonceur().getId());
           pstmt.setInt(11,offre.getDiffuseur().getId());
           pstmt.setInt(12,offre.getMetier().getId());
           pstmt.setInt(13,offre.getId());
           
           pstmt.executeUpdate();

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec modifier musique");
            return "Modification echouée";
        }finally{
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Modification réussie";
    }	
    
    public static void supprimer(Connection cnx, Offre offre){

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            stmt.executeUpdate("DELETE FROM offre WHERE id_offre = " + offre.getId());

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec supprimer offre");
        }finally{
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static ArrayList<Offre> lister(Connection cnx){

        ArrayList<Offre> liste = new ArrayList<>();

        Statement stmt = null;
        try{			
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_offre, titre, reference, date_debut_publi, fin_publi, nbr_poste, descr_poste, descr_profil, duree_contrat, id_contrat, id_annonceur, id_diffuseur, id_metier "
                    + "From offre");
            while(rs.next()){
                int id = rs.getInt("id_offre");
                String titre = rs.getString("titre");
                String reference = rs.getString("reference");
                String dateDebutPubli = rs.getString("date_debut_publi");
                String dateFinPubli = rs.getString("fin_publi");
                int nbrPoste = rs.getInt("nbr_poste");               
                String descrPoste = rs.getString("descr_poste");
                String descrProfil = rs.getString("descr_profil");
                int dureeContrat = rs.getInt("duree_contrat");
               
                int idContrat = rs.getInt("id_contrat");
                int intMetier = rs.getInt("id_metier");
                int intAnnonceur = rs.getInt("id_annonceur");              
                int intDiffuseur = rs.getInt("id_diffuseur");              

                Contrat contrat = ContratDAO.trouver(cnx, idContrat);
                Metier metier = MetierDAO.trouver(cnx, intMetier);
                Annonceur annonceur = AnnonceursDAO.trouver(cnx, intAnnonceur);
                Diffuseur diffuseur = DiffuseursDAO.trouver(cnx, intDiffuseur);

                Offre offre = new Offre(titre, reference, dateDebutPubli, dateFinPubli, nbrPoste, descrPoste, descrProfil, dureeContrat, contrat, annonceur, diffuseur, metier);
                offre.setId(id);

                liste.add(offre);				
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Echec lister musique");
        }finally{
            if(stmt != null){
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
