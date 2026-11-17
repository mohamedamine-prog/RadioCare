package model;

public class Patient extends Personne {
    private String dateNaissance;
    private String telephone;
    private String email;
    private String numAssurance;
    private double soldeCompte;
    private boolean contreIndication;

    public Patient(String id, String nom, String prenom, String dateNaissance, String telephone, String email, String numAssurance, double soldeCompte, boolean contreIndication) {
        super(id, nom, prenom);
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.email = email;
        this.numAssurance = numAssurance;
        this.soldeCompte = soldeCompte;
        this.contreIndication = contreIndication;
    }

    // le CIN sert d'identifiant du patient
    public String getCin() { return id; }

    public String getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNumAssurance() { return numAssurance; }
    public void setNumAssurance(String numAssurance) { this.numAssurance = numAssurance; }
    public double getSoldeCompte() { return soldeCompte; }
    public void setSoldeCompte(double soldeCompte) { this.soldeCompte = soldeCompte; }
    public boolean isContreIndication() { return contreIndication; }
    public void setContreIndication(boolean contreIndication) { this.contreIndication = contreIndication; }
}
