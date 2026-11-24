package service;

import dao.RendezVousDAO;
import model.RendezVous;

// Conflit 2 : medecin ou manipulateur deja affecte a un autre examen au meme moment
public class AgendaConflict implements ConflictRule {

    private RendezVousDAO rdvDAO = new RendezVousDAO();

    public String verifier(RendezVous rdv) {
        RendezVous[] tous = rdvDAO.lireTout();

        for (int i = 0; i < tous.length; i++) {
            RendezVous autre = tous[i];
            if (autre.getStatut().equals("ANNULE") || autre.getId().equals(rdv.getId())) {
                continue;
            }
            if (!rdv.chevauche(autre)) {
                continue;
            }
            if (autre.getIdMedecin().equals(rdv.getIdMedecin())) {
                return "Conflit 2 : le medecin " + rdv.getIdMedecin()
                        + " est deja occupe a ce creneau (RDV " + autre.getId() + ")";
            }
            if (autre.getIdManip().equals(rdv.getIdManip())) {
                return "Conflit 2 : le manipulateur " + rdv.getIdManip()
                        + " est deja occupe a ce creneau (RDV " + autre.getId() + ")";
            }
        }
        return null;
    }
}
