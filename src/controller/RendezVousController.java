package controller;

import dao.RendezVousDAO;
import model.RendezVous;
import service.RendezVousService;

// Pour les rendez-vous, ajouter et modifier passent par le service (moteur de conflits).
// Lecture, recherche et suppression restent des appels directs au DAO.
public class RendezVousController {

    private RendezVousDAO dao = new RendezVousDAO();
    private RendezVousService service = new RendezVousService();

    public RendezVous[] lireTout() {
        return dao.lireTout();
    }

    public RendezVous rechercher(String id) {
        return dao.rechercher(id);
    }

    // renvoie la liste des conflits : tableau vide = enregistre
    public String[] ajouter(String id, String date, String heureDebut, int dureeMinutes, String idPatient,
                            String idMedecin, String idManip, String idSalle, String idExamen, String statut) {
        RendezVous obj = new RendezVous(id, date, heureDebut, dureeMinutes, idPatient, idMedecin, idManip, idSalle, idExamen, statut);
        return service.planifier(obj);
    }

    public String[] modifier(String id, String date, String heureDebut, int dureeMinutes, String idPatient,
                             String idMedecin, String idManip, String idSalle, String idExamen, String statut) {
        RendezVous obj = new RendezVous(id, date, heureDebut, dureeMinutes, idPatient, idMedecin, idManip, idSalle, idExamen, statut);
        return service.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
