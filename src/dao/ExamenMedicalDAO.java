package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.ExamenMedical;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExamenMedicalDAO {

    private String fichier = "data/examens.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // lit le fichier JSON et renvoie un tableau (vide si le fichier n'existe pas)
    public ExamenMedical[] lireTout() {
        File f = new File(fichier);
        if (!f.exists()) {
            return new ExamenMedical[0];
        }
        try {
            FileReader fr = new FileReader(f);
            ExamenMedical[] tab = gson.fromJson(fr, ExamenMedical[].class);
            fr.close();
            if (tab == null) {
                return new ExamenMedical[0];
            }
            return tab;
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + fichier);
            return new ExamenMedical[0];
        }
    }

    // ecrit tout le tableau dans le fichier JSON
    private void sauvegarder(ExamenMedical[] tab) {
        try {
            new File("data").mkdirs();
            FileWriter fw = new FileWriter(fichier);
            gson.toJson(tab, fw);
            fw.close();
        } catch (IOException e) {
            System.out.println("Erreur d'ecriture : " + fichier);
        }
    }

    // renvoie false si l'id existe deja
    public boolean ajouter(ExamenMedical obj) {
        ExamenMedical[] tab = lireTout();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getId().equals(obj.getId())) {
                return false;
            }
        }
        ExamenMedical[] nouveau = new ExamenMedical[tab.length + 1];
        for (int i = 0; i < tab.length; i++) {
            nouveau[i] = tab[i];
        }
        nouveau[tab.length] = obj;
        sauvegarder(nouveau);
        return true;
    }

    // renvoie false si l'id n'existe pas
    public boolean modifier(ExamenMedical obj) {
        ExamenMedical[] tab = lireTout();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getId().equals(obj.getId())) {
                tab[i] = obj;
                sauvegarder(tab);
                return true;
            }
        }
        return false;
    }

    // renvoie false si l'id n'existe pas
    public boolean supprimer(String id) {
        ExamenMedical[] tab = lireTout();
        int position = -1;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getId().equals(id)) {
                position = i;
            }
        }
        if (position == -1) {
            return false;
        }
        ExamenMedical[] nouveau = new ExamenMedical[tab.length - 1];
        int j = 0;
        for (int i = 0; i < tab.length; i++) {
            if (i != position) {
                nouveau[j] = tab[i];
                j++;
            }
        }
        sauvegarder(nouveau);
        return true;
    }

    // renvoie null si l'id n'existe pas
    public ExamenMedical rechercher(String id) {
        ExamenMedical[] tab = lireTout();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getId().equals(id)) {
                return tab[i];
            }
        }
        return null;
    }
}
