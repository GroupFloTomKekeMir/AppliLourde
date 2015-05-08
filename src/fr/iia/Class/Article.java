/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.Class;
import java.util.Objects;
/**
 *
 * @author thomas
 */
public class Article {
    
    private int id;
    private String Nom;
    private float Prix;
    private String Description;

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public float getPrix() {
        return Prix;
    }

    public void setPrix(float Prix) {
        this.Prix = Prix;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Article(int id, String Nom, float Prix, String Description) {
        this.id = id;
        this.Nom = Nom;
        this.Prix = Prix;
        this.Description = Description;
    }

    public Article(String Nom, float Prix, String Description) {
        this.Nom = Nom;
        this.Prix = Prix;
        this.Description = Description;
    }
    
    
    
    
}
