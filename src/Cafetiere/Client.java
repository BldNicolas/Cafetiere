package Cafetiere;

public class Client {
    Tasse tasse;
    Cafe commandeCafe;
    String nom;
    Float valeurFacture;

    public Client (String nom, Cafe commandeCafe, Boolean haveTasse) {
        this.nom = nom;
        this.commandeCafe = commandeCafe;
        if (haveTasse) {
            this.tasse = new Tasse();
        } else {
            this.tasse = null;
        }
        this.valeurFacture = 0.0f;
    }

    public Client (String nom, Cafe commandeCafe, Tasse tasse) {
        this.nom = nom;
        this.commandeCafe = commandeCafe;
        this.tasse = tasse;
        this.valeurFacture = 0F;
    }

    public Client () {
        this.nom = "Jean";
        this.tasse = new Tasse();
        this.commandeCafe = null;
        this.valeurFacture = null;
    }
}