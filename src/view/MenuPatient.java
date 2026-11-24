package view;

import controller.PatientController;
import model.Patient;

import java.util.Scanner;

public class MenuPatient extends MenuCrud {

    private PatientController controller = new PatientController();

    public MenuPatient(Scanner sc) {
        super("Patients",
                new String[] { "id", "nom", "prenom", "dateNaissance", "telephone", "email", "numAssurance", "soldeCompte", "contreIndication" },
                new String[] { "id", "nom", "prenom", "dateNaissance (AAAA-MM-JJ)", "telephone", "email", "numAssurance", "soldeCompte (nombre)", "contreIndication (true/false)" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(Patient o) {
        return new String[] { o.getId(), o.getNom(), o.getPrenom(), o.getDateNaissance(), o.getTelephone(), o.getEmail(), o.getNumAssurance(), String.valueOf(o.getSoldeCompte()), String.valueOf(o.isContreIndication()) };
    }

    protected String[][] lireLignes() {
        Patient[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], v[2], v[3], v[4], v[5], v[6], Double.parseDouble(v[7].trim()), Boolean.parseBoolean(v[8].trim()));
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], v[2], v[3], v[4], v[5], v[6], Double.parseDouble(v[7].trim()), Boolean.parseBoolean(v[8].trim()));
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        Patient o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
