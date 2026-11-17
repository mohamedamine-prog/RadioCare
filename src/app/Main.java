package app;

import dao.PatientDAO;
import dao.ManipulateurRadioDAO;
import dao.RendezVousDAO;
import model.Patient;
import model.ManipulateurRadio;
import model.RendezVous;

public class Main {
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAO();
        ManipulateurRadioDAO manipDAO = new ManipulateurRadioDAO();
        RendezVousDAO rdvDAO = new RendezVousDAO();

        // on nettoie les fichiers pour repartir de zero a chaque test
        patientDAO.supprimer("09876543");
        manipDAO.supprimer("MAN01");
        rdvDAO.supprimer("RDV01");

        // ajouter
        Patient p = new Patient("09876543", "Ben Salah", "Ahmed", "2001-05-14",
                "22123456", "ahmed@mail.com", "ASS-1001", 0, false);
        patientDAO.ajouter(p);
        manipDAO.ajouter(new ManipulateurRadio("MAN01", "07654321", "Gharbi", "Nour", "IRM,SCANNER", 12.5, true));
        rdvDAO.ajouter(new RendezVous("RDV01", "2026-11-20", "09:30", 45,
                "09876543", "MED01", "MAN01", "S01", "EX01", "PLANIFIE"));

        // doublon refuse
        System.out.println("Ajout doublon : " + patientDAO.ajouter(p));

        // rechercher
        System.out.println("Trouve : " + patientDAO.rechercher("09876543").getNom());

        // modifier
        p.setSoldeCompte(150.0);
        patientDAO.modifier(p);
        System.out.println("Nouveau solde : " + patientDAO.rechercher("09876543").getSoldeCompte());

        // habilitations
        ManipulateurRadio m = manipDAO.rechercher("MAN01");
        System.out.println("IRM ? " + m.possedeHabilitation("IRM"));
        System.out.println("RAYONS_X ? " + m.possedeHabilitation("RAYONS_X"));

        // rendez-vous
        RendezVous r = rdvDAO.rechercher("RDV01");
        System.out.println("RDV le " + r.getDate() + " a " + r.getHeureDebut());

        // supprimer
        patientDAO.supprimer("09876543");
        System.out.println("Apres suppression : " + patientDAO.rechercher("09876543"));
        System.out.println("Nb patients : " + patientDAO.lireTout().length);
    }
}
