package model;

public abstract class PersonnelMedical extends Personne {
    protected String cin;

    public PersonnelMedical(String id, String cin, String nom, String prenom) {
        super(id, nom, prenom);
        this.cin = cin;
    }

    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }
}