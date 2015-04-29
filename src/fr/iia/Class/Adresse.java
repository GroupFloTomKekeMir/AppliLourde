package fr.iia.Class;

import java.util.Objects;


public class Adresse {

    private int id;
    private int numero;
    private String codePostal;
    private String rue;
    private String ville;
    private String latitude;
    private String longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }



    public Adresse(int numero, String codePostal, String rue, String ville) {
        this.numero = numero;
        this.codePostal = codePostal;
        this.rue = rue;
        this.ville = ville;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Adresse(int id, int numero, String codePostal, String rue, String ville, String latitude, String longitude) {
        this.id = id;
        this.numero = numero;
        this.codePostal = codePostal;
        this.rue = rue;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Adresse(int numero, String codePostal, String rue, String ville, String latitude, String longitude) {
        this.numero = numero;
        this.codePostal = codePostal;
        this.rue = rue;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Adresse(int id, int numero, String codePostal, String rue, String ville) {
        this.id = id;
        this.numero = numero;
        this.codePostal = codePostal;
        this.rue = rue;
        this.ville = ville;
    }


    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresse other = (Adresse) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.codePostal != other.codePostal) {
            return false;
        }
        if (!Objects.equals(this.rue, other.rue)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }

        return true;
    }
}
