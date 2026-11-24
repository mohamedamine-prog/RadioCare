package view;

import controller.FactureMedicaleController;
import model.FactureMedicale;

import java.util.Scanner;

public class MenuFactureMedicale extends MenuCrud {

    private FactureMedicaleController controller = new FactureMedicaleController();

    public MenuFactureMedicale(Scanner sc) {
        super("Factures",
                new String[] { "id", "idPatient", "idRdv", "montantHT", "tauxTVA", "montantTTC", "partAssurance", "partPatient", "statutPaiement" },
                new String[] { "id", "idPatient", "idRdv", "montantHT (nombre)", "tauxTVA (nombre)", "montantTTC (nombre)", "partAssurance (nombre)", "partPatient (nombre)", "statutPaiement" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(FactureMedicale o) {
        return new String[] { o.getId(), o.getIdPatient(), o.getIdRdv(), String.valueOf(o.getMontantHT()), String.valueOf(o.getTauxTVA()), String.valueOf(o.getMontantTTC()), String.valueOf(o.getPartAssurance()), String.valueOf(o.getPartPatient()), o.getStatutPaiement() };
    }

    protected String[][] lireLignes() {
        FactureMedicale[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return controller.ajouter(v[0], v[1], v[2], Double.parseDouble(v[3].trim()), Double.parseDouble(v[4].trim()), Double.parseDouble(v[5].trim()), Double.parseDouble(v[6].trim()), Double.parseDouble(v[7].trim()), v[8]);
    }

    protected boolean modifier(String[] v) {
        return controller.modifier(v[0], v[1], v[2], Double.parseDouble(v[3].trim()), Double.parseDouble(v[4].trim()), Double.parseDouble(v[5].trim()), Double.parseDouble(v[6].trim()), Double.parseDouble(v[7].trim()), v[8]);
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        FactureMedicale o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
