package model;

public abstract class Personne extends Objet {
    protected String nom;
    protected String prenom;

    public Personne(String id, String nom, String prenom) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
}