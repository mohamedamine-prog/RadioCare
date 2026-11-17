package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.ManipulateurRadio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipulateurRadioDAO {

    private String fichier = "data/manipulateurs.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // lit le fichier JSON et renvoie un tableau (vide si le fichier n'existe pas)
    public ManipulateurRadio[] lireTout() {
        File f = new File(fichier);
        if (!f.exists()) {
            return new ManipulateurRadio[0];
        }
        try {
            FileReader fr = new FileReader(f);
            ManipulateurRadio[] tab = gson.fromJson(fr, ManipulateurRadio[].class);
            fr.close();
            if (tab == null) {
                return new ManipulateurRadio[0];
            }
            return tab;
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + fichier);
            return new ManipulateurRadio[0];
        }
    }

    // ecrit tout le tableau dans le fichier JSON
    private void sauvegarder(ManipulateurRadio[] tab) {
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
    public boolean ajouter(ManipulateurRadio obj) {
        ManipulateurRadio[] tab = lireTout();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getId().equals(obj.getId())) {
                return false;
            }
        }
        ManipulateurRadio[] nouveau = new ManipulateurRadio[tab.length + 1];
        for (int i = 0; i < tab.length; i++) {
            nouveau[i] = tab[i];
        }
        nouveau[tab.length] = obj;
        sauvegarder(nouveau);
        return true;
    }

    // renvoie false si l'id n'existe pas
    public boolean modifier(ManipulateurRadio obj) {
        ManipulateurRadio[] tab = lireTout();
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
        ManipulateurRadio[] tab = lireTout();
        int position = -1;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getId().equals(id)) {
                position = i;
            }
        }
        if (position == -1) {
            return false;
        }
        ManipulateurRadio[] nouveau = new ManipulateurRadio[tab.length - 1];
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
    public ManipulateurRadio rechercher(String id) {
        ManipulateurRadio[] tab = lireTout();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].getId().equals(id)) {
                return tab[i];
            }
        }
        return null;
    }
}
