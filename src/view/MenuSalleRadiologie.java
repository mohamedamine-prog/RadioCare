package view;

import controller.SalleRadiologieController;
import model.SalleRadiologie;

import java.util.Scanner;

public class MenuSalleRadiologie extends MenuCrud {

    private SalleRadiologieController controller = new SalleRadiologieController();

    public MenuSalleRadiologie(Scanner sc) {
        super("Salles de radiologie",
                new String[] { "id", "nom", "numeroEtage", "typeSalle", "equipementAttribueId", "normeBlindagePlomb", "statutDispo" },
                new String[] { "id", "nom", "numeroEtage (nombre)", "typeSalle", "equipementAttribueId", "normeBlindagePlomb", "statutDispo (true/false)" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(SalleRadiologie o) {
        return new String[] { o.getId(), o.getNom(), String.valueOf(o.getNumeroEtage()), o.getTypeSalle(), o.getEquipementAttribueId(), o.getNormeBlindagePlomb(), String.valueOf(o.isStatutDispo()) };
    }

    protected String[][] lireLignes() {
        SalleRadiologie[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], Integer.parseInt(v[2].trim()), v[3], v[4], v[5], Boolean.parseBoolean(v[6].trim()));
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], Integer.parseInt(v[2].trim()), v[3], v[4], v[5], Boolean.parseBoolean(v[6].trim()));
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        SalleRadiologie o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
