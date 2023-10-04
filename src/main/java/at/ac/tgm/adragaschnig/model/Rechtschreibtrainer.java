package at.ac.tgm.adragaschnig.model;

import at.ac.tgm.adragaschnig.persistenz.JsonWorttrainer;
import at.ac.tgm.adragaschnig.persistenz.PersistenzArt;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//public static void main(String[] args) {
    //    new File("").exists()
    //    }
public class Rechtschreibtrainer {
    private List<WortEintrag> wortListe = new ArrayList<>();
    private String eingabe;

    PersistenzArt persA;
    public Rechtschreibtrainer() {
        wortListe.add(new WortEintrag("Katze", "https://cdn-icons-png.flaticon.com/256/2138/2138218.png"));
        wortListe.add(new WortEintrag("Hund", "https://m.media-amazon.com/images/I/71qR6bjX7wL._UC256,256_CACC,256,256_.jpg"));
        persA = new JsonWorttrainer();
    }
    public void anzeige() throws MalformedURLException {
        boolean wert = true;
        int[] statistik = persA.statistik();
        while(wert) {
            int rN = (int) (Math.random() * wortListe.size());
            URL imageUrl = new URL(wortListe.get(rN).getUrl());
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            String statisticText = "Richtig: " + statistik[0] + "\nFalsch: " + statistik[1];
            JTextField inputField = new JTextField();
            Object[] components = {imageIcon, statisticText, "Eingabe:", inputField};
            int result = JOptionPane.showConfirmDialog(null, components, "Eingabeaufforderung", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                 this.eingabe = inputField.getText();
            }
            while (!this.eingabe.equals(wortListe.get(rN).getWort())) {
                imageUrl = new URL(wortListe.get(rN).getUrl());
                imageIcon = new ImageIcon(imageUrl);
                JOptionPane.showMessageDialog(null,"FALSCH");
                statistik[1]++;
                this.persA.speichern(statistik[0],statistik[1]);
                statisticText = "Richtig: " + statistik[0] + "\nFalsch: " + statistik[1];
                Object[] components2 = {imageIcon, statisticText, "Eingabe:", inputField};
                result = JOptionPane.showConfirmDialog(null, components2, "Eingabeaufforderung", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    this.eingabe = inputField.getText();
                }
            }
            statistik[0]++;
        }

    }
    public int s(){
        return wortListe.size();
    }

}
