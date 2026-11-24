package controller;

import dao.SalleRadiologieDAO;
import model.SalleRadiologie;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class SalleRadiologieController {

    private SalleRadiologieDAO dao = new SalleRadiologieDAO();

    public SalleRadiologie[] lireTout() {
        return dao.lireTout();
    }

    public SalleRadiologie rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String nom, int numeroEtage, String typeSalle, String equipementAttribueId, String normeBlindagePlomb, boolean statutDispo) {
        SalleRadiologie obj = new SalleRadiologie(id, nom, numeroEtage, typeSalle, equipementAttribueId, normeBlindagePlomb, statutDispo);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String nom, int numeroEtage, String typeSalle, String equipementAttribueId, String normeBlindagePlomb, boolean statutDispo) {
        SalleRadiologie obj = new SalleRadiologie(id, nom, numeroEtage, typeSalle, equipementAttribueId, normeBlindagePlomb, statutDispo);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
