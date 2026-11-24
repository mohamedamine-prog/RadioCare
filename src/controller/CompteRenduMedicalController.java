package controller;

import dao.CompteRenduMedicalDAO;
import model.CompteRenduMedical;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class CompteRenduMedicalController {

    private CompteRenduMedicalDAO dao = new CompteRenduMedicalDAO();

    public CompteRenduMedical[] lireTout() {
        return dao.lireTout();
    }

    public CompteRenduMedical rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String idRdv, String date, String refOrdonnanceTextuelle, String transcriptionDiagnosticTextuel, String codeResultat) {
        CompteRenduMedical obj = new CompteRenduMedical(id, idRdv, date, refOrdonnanceTextuelle, transcriptionDiagnosticTextuel, codeResultat);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String idRdv, String date, String refOrdonnanceTextuelle, String transcriptionDiagnosticTextuel, String codeResultat) {
        CompteRenduMedical obj = new CompteRenduMedical(id, idRdv, date, refOrdonnanceTextuelle, transcriptionDiagnosticTextuel, codeResultat);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
