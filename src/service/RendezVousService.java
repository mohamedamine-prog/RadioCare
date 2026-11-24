package service;

import dao.ExamenMedicalDAO;
import dao.ManipulateurRadioDAO;
import dao.MedecinRadiologueDAO;
import dao.PatientDAO;
import dao.RendezVousDAO;
import dao.SalleRadiologieDAO;
import model.RendezVous;

public class RendezVousService {

    private RendezVousDAO rdvDAO = new RendezVousDAO();
    private PatientDAO patientDAO = new PatientDAO();
    private MedecinRadiologueDAO medecinDAO = new MedecinRadiologueDAO();
    private ManipulateurRadioDAO manipDAO = new ManipulateurRadioDAO();
    private SalleRadiologieDAO salleDAO = new SalleRadiologieDAO();
    private ExamenMedicalDAO examenDAO = new ExamenMedicalDAO();

    private ConflictEngine moteur = new ConflictEngine();

    // renvoie la liste des problemes : tableau vide = rendez-vous enregistre
    public String[] planifier(RendezVous rdv) {
        if (rdvDAO.rechercher(rdv.getId()) != null) {
            return new String[] { "Un rendez-vous avec l'id " + rdv.getId() + " existe deja" };
        }
        String[] problemes = verifier(rdv);
        if (problemes.length > 0) {
            return problemes;
        }
        if (rdv.getStatut().trim().equals("")) {
            rdv.setStatut("PLANIFIE");
        }
        rdvDAO.ajouter(rdv);
        return new String[0];
    }

    // la modification est verifiee comme une creation (le RDV ne se bloque pas lui-meme)
    public String[] modifier(RendezVous rdv) {
        if (rdvDAO.rechercher(rdv.getId()) == null) {
            return new String[] { "Rendez-vous introuvable : " + rdv.getId() };
        }
        String[] problemes = verifier(rdv);
        if (problemes.length > 0) {
            return problemes;
        }
        rdvDAO.modifier(rdv);
        return new String[0];
    }

    // 1) tous les elements references doivent exister, 2) puis on lance le moteur de conflits
    private String[] verifier(RendezVous rdv) {
        if (patientDAO.rechercher(rdv.getIdPatient()) == null) {
            return new String[] { "Patient introuvable : " + rdv.getIdPatient() };
        }
        if (medecinDAO.rechercher(rdv.getIdMedecin()) == null) {
            return new String[] { "Medecin introuvable : " + rdv.getIdMedecin() };
        }
        if (manipDAO.rechercher(rdv.getIdManip()) == null) {
            return new String[] { "Manipulateur introuvable : " + rdv.getIdManip() };
        }
        if (salleDAO.rechercher(rdv.getIdSalle()) == null) {
            return new String[] { "Salle introuvable : " + rdv.getIdSalle() };
        }
        if (examenDAO.rechercher(rdv.getIdExamen()) == null) {
            return new String[] { "Examen introuvable : " + rdv.getIdExamen() };
        }
        if (!rdv.getHeureDebut().matches("[0-9]{1,2}:[0-9]{2}")) {
            return new String[] { "Heure invalide (format HH:MM) : " + rdv.getHeureDebut() };
        }
        return moteur.verifier(rdv);
    }
}
