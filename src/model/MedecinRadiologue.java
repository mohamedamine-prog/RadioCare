package model;

public class MedecinRadiologue extends PersonnelMedical {
    private String specialite;
    private double tarifPourcentageActe;

    public MedecinRadiologue(String id, String cin, String nom, String prenom, String specialite, double tarifPourcentageActe) {
        super(id, cin, nom, prenom);
        this.specialite = specialite;
        this.tarifPourcentageActe = tarifPourcentageActe;
    }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    public double getTarifPourcentageActe() { return tarifPourcentageActe; }
    public void setTarifPourcentageActe(double tarifPourcentageActe) { this.tarifPourcentageActe = tarifPourcentageActe; }
}
