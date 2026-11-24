package view;

import java.util.Scanner;

// Menu generique : lister / ajouter / rechercher / modifier / supprimer.
// Chaque entite en herite et definit seulement ses 5 methodes abstraites (qui appellent le controleur).
public abstract class MenuCrud {

    private String titre;
    private String[] noms;       // noms des attributs (pour l'affichage)
    private String[] invites;    // texte demande a l'utilisateur (avec le format attendu)
    private Scanner sc;
    protected String detailErreur = "";   // message affiche quand ajouter/modifier renvoie false

    // ---- a definir dans chaque sous-classe
    protected abstract String[][] lireLignes();
    protected abstract boolean ajouter(String[] valeurs);
    protected abstract boolean modifier(String[] valeurs);
    protected abstract boolean supprimer(String id);
    protected abstract String[] chercher(String id);   // null si introuvable

    public MenuCrud(String titre, String[] noms, String[] invites, Scanner sc) {
        this.titre = titre;
        this.noms = noms;
        this.invites = invites;
        this.sc = sc;
    }

    public void lancer() {
        String choix = "";
        while (!choix.equals("0")) {
            System.out.println();
            System.out.println("=== " + titre + " ===");
            System.out.println("1. Lister");
            System.out.println("2. Ajouter");
            System.out.println("3. Rechercher par id");
            System.out.println("4. Modifier");
            System.out.println("5. Supprimer");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");
            choix = sc.nextLine().trim();

            try {
                if (choix.equals("1")) {
                    lister();
                } else if (choix.equals("2")) {
                    ajouterUn();
                } else if (choix.equals("3")) {
                    rechercherUn();
                } else if (choix.equals("4")) {
                    modifierUn();
                } else if (choix.equals("5")) {
                    supprimerUn();
                } else if (!choix.equals("0")) {
                    System.out.println("Choix invalide.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur : un nombre est mal ecrit (ex : 12.5 avec un point). Rien n'a ete enregistre.");
            }
        }
    }

    private void lister() {
        String[][] lignes = lireLignes();
        if (lignes.length == 0) {
            System.out.println("(aucun element)");
            return;
        }
        System.out.println(lignes.length + " element(s) :");
        for (int i = 0; i < lignes.length; i++) {
            System.out.print((i + 1) + ") ");
            for (int j = 0; j < noms.length; j++) {
                System.out.print(noms[j] + "=" + lignes[i][j]);
                if (j < noms.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    private void ajouterUn() {
        String[] valeurs = new String[noms.length];
        for (int i = 0; i < noms.length; i++) {
            System.out.print(invites[i] + " : ");
            valeurs[i] = sc.nextLine();
        }
        detailErreur = "cet id existe deja.";
        if (valeurs[0].trim().equals("")) {
            System.out.println("Erreur : l'id est obligatoire.");
        } else if (ajouter(valeurs)) {
            System.out.println("Ajoute avec succes.");
        } else {
            System.out.println("Erreur : " + detailErreur);
        }
    }

    private void rechercherUn() {
        System.out.print("Id a rechercher : ");
        String id = sc.nextLine().trim();
        String[] trouve = chercher(id);
        if (trouve == null) {
            System.out.println("Aucun resultat pour l'id : " + id);
        } else {
            for (int i = 0; i < noms.length; i++) {
                System.out.println("  " + noms[i] + " : " + trouve[i]);
            }
        }
    }

    // on affiche la valeur actuelle entre crochets ; Entree = on garde l'ancienne valeur
    private void modifierUn() {
        System.out.print("Id a modifier : ");
        String id = sc.nextLine().trim();
        String[] actuel = chercher(id);
        if (actuel == null) {
            System.out.println("Aucun resultat pour l'id : " + id);
            return;
        }
        String[] valeurs = new String[noms.length];
        valeurs[0] = id;
        for (int i = 1; i < noms.length; i++) {
            System.out.print(invites[i] + " [" + actuel[i] + "] : ");
            String saisie = sc.nextLine();
            if (saisie.trim().equals("")) {
                valeurs[i] = actuel[i];
            } else {
                valeurs[i] = saisie;
            }
        }
        detailErreur = "id introuvable.";
        if (modifier(valeurs)) {
            System.out.println("Modifie avec succes.");
        } else {
            System.out.println("Erreur : " + detailErreur);
        }
    }

    private void supprimerUn() {
        System.out.print("Id a supprimer : ");
        String id = sc.nextLine().trim();
        if (chercher(id) == null) {
            System.out.println("Aucun resultat pour l'id : " + id);
            return;
        }
        System.out.print("Confirmer la suppression de " + id + " ? (o/n) : ");
        String reponse = sc.nextLine().trim();
        if (reponse.equalsIgnoreCase("o")) {
            supprimer(id);
            System.out.println("Supprime avec succes.");
        } else {
            System.out.println("Suppression annulee.");
        }
    }
}
