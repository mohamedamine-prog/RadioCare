package view;

import controller.EquipementImagerieController;
import model.EquipementImagerie;

import java.util.Scanner;

public class MenuEquipementImagerie extends MenuCrud {

    private EquipementImagerieController controller = new EquipementImagerieController();

    public MenuEquipementImagerie(Scanner sc) {
        super("Equipements d'imagerie",
                new String[] { "id", "type", "marque", "heuresCumulees", "heuresRestantesMaintenance", "statut" },
                new String[] { "id", "type", "marque", "heuresCumulees (nombre)", "heuresRestantesMaintenance (nombre)", "statut" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(EquipementImagerie o) {
        return new String[] { o.getId(), o.getType(), o.getMarque(), String.valueOf(o.getHeuresCumulees()), String.valueOf(o.getHeuresRestantesMaintenance()), o.getStatut() };
    }

    protected String[][] lireLignes() {
        EquipementImagerie[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], v[2], Double.parseDouble(v[3].trim()), Double.parseDouble(v[4].trim()), v[5]);
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], v[2], Double.parseDouble(v[3].trim()), Double.parseDouble(v[4].trim()), v[5]);
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        EquipementImagerie o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
