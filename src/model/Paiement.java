package model;

public class Paiement extends Objet {
    private String numFacture;
    private String datePaiement;
    private double montantRecu;
    private String modePaiement;
    private String referenceTextuellePreuve;

    public Paiement(String id, String numFacture, String datePaiement, double montantRecu, String modePaiement, String referenceTextuellePreuve) {
        super(id);
        this.numFacture = numFacture;
        this.datePaiement = datePaiement;
        this.montantRecu = montantRecu;
        this.modePaiement = modePaiement;
        this.referenceTextuellePreuve = referenceTextuellePreuve;
    }

    public String getNumFacture() { return numFacture; }
    public void setNumFacture(String numFacture) { this.numFacture = numFacture; }
    public String getDatePaiement() { return datePaiement; }
    public void setDatePaiement(String datePaiement) { this.datePaiement = datePaiement; }
    public double getMontantRecu() { return montantRecu; }
    public void setMontantRecu(double montantRecu) { this.montantRecu = montantRecu; }
    public String getModePaiement() { return modePaiement; }
    public void setModePaiement(String modePaiement) { this.modePaiement = modePaiement; }
    public String getReferenceTextuellePreuve() { return referenceTextuellePreuve; }
    public void setReferenceTextuellePreuve(String referenceTextuellePreuve) { this.referenceTextuellePreuve = referenceTextuellePreuve; }
}
