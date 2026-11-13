package model;

public class MedecinRadiologue extends PersonnelMedical {
    private Specialite specialite;
    private double tarifPourcentageActe;

    public MedecinRadiologue(String id, String cin, String nom, String prenom,
                             Specialite specialite, double tarifPourcentageActe) {
        super(id, cin, nom, prenom);
        this.specialite = specialite;
        this.tarifPourcentageActe = tarifPourcentageActe;
    }

    public Specialite getSpecialite() { return specialite; }
    public void setSpecialite(Specialite s) { this.specialite = s; }

    public double getTarifPourcentageActe() { return tarifPourcentageActe; }
    public void setTarifPourcentageActe(double t) { this.tarifPourcentageActe = t; }

    @Override
    public String toString() {
        return "Dr " + nom + " " + prenom + " [" + specialite + "]";
    }
}