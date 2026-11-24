package controller;

import dao.PaiementDAO;
import model.Paiement;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class PaiementController {

    private PaiementDAO dao = new PaiementDAO();

    public Paiement[] lireTout() {
        return dao.lireTout();
    }

    public Paiement rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String numFacture, String datePaiement, double montantRecu, String modePaiement, String referenceTextuellePreuve) {
        Paiement obj = new Paiement(id, numFacture, datePaiement, montantRecu, modePaiement, referenceTextuellePreuve);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String numFacture, String datePaiement, double montantRecu, String modePaiement, String referenceTextuellePreuve) {
        Paiement obj = new Paiement(id, numFacture, datePaiement, montantRecu, modePaiement, referenceTextuellePreuve);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
