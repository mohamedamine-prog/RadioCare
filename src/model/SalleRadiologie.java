package model;

public class SalleRadiologie extends Objet implements Reservable {
    private String nom;
    private int numeroEtage;
    private String typeSalle;
    private String equipementAttribueId;
    private String normeBlindagePlomb;
    private boolean statutDispo;

    public SalleRadiologie(String id, String nom, int numeroEtage, String typeSalle, String equipementAttribueId, String normeBlindagePlomb, boolean statutDispo) {
        super(id);
        this.nom = nom;
        this.numeroEtage = numeroEtage;
        this.typeSalle = typeSalle;
        this.equipementAttribueId = equipementAttribueId;
        this.normeBlindagePlomb = normeBlindagePlomb;
        this.statutDispo = statutDispo;
    }

    public boolean estDisponible() { return statutDispo; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getNumeroEtage() { return numeroEtage; }
    public void setNumeroEtage(int numeroEtage) { this.numeroEtage = numeroEtage; }
    public String getTypeSalle() { return typeSalle; }
    public void setTypeSalle(String typeSalle) { this.typeSalle = typeSalle; }
    public String getEquipementAttribueId() { return equipementAttribueId; }
    public void setEquipementAttribueId(String equipementAttribueId) { this.equipementAttribueId = equipementAttribueId; }
    public String getNormeBlindagePlomb() { return normeBlindagePlomb; }
    public void setNormeBlindagePlomb(String normeBlindagePlomb) { this.normeBlindagePlomb = normeBlindagePlomb; }
    public boolean isStatutDispo() { return statutDispo; }
    public void setStatutDispo(boolean statutDispo) { this.statutDispo = statutDispo; }
}
