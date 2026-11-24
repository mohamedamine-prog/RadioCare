package controller;

import dao.FactureMedicaleDAO;
import model.FactureMedicale;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class FactureMedicaleController {

    private FactureMedicaleDAO dao = new FactureMedicaleDAO();

    public FactureMedicale[] lireTout() {
        return dao.lireTout();
    }

    public FactureMedicale rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String idPatient, String idRdv, double montantHT, double tauxTVA, double montantTTC, double partAssurance, double partPatient, String statutPaiement) {
        FactureMedicale obj = new FactureMedicale(id, idPatient, idRdv, montantHT, tauxTVA, montantTTC, partAssurance, partPatient, statutPaiement);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String idPatient, String idRdv, double montantHT, double tauxTVA, double montantTTC, double partAssurance, double partPatient, String statutPaiement) {
        FactureMedicale obj = new FactureMedicale(id, idPatient, idRdv, montantHT, tauxTVA, montantTTC, partAssurance, partPatient, statutPaiement);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
