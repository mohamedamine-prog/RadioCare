package controller;

import dao.PatientDAO;
import model.Patient;

// Le controleur recoit les valeurs deja converties par la vue, construit l'objet
// et coordonne l'appel au DAO. La vue ne connait plus le DAO.
public class PatientController {

    private PatientDAO dao = new PatientDAO();

    public Patient[] lireTout() {
        return dao.lireTout();
    }

    public Patient rechercher(String id) {
        return dao.rechercher(id);
    }

    public boolean ajouter(String id, String nom, String prenom, String dateNaissance, String telephone, String email, String numAssurance, double soldeCompte, boolean contreIndication) {
        Patient obj = new Patient(id, nom, prenom, dateNaissance, telephone, email, numAssurance, soldeCompte, contreIndication);
        return dao.ajouter(obj);
    }

    public boolean modifier(String id, String nom, String prenom, String dateNaissance, String telephone, String email, String numAssurance, double soldeCompte, boolean contreIndication) {
        Patient obj = new Patient(id, nom, prenom, dateNaissance, telephone, email, numAssurance, soldeCompte, contreIndication);
        return dao.modifier(obj);
    }

    public boolean supprimer(String id) {
        return dao.supprimer(id);
    }
}
