package model;

public class ManipulateurRadio extends PersonnelMedical {
    private String habilitations;
    private double tarifHoraire;
    private boolean disponible;

    public ManipulateurRadio(String id, String cin, String nom, String prenom, String habilitations, double tarifHoraire, boolean disponible) {
        super(id, cin, nom, prenom);
        this.habilitations = habilitations;
        this.tarifHoraire = tarifHoraire;
        this.disponible = disponible;
    }

    // habilitations stockees sous forme de texte : "IRM,SCANNER"
    public boolean possedeHabilitation(String h) {
        for (String x : habilitations.split(",")) {
            if (x.trim().equalsIgnoreCase(h)) return true;
        }
        return false;
    }

    public String getHabilitations() { return habilitations; }
    public void setHabilitations(String habilitations) { this.habilitations = habilitations; }
    public double getTarifHoraire() { return tarifHoraire; }
    public void setTarifHoraire(double tarifHoraire) { this.tarifHoraire = tarifHoraire; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
