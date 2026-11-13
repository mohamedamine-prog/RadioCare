package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Personne {
    private LocalDate dateNaissance;
    private String telephone;
    private String email;
    private String numAssurance;
    private double soldeCompte;
    private boolean contreIndication;
    private List<String> historiqueExamensIds;

    public Patient(String cin, String nom, String prenom, LocalDate dateNaissance,
                   String telephone, String email, String numAssurance) {
        super(cin, nom, prenom);
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.email = email;
        this.numAssurance = numAssurance;
        this.soldeCompte = 0;
        this.contreIndication = false;
        this.historiqueExamensIds = new ArrayList<>();
    }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate d) { this.dateNaissance = d; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNumAssurance() { return numAssurance; }
    public void setNumAssurance(String n) { this.numAssurance = n; }

    public double getSoldeCompte() { return soldeCompte; }
    public void setSoldeCompte(double s) { this.soldeCompte = s; }

    public boolean isContreIndication() { return contreIndication; }
    public void setContreIndication(boolean c) { this.contreIndication = c; }

    public List<String> getHistoriqueExamensIds() { return historiqueExamensIds; }

    @Override
    public String toString() {
        return id + " - " + nom + " " + prenom + " (solde: " + soldeCompte + " DT)";
    }
}