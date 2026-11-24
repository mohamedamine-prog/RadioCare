package view;

import controller.CompteRenduMedicalController;
import model.CompteRenduMedical;

import java.util.Scanner;

public class MenuCompteRenduMedical extends MenuCrud {

    private CompteRenduMedicalController controller = new CompteRenduMedicalController();

    public MenuCompteRenduMedical(Scanner sc) {
        super("Comptes rendus",
                new String[] { "id", "idRdv", "date", "refOrdonnanceTextuelle", "transcriptionDiagnosticTextuel", "codeResultat" },
                new String[] { "id", "idRdv", "date (AAAA-MM-JJ)", "refOrdonnanceTextuelle", "transcriptionDiagnosticTextuel", "codeResultat" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(CompteRenduMedical o) {
        return new String[] { o.getId(), o.getIdRdv(), o.getDate(), o.getRefOrdonnanceTextuelle(), o.getTranscriptionDiagnosticTextuel(), o.getCodeResultat() };
    }

    protected String[][] lireLignes() {
        CompteRenduMedical[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], v[2], v[3], v[4], v[5]);
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], v[2], v[3], v[4], v[5]);
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        CompteRenduMedical o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
