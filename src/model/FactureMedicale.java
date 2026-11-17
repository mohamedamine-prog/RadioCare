package model;

public class FactureMedicale extends Objet {
    private String idPatient;
    private String idRdv;
    private double montantHT;
    private double tauxTVA;
    private double montantTTC;
    private double partAssurance;
    private double partPatient;
    private String statutPaiement;

    public FactureMedicale(String id, String idPatient, String idRdv, double montantHT, double tauxTVA, double montantTTC, double partAssurance, double partPatient, String statutPaiement) {
        super(id);
        this.idPatient = idPatient;
        this.idRdv = idRdv;
        this.montantHT = montantHT;
        this.tauxTVA = tauxTVA;
        this.montantTTC = montantTTC;
        this.partAssurance = partAssurance;
        this.partPatient = partPatient;
        this.statutPaiement = statutPaiement;
    }

    public String getIdPatient() { return idPatient; }
    public void setIdPatient(String idPatient) { this.idPatient = idPatient; }
    public String getIdRdv() { return idRdv; }
    public void setIdRdv(String idRdv) { this.idRdv = idRdv; }
    public double getMontantHT() { return montantHT; }
    public void setMontantHT(double montantHT) { this.montantHT = montantHT; }
    public double getTauxTVA() { return tauxTVA; }
    public void setTauxTVA(double tauxTVA) { this.tauxTVA = tauxTVA; }
    public double getMontantTTC() { return montantTTC; }
    public void setMontantTTC(double montantTTC) { this.montantTTC = montantTTC; }
    public double getPartAssurance() { return partAssurance; }
    public void setPartAssurance(double partAssurance) { this.partAssurance = partAssurance; }
    public double getPartPatient() { return partPatient; }
    public void setPartPatient(double partPatient) { this.partPatient = partPatient; }
    public String getStatutPaiement() { return statutPaiement; }
    public void setStatutPaiement(String statutPaiement) { this.statutPaiement = statutPaiement; }
}
