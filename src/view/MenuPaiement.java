package view;

import controller.PaiementController;
import model.Paiement;

import java.util.Scanner;

public class MenuPaiement extends MenuCrud {

    private PaiementController controller = new PaiementController();

    public MenuPaiement(Scanner sc) {
        super("Paiements",
                new String[] { "id", "numFacture", "datePaiement", "montantRecu", "modePaiement", "referenceTextuellePreuve" },
                new String[] { "id", "numFacture", "datePaiement (AAAA-MM-JJ)", "montantRecu (nombre)", "modePaiement", "referenceTextuellePreuve" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(Paiement o) {
        return new String[] { o.getId(), o.getNumFacture(), o.getDatePaiement(), String.valueOf(o.getMontantRecu()), o.getModePaiement(), o.getReferenceTextuellePreuve() };
    }

    protected String[][] lireLignes() {
        Paiement[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], v[2], Double.parseDouble(v[3].trim()), v[4], v[5]);
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], v[2], Double.parseDouble(v[3].trim()), v[4], v[5]);
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        Paiement o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
