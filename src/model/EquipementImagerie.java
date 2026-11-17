package model;

public class EquipementImagerie extends Objet implements Reservable {
    private String type;
    private String marque;
    private double heuresCumulees;
    private double heuresRestantesMaintenance;
    private String statut;

    public EquipementImagerie(String id, String type, String marque, double heuresCumulees, double heuresRestantesMaintenance, String statut) {
        super(id);
        this.type = type;
        this.marque = marque;
        this.heuresCumulees = heuresCumulees;
        this.heuresRestantesMaintenance = heuresRestantesMaintenance;
        this.statut = statut;
    }

    public boolean estDisponible() { return statut.equals("EN_SERVICE"); }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }
    public double getHeuresCumulees() { return heuresCumulees; }
    public void setHeuresCumulees(double heuresCumulees) { this.heuresCumulees = heuresCumulees; }
    public double getHeuresRestantesMaintenance() { return heuresRestantesMaintenance; }
    public void setHeuresRestantesMaintenance(double heuresRestantesMaintenance) { this.heuresRestantesMaintenance = heuresRestantesMaintenance; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
