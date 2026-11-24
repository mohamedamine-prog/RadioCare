package app;

import dao.*;
import model.*;
import service.RendezVousService;

import java.io.File;

// Test des 5 conflits : lance avec  java -cp "out;lib\gson.jar" app.TestConflits
public class TestConflits {

    static void essai(String titre, String[] resultat) {
        System.out.println(titre);
        if (resultat.length == 0) {
            System.out.println("   -> ACCEPTE");
        }
        for (int i = 0; i < resultat.length; i++) {
            System.out.println("   -> " + resultat[i]);
        }
    }

    public static void main(String[] args) {
        String[] fichiers = { "patients", "medecins", "manipulateurs", "equipements", "salles",
                "examens", "rendezvous", "comptesrendus", "factures", "paiements" };
        for (int i = 0; i < fichiers.length; i++) {
            new File("data/" + fichiers[i] + ".json").delete();
        }

        // ---- donnees de depart
        new PatientDAO().ajouter(new Patient("P1", "Ben Salah", "Ahmed", "2001-05-14", "22", "a@m.com", "ASS1", 0, false));
        new PatientDAO().ajouter(new Patient("P2", "Mejri", "Sana", "1990-02-01", "55", "s@m.com", "", 0, true));
        new PatientDAO().ajouter(new Patient("P3", "Riahi", "Karim", "1985-03-03", "66", "k@m.com", "", 600, false));
        new MedecinRadiologueDAO().ajouter(new MedecinRadiologue("MED01", "01", "Trabelsi", "Sami", "NEURORADIOLOGIE", 0.30));
        new MedecinRadiologueDAO().ajouter(new MedecinRadiologue("MED02", "02", "Hamdi", "Leila", "OSTEO", 0.25));
        new ManipulateurRadioDAO().ajouter(new ManipulateurRadio("MAN01", "11", "Gharbi", "Nour", "IRM,SCANNER", 12.5, true));
        new ManipulateurRadioDAO().ajouter(new ManipulateurRadio("MAN02", "12", "Jlassi", "Omar", "RAYONS_X", 10, true));
        new ManipulateurRadioDAO().ajouter(new ManipulateurRadio("MAN03", "13", "Zouari", "Ines", "IRM", 11, true));
        new EquipementImagerieDAO().ajouter(new EquipementImagerie("EQ01", "IRM", "Siemens", 900, 1.5, "EN_SERVICE"));
        new EquipementImagerieDAO().ajouter(new EquipementImagerie("EQ02", "SCANNER_CT", "Philips", 100, 200, "EN_SERVICE"));
        new SalleRadiologieDAO().ajouter(new SalleRadiologie("S01", "Salle IRM 1", 1, "IRM", "EQ01", "2mm Pb", true));
        new SalleRadiologieDAO().ajouter(new SalleRadiologie("S02", "Salle Scanner", 1, "SCANNER", "EQ02", "2mm Pb", true));
        new SalleRadiologieDAO().ajouter(new SalleRadiologie("S03", "Salle IRM 2", 2, "IRM", "EQ01", "2mm Pb", true));
        new ExamenMedicalDAO().ajouter(new ExamenMedical("EX01", "IRM-C", "IRM Cerebrale", 45, 200, false));

        RendezVousService service = new RendezVousService();

        essai("RDV01  20/11 09:30 (45 min) S01 MED01 MAN01 P1  [tout est correct]",
                service.planifier(new RendezVous("RDV01", "2026-11-20", "09:30", 45, "P1", "MED01", "MAN01", "S01", "EX01", "")));

        essai("RDV02  20/11 09:45 meme salle S01  [conflit 1 : salle]",
                service.planifier(new RendezVous("RDV02", "2026-11-20", "09:45", 30, "P1", "MED02", "MAN03", "S01", "EX01", "")));

        essai("RDV03  20/11 09:45 salle S03 mais meme equipement EQ01  [conflit 1 : equipement]",
                service.planifier(new RendezVous("RDV03", "2026-11-20", "09:45", 30, "P1", "MED02", "MAN03", "S03", "EX01", "")));

        essai("RDV04  20/11 09:45 salle Scanner, mais MED01 et MAN01 deja pris  [conflit 2]",
                service.planifier(new RendezVous("RDV04", "2026-11-20", "09:45", 30, "P1", "MED01", "MAN01", "S02", "EX01", "")));

        essai("RDV05  21/11 120 min sur IRM (reste 90 min)  [conflit 3]",
                service.planifier(new RendezVous("RDV05", "2026-11-21", "10:00", 120, "P1", "MED01", "MAN01", "S01", "EX01", "")));

        essai("RDV06  22/11 Scanner avec MAN02 (sans habilitation)  [conflit 4]",
                service.planifier(new RendezVous("RDV06", "2026-11-22", "10:00", 30, "P1", "MED02", "MAN02", "S02", "EX01", "")));

        essai("RDV07  23/11 patient P2 contre-indique  [conflit 5]",
                service.planifier(new RendezVous("RDV07", "2026-11-23", "10:00", 30, "P2", "MED02", "MAN01", "S02", "EX01", "")));

        essai("RDV08  23/11 patient P3 avec dette de 600 DT  [conflit 5]",
                service.planifier(new RendezVous("RDV08", "2026-11-23", "11:00", 30, "P3", "MED02", "MAN01", "S02", "EX01", "")));

        essai("RDV09  24/11 P2 + MAN02 sur IRM  [conflits 4 et 5 ensemble]",
                service.planifier(new RendezVous("RDV09", "2026-11-24", "10:00", 30, "P2", "MED02", "MAN02", "S01", "EX01", "")));

        essai("RDV10  20/11 10:15 juste apres RDV01 (fin 10:15)  [pas de chevauchement]",
                service.planifier(new RendezVous("RDV10", "2026-11-20", "10:15", 30, "P1", "MED01", "MAN01", "S01", "EX01", "")));

        essai("Modifier RDV01 (45 -> 40 min)  [il ne se bloque pas lui-meme]",
                service.modifier(new RendezVous("RDV01", "2026-11-20", "09:30", 40, "P1", "MED01", "MAN01", "S01", "EX01", "PLANIFIE")));

        essai("Modifier RDV01 (40 -> 50 min)  [empiete sur RDV10 a 10:15 : refuse]",
                service.modifier(new RendezVous("RDV01", "2026-11-20", "09:30", 50, "P1", "MED01", "MAN01", "S01", "EX01", "PLANIFIE")));

        essai("Annuler RDV01",
                service.modifier(new RendezVous("RDV01", "2026-11-20", "09:30", 40, "P1", "MED01", "MAN01", "S01", "EX01", "ANNULE")));

        essai("RDV02 de nouveau  [RDV01 annule : la salle est libre]",
                service.planifier(new RendezVous("RDV02", "2026-11-20", "09:45", 30, "P1", "MED02", "MAN03", "S01", "EX01", "")));

        essai("RDV11  patient inexistant",
                service.planifier(new RendezVous("RDV11", "2026-11-25", "09:00", 30, "XXX", "MED01", "MAN01", "S01", "EX01", "")));
    }
}
