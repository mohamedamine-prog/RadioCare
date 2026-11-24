package service;

import dao.EquipementImagerieDAO;
import dao.SalleRadiologieDAO;
import model.EquipementImagerie;
import model.RendezVous;
import model.SalleRadiologie;

// Conflit 3 : l'examen depasse les heures restantes avant la maintenance de l'appareil
public class QuotaHeuresConflict implements ConflictRule {

    private SalleRadiologieDAO salleDAO = new SalleRadiologieDAO();
    private EquipementImagerieDAO equipementDAO = new EquipementImagerieDAO();

    public String verifier(RendezVous rdv) {
        SalleRadiologie salle = salleDAO.rechercher(rdv.getIdSalle());
        EquipementImagerie equipement = equipementDAO.rechercher(salle.getEquipementAttribueId());

        if (equipement == null) {
            return "Conflit 3 : la salle " + salle.getId() + " n'a pas d'equipement valide";
        }
        if (!equipement.estDisponible()) {
            return "Conflit 3 : l'equipement " + equipement.getId()
                    + " n'est pas en service (" + equipement.getStatut() + ")";
        }
        double minutesRestantes = equipement.getHeuresRestantesMaintenance() * 60;
        if (rdv.getDureeMinutes() > minutesRestantes) {
            return "Conflit 3 : il reste " + (int) minutesRestantes + " min avant maintenance, l'examen dure "
                    + rdv.getDureeMinutes() + " min";
        }
        return null;
    }
}
