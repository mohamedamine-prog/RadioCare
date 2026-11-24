package service;

import model.RendezVous;

public interface ConflictRule {
    // renvoie null si tout va bien, sinon le message du conflit
    String verifier(RendezVous rdv);
}
