package view;

import controller.MedecinRadiologueController;
import model.MedecinRadiologue;

import java.util.Scanner;

public class MenuMedecinRadiologue extends MenuCrud {

    private MedecinRadiologueController controller = new MedecinRadiologueController();

    public MenuMedecinRadiologue(Scanner sc) {
        super("Medecins radiologues",
                new String[] { "id", "cin", "nom", "prenom", "specialite", "tarifPourcentageActe" },
                new String[] { "id", "cin", "nom", "prenom", "specialite", "tarifPourcentageActe (nombre)" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(MedecinRadiologue o) {
        return new String[] { o.getId(), o.getCin(), o.getNom(), o.getPrenom(), o.getSpecialite(), String.valueOf(o.getTarifPourcentageActe()) };
    }

    protected String[][] lireLignes() {
        MedecinRadiologue[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], v[2], v[3], v[4], Double.parseDouble(v[5].trim()));
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], v[2], v[3], v[4], Double.parseDouble(v[5].trim()));
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        MedecinRadiologue o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
