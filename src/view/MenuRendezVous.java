package view;

import controller.RendezVousController;
import model.RendezVous;

import java.util.Scanner;

public class MenuRendezVous extends MenuCrud {

    private RendezVousController controller = new RendezVousController();

    public MenuRendezVous(Scanner sc) {
        super("Rendez-vous",
                new String[] { "id", "date", "heureDebut", "dureeMinutes", "idPatient", "idMedecin", "idManip", "idSalle", "idExamen", "statut" },
                new String[] { "id", "date (AAAA-MM-JJ)", "heureDebut (HH:MM)", "dureeMinutes (nombre)", "idPatient", "idMedecin", "idManip", "idSalle", "idExamen", "statut" },
                sc);
    }

    // objet -> texte (affichage)
    private String[] versTexte(RendezVous o) {
        return new String[] { o.getId(), o.getDate(), o.getHeureDebut(), String.valueOf(o.getDureeMinutes()), o.getIdPatient(), o.getIdMedecin(), o.getIdManip(), o.getIdSalle(), o.getIdExamen(), o.getStatut() };
    }

    protected String[][] lireLignes() {
        RendezVous[] tab = controller.lireTout();
        String[][] lignes = new String[tab.length][];
        for (int i = 0; i < tab.length; i++) {
            lignes[i] = versTexte(tab[i]);
        }
        return lignes;
    }

    // texte saisi -> valeurs typees, envoyees au controleur
    protected boolean ajouter(String[] v) {
        return accepte(controller.ajouter(v[0], v[1], v[2], Integer.parseInt(v[3].trim()), v[4], v[5], v[6], v[7], v[8], v[9]));
    }

    protected boolean modifier(String[] v) {
        return accepte(controller.modifier(v[0], v[1], v[2], Integer.parseInt(v[3].trim()), v[4], v[5], v[6], v[7], v[8], v[9]));
    }

    // true si aucun probleme ; sinon on prepare le message avec tous les conflits
    private boolean accepte(String[] problemes) {
        if (problemes.length == 0) {
            return true;
        }
        String texte = "rendez-vous refuse :";
        for (int i = 0; i < problemes.length; i++) {
            texte = texte + "\n   - " + problemes[i];
        }
        detailErreur = texte;
        return false;
    }

    protected boolean supprimer(String id) {
        return controller.supprimer(id);
    }

    protected String[] chercher(String id) {
        RendezVous o = controller.rechercher(id);
        if (o == null) {
            return null;
        }
        return versTexte(o);
    }
}
