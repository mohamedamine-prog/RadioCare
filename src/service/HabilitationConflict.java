package service;

import dao.EquipementImagerieDAO;
import dao.ManipulateurRadioDAO;
import dao.SalleRadiologieDAO;
import model.EquipementImagerie;
import model.ManipulateurRadio;
import model.RendezVous;
import model.SalleRadiologie;

// Conflit 4 : le manipulateur n'a pas l'habilitation IRM ou Scanner
public class HabilitationConflict implements ConflictRule {

    private SalleRadiologieDAO salleDAO = new SalleRadiologieDAO();
    private EquipementImagerieDAO equipementDAO = new EquipementImagerieDAO();
    private ManipulateurRadioDAO manipDAO = new ManipulateurRadioDAO();

    public String verifier(RendezVous rdv) {
        SalleRadiologie salle = salleDAO.rechercher(rdv.getIdSalle());
        EquipementImagerie equipement = equipementDAO.rechercher(salle.getEquipementAttribueId());
        ManipulateurRadio manip = manipDAO.rechercher(rdv.getIdManip());

        if (equipement == null) {
            return null;   // un equipement invalide est deja signale par le conflit 3
        }
        String type = equipement.getType();
        if (type.equals("IRM") && !manip.possedeHabilitation("IRM")) {
            return "Conflit 4 : le manipulateur " + manip.getId() + " n'a pas l'habilitation IRM";
        }
        if (type.equals("SCANNER_CT") && !manip.possedeHabilitation("SCANNER")) {
            return "Conflit 4 : le manipulateur " + manip.getId() + " n'a pas l'habilitation Scanner";
        }
        return null;
    }
}
