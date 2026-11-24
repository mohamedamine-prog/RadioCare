package controller;

import dao.MedecinRadiologueDAO;
import model.MedecinRadiologue;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class MedecinRadiologueController {

    private MedecinRadiologueDAO dao = new MedecinRadiologueDAO();

    public MedecinRadiologue[] lireTout() {
        return dao.lireTout();
    }

    public MedecinRadiologue rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String cin, String nom, String prenom, String specialite, double tarifPourcentageActe) {
        MedecinRadiologue obj = new MedecinRadiologue(id, cin, nom, prenom, specialite, tarifPourcentageActe);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String cin, String nom, String prenom, String specialite, double tarifPourcentageActe) {
        MedecinRadiologue obj = new MedecinRadiologue(id, cin, nom, prenom, specialite, tarifPourcentageActe);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
