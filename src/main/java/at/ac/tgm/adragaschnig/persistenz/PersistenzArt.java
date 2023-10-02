package at.ac.tgm.adragaschnig.persistenz;

public interface PersistenzArt {
    int[] statistik();
    void speichern(int richtig, int falsch);
}
