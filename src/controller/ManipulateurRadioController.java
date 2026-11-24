package controller;

import dao.ManipulateurRadioDAO;
import model.ManipulateurRadio;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class ManipulateurRadioController {

    private ManipulateurRadioDAO dao = new ManipulateurRadioDAO();

    public ManipulateurRadio[] lireTout() {
        return dao.lireTout();
    }

    public ManipulateurRadio rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String cin, String nom, String prenom, String habilitations, double tarifHoraire, boolean disponible) {
        ManipulateurRadio obj = new ManipulateurRadio(id, cin, nom, prenom, habilitations, tarifHoraire, disponible);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String cin, String nom, String prenom, String habilitations, double tarifHoraire, boolean disponible) {
        ManipulateurRadio obj = new ManipulateurRadio(id, cin, nom, prenom, habilitations, tarifHoraire, disponible);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
