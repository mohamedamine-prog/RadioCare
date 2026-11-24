package controller;

import dao.EquipementImagerieDAO;
import model.EquipementImagerie;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class EquipementImagerieController {

    private EquipementImagerieDAO dao = new EquipementImagerieDAO();

    public EquipementImagerie[] lireTout() {
        return dao.lireTout();
    }

    public EquipementImagerie rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String type, String marque, double heuresCumulees, double heuresRestantesMaintenance, String statut) {
        EquipementImagerie obj = new EquipementImagerie(id, type, marque, heuresCumulees, heuresRestantesMaintenance, statut);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String type, String marque, double heuresCumulees, double heuresRestantesMaintenance, String statut) {
        EquipementImagerie obj = new EquipementImagerie(id, type, marque, heuresCumulees, heuresRestantesMaintenance, statut);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
