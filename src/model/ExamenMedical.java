package model;

public class ExamenMedical extends Objet {
    private String codeActe;
    private String libelle;
    private int dureeEstimeeMinutes;
    private double tarifHT;
    private boolean necessiteContraste;

    public ExamenMedical(String id, String codeActe, String libelle, int dureeEstimeeMinutes, double tarifHT, boolean necessiteContraste) {
        super(id);
        this.codeActe = codeActe;
        this.libelle = libelle;
        this.dureeEstimeeMinutes = dureeEstimeeMinutes;
        this.tarifHT = tarifHT;
        this.necessiteContraste = necessiteContraste;
    }

    public String getCodeActe() { return codeActe; }
    public void setCodeActe(String codeActe) { this.codeActe = codeActe; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public int getDureeEstimeeMinutes() { return dureeEstimeeMinutes; }
    public void setDureeEstimeeMinutes(int dureeEstimeeMinutes) { this.dureeEstimeeMinutes = dureeEstimeeMinutes; }
    public double getTarifHT() { return tarifHT; }
    public void setTarifHT(double tarifHT) { this.tarifHT = tarifHT; }
    public boolean isNecessiteContraste() { return necessiteContraste; }
    public void setNecessiteContraste(boolean necessiteContraste) { this.necessiteContraste = necessiteContraste; }
}
