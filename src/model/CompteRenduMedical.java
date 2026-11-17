package model;

public class CompteRenduMedical extends Objet {
    private String idRdv;
    private String date;
    private String refOrdonnanceTextuelle;
    private String transcriptionDiagnosticTextuel;
    private String codeResultat;

    public CompteRenduMedical(String id, String idRdv, String date, String refOrdonnanceTextuelle, String transcriptionDiagnosticTextuel, String codeResultat) {
        super(id);
        this.idRdv = idRdv;
        this.date = date;
        this.refOrdonnanceTextuelle = refOrdonnanceTextuelle;
        this.transcriptionDiagnosticTextuel = transcriptionDiagnosticTextuel;
        this.codeResultat = codeResultat;
    }

    public String getIdRdv() { return idRdv; }
    public void setIdRdv(String idRdv) { this.idRdv = idRdv; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getRefOrdonnanceTextuelle() { return refOrdonnanceTextuelle; }
    public void setRefOrdonnanceTextuelle(String refOrdonnanceTextuelle) { this.refOrdonnanceTextuelle = refOrdonnanceTextuelle; }
    public String getTranscriptionDiagnosticTextuel() { return transcriptionDiagnosticTextuel; }
    public void setTranscriptionDiagnosticTextuel(String transcriptionDiagnosticTextuel) { this.transcriptionDiagnosticTextuel = transcriptionDiagnosticTextuel; }
    public String getCodeResultat() { return codeResultat; }
    public void setCodeResultat(String codeResultat) { this.codeResultat = codeResultat; }
}
