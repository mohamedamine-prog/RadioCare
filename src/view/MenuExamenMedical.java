package view;

import controller.ExamenMedicalController;
import model.ExamenMedical;

import java.util.Scanner;

public class MenuExamenMedical extends MenuCrud {

    private ExamenMedicalController controller = new ExamenMedicalController();

    public MenuExamenMedical(Scanner sc) {
        super("Examens medicaux",
                new String[] { "id", "codeActe", "libelle", "dureeEstimeeMinutes", "tarifHT", "necessiteContraste" },
                new String[] { "id", "codeActe", "libelle", "dureeEstimeeMinutes (nombre)", "tarifHT (nombre)", "necessiteContraste (true/false)" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(ExamenMedical o) {
        return new String[] { o.getId(), o.getCodeActe(), o.getLibelle(), String.valueOf(o.getDureeEstimeeMinutes()), String.valueOf(o.getTarifHT()), String.valueOf(o.isNecessiteContraste()) };
    }

    protected String[][] lireLignes() {
        ExamenMedical[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], v[2], Integer.parseInt(v[3].trim()), Double.parseDouble(v[4].trim()), Boolean.parseBoolean(v[5].trim()));
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], v[2], Integer.parseInt(v[3].trim()), Double.parseDouble(v[4].trim()), Boolean.parseBoolean(v[5].trim()));
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        ExamenMedical o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
