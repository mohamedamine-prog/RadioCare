package controller;

import dao.ExamenMedicalDAO;
import model.ExamenMedical;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class ExamenMedicalController {

    private ExamenMedicalDAO dao = new ExamenMedicalDAO();

    public ExamenMedical[] lireTout() {
        return dao.lireTout();
    }

    public ExamenMedical rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String codeActe, String libelle, int dureeEstimeeMinutes, double tarifHT, boolean necessiteContraste) {
        ExamenMedical obj = new ExamenMedical(id, codeActe, libelle, dureeEstimeeMinutes, tarifHT, necessiteContraste);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String codeActe, String libelle, int dureeEstimeeMinutes, double tarifHT, boolean necessiteContraste) {
        ExamenMedical obj = new ExamenMedical(id, codeActe, libelle, dureeEstimeeMinutes, tarifHT, necessiteContraste);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
