/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.Class;

import java.util.Objects;

/**
 *
 * @author Enzo
 */
public class Musique {
    private int id;
    private String titre;
    private String description;
    private String genre;
    private String lien_yt;
    private String date_ajout;
    private Utilisateur Utilisateur;

    public String getLien_yt() {
        return lien_yt;
    }

    public void setLien_yt(String lien_yt) {
        this.lien_yt = lien_yt;
    }

    public String getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Utilisateur getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(Utilisateur Utilisateur) {
        this.Utilisateur = Utilisateur;
    }

    public Musique(String titre, String description, String genre, Utilisateur Utilisateur) {
        this.titre = titre;
        this.description = description;
        this.genre = genre;
        this.Utilisateur = Utilisateur;
    }

    public Musique(String titre, String description, String genre, String lien_yt, String date_ajout, Utilisateur Utilisateur) {
        this.titre = titre;
        this.description = description;
        this.genre = genre;
        this.lien_yt = lien_yt;
        this.date_ajout = date_ajout;
        this.Utilisateur = Utilisateur;
    }

    public Musique(int id, String titre, String description, String genre, String lien_yt, String date_ajout, Utilisateur Utilisateur) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.genre = genre;
        this.lien_yt = lien_yt;
        this.date_ajout = date_ajout;
        this.Utilisateur = Utilisateur;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Musique other = (Musique) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.Utilisateur, other.Utilisateur)) {
            return false;
        }
        return true;
    }
}
