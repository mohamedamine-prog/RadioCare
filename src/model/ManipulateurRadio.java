package model;

import java.util.HashSet;
import java.util.Set;

public class ManipulateurRadio extends PersonnelMedical {
    private Set<Habilitation> habilitations;
    private double tarifHoraire;
    private boolean disponible;

    public ManipulateurRadio(String id, String cin, String nom, String prenom, double tarifHoraire) {
        super(id, cin, nom, prenom);
        this.tarifHoraire = tarifHoraire;
        this.habilitations = new HashSet<>();
        this.disponible = true;
    }

    public void ajouterHabilitation(Habilitation h) { habilitations.add(h); }

    public boolean possedeHabilitation(Habilitation h) { return habilitations.contains(h); }

    public Set<Habilitation> getHabilitations() { return habilitations; }

    public double getTarifHoraire() { return tarifHoraire; }
    public void setTarifHoraire(double t) { this.tarifHoraire = t; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean d) { this.disponible = d; }

    @Override
    public String toString() {
        return nom + " " + prenom + " " + habilitations;
    }
}