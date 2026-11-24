package model;

public class RendezVous extends Objet {
    private String date;
    private String heureDebut;
    private int dureeMinutes;
    private String idPatient;
    private String idMedecin;
    private String idManip;
    private String idSalle;
    private String idExamen;
    private String statut;

    public RendezVous(String id, String date, String heureDebut, int dureeMinutes, String idPatient, String idMedecin, String idManip, String idSalle, String idExamen, String statut) {
        super(id);
        this.date = date;
        this.heureDebut = heureDebut;
        this.dureeMinutes = dureeMinutes;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.idManip = idManip;
        this.idSalle = idSalle;
        this.idExamen = idExamen;
        this.statut = statut;
    }

    // heure "09:30" -> minutes depuis minuit (570)
    public int getDebutEnMinutes() {
        String[] morceaux = heureDebut.split(":");
        return Integer.parseInt(morceaux[0]) * 60 + Integer.parseInt(morceaux[1]);
    }

    public int getFinEnMinutes() {
        return getDebutEnMinutes() + dureeMinutes;
    }

    // vrai si les deux rendez-vous sont le meme jour et que leurs horaires se chevauchent
    public boolean chevauche(RendezVous autre) {
        if (!date.equals(autre.getDate())) {
            return false;
        }
        return getDebutEnMinutes() < autre.getFinEnMinutes()
                && autre.getDebutEnMinutes() < getFinEnMinutes();
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getHeureDebut() { return heureDebut; }
    public void setHeureDebut(String heureDebut) { this.heureDebut = heureDebut; }
    public int getDureeMinutes() { return dureeMinutes; }
    public void setDureeMinutes(int dureeMinutes) { this.dureeMinutes = dureeMinutes; }
    public String getIdPatient() { return idPatient; }
    public void setIdPatient(String idPatient) { this.idPatient = idPatient; }
    public String getIdMedecin() { return idMedecin; }
    public void setIdMedecin(String idMedecin) { this.idMedecin = idMedecin; }
    public String getIdManip() { return idManip; }
    public void setIdManip(String idManip) { this.idManip = idManip; }
    public String getIdSalle() { return idSalle; }
    public void setIdSalle(String idSalle) { this.idSalle = idSalle; }
    public String getIdExamen() { return idExamen; }
    public void setIdExamen(String idExamen) { this.idExamen = idExamen; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
