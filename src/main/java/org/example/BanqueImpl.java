package org.example;

public class BanqueImpl implements Banque {
    private int fond;
    private final int fondMin;

    public BanqueImpl(int fond, int fondMin) {
        this.fond = fond;
        this.fondMin = fondMin;
    }

    public void crediter(int somme) {
        fond += somme;
    }

    public void debiter(int somme) {
        fond -= somme;
    }

    public boolean est_solvable() {
        return fond >= fondMin;
    }
}

