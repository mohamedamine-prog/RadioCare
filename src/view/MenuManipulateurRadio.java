package view;

import controller.ManipulateurRadioController;
import model.ManipulateurRadio;

import java.util.Scanner;

public class MenuManipulateurRadio extends MenuCrud {

    private ManipulateurRadioController controller = new ManipulateurRadioController();

    public MenuManipulateurRadio(Scanner sc) {
        super("Manipulateurs radio",
                new String[] { "id", "cin", "nom", "prenom", "habilitations", "tarifHoraire", "disponible" },
                new String[] { "id", "cin", "nom", "prenom", "habilitations", "tarifHoraire (nombre)", "disponible (true/false)" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(ManipulateurRadio o) {
        return new String[] { o.getId(), o.getCin(), o.getNom(), o.getPrenom(), o.getHabilitations(), String.valueOf(o.getTarifHoraire()), String.valueOf(o.isDisponible()) };
    }

    protected String[][] lireLignes() {
        ManipulateurRadio[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], v[2], v[3], v[4], Double.parseDouble(v[5].trim()), Boolean.parseBoolean(v[6].trim()));
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], v[2], v[3], v[4], Double.parseDouble(v[5].trim()), Boolean.parseBoolean(v[6].trim()));
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        ManipulateurRadio o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
