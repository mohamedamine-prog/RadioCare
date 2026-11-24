package view;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner sc = new Scanner(System.in);

    public void lancer() {
        String choix = "";
        while (!choix.equals("0")) {
            System.out.println();
            System.out.println("##### RADIOCARE - Centre de radiologie #####");
        System.out.println("1. Patients");
        System.out.println("2. Medecins radiologues");
        System.out.println("3. Manipulateurs radio");
        System.out.println("4. Equipements d'imagerie");
        System.out.println("5. Salles de radiologie");
        System.out.println("6. Examens medicaux");
        System.out.println("7. Rendez-vous");
        System.out.println("8. Comptes rendus");
        System.out.println("9. Factures");
        System.out.println("10. Paiements");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextLine().trim();

            if (choix.equals("1")) {
                new MenuPatient(sc).lancer();
            } else if (choix.equals("2")) {
                new MenuMedecinRadiologue(sc).lancer();
            } else if (choix.equals("3")) {
                new MenuManipulateurRadio(sc).lancer();
            } else if (choix.equals("4")) {
                new MenuEquipementImagerie(sc).lancer();
            } else if (choix.equals("5")) {
                new MenuSalleRadiologie(sc).lancer();
            } else if (choix.equals("6")) {
                new MenuExamenMedical(sc).lancer();
            } else if (choix.equals("7")) {
                new MenuRendezVous(sc).lancer();
            } else if (choix.equals("8")) {
                new MenuCompteRenduMedical(sc).lancer();
            } else if (choix.equals("9")) {
                new MenuFactureMedicale(sc).lancer();
            } else if (choix.equals("10")) {
                new MenuPaiement(sc).lancer();
            } else if (!choix.equals("0")) {
                System.out.println("Choix invalide.");
            }
        }
        System.out.println("Au revoir !");
    }
}
