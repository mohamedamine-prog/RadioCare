package service;

import dao.RendezVousDAO;
import dao.SalleRadiologieDAO;
import model.RendezVous;
import model.SalleRadiologie;

// Conflit 1 : double reservation de salle ou d'equipement
public class SalleEquipementConflict implements ConflictRule {

    private RendezVousDAO rdvDAO = new RendezVousDAO();
    private SalleRadiologieDAO salleDAO = new SalleRadiologieDAO();

    public String verifier(RendezVous rdv) {
        SalleRadiologie salle = salleDAO.rechercher(rdv.getIdSalle());
        RendezVous[] tous = rdvDAO.lireTout();

        for (int i = 0; i < tous.length; i++) {
            RendezVous autre = tous[i];
            if (autre.getStatut().equals("ANNULE") || autre.getId().equals(rdv.getId())) {
                continue;
            }
            if (!rdv.chevauche(autre)) {
                continue;
            }
            // meme salle au meme moment
            if (autre.getIdSalle().equals(rdv.getIdSalle())) {
                return "Conflit 1 : la salle est deja reservee a ce creneau (RDV " + autre.getId() + ")";
            }
            // autre salle, mais meme equipement au meme moment
            SalleRadiologie salleAutre = salleDAO.rechercher(autre.getIdSalle());
            if (salleAutre != null && !salle.getEquipementAttribueId().equals("")
                    && salleAutre.getEquipementAttribueId().equals(salle.getEquipementAttribueId())) {
                return "Conflit 1 : l'equipement " + salle.getEquipementAttribueId()
                        + " est deja utilise a ce creneau (RDV " + autre.getId() + ")";
            }
        }
        return null;
    }
}
