package service;

import model.RendezVous;

// Moteur de conflits : execute les 5 regles avant tout enregistrement de rendez-vous
public class ConflictEngine {

    private ConflictRule[] regles = new ConflictRule[5];

    public ConflictEngine() {
        regles[0] = new SalleEquipementConflict();   // conflit 1
        regles[1] = new AgendaConflict();            // conflit 2
        regles[2] = new QuotaHeuresConflict();       // conflit 3
        regles[3] = new HabilitationConflict();      // conflit 4
        regles[4] = new PatientBloqueConflict();     // conflit 5
    }

    // renvoie les messages de tous les conflits trouves (tableau vide = aucun conflit)
    public String[] verifier(RendezVous rdv) {
        // un rendez-vous annule ne bloque personne : pas de verification
        if (rdv.getStatut().equals("ANNULE")) {
            return new String[0];
        }
        String[] temp = new String[regles.length];
        int nb = 0;
        for (int i = 0; i < regles.length; i++) {
            String message = regles[i].verifier(rdv);
            if (message != null) {
                temp[nb] = message;
                nb++;
            }
        }
        String[] resultat = new String[nb];
        for (int i = 0; i < nb; i++) {
            resultat[i] = temp[i];
        }
        return resultat;
    }
}
