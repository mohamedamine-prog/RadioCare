package service;

import dao.PatientDAO;
import model.Patient;
import model.RendezVous;

// Conflit 5 : contre-indication medicale majeure ou solde debiteur trop eleve
public class PatientBloqueConflict implements ConflictRule {

    private PatientDAO patientDAO = new PatientDAO();
    private double seuilDette = 500;   // en DT : au-dela, le RDV est refuse

    public String verifier(RendezVous rdv) {
        Patient patient = patientDAO.rechercher(rdv.getIdPatient());

        if (patient.isContreIndication()) {
            return "Conflit 5 : le patient " + patient.getId() + " a une contre-indication medicale majeure";
        }
        if (patient.getSoldeCompte() > seuilDette) {
            return "Conflit 5 : solde debiteur trop eleve (" + patient.getSoldeCompte()
                    + " DT, maximum " + seuilDette + " DT)";
        }
        return null;
    }
}
