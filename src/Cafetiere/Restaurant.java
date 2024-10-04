package Cafetiere;

import java.util.ArrayList;

public class Restaurant {
    Cafetiere cafetiere;
    Float profit;
    ArrayList<Client> listeClientServi;
    String nom;

    public Restaurant() {
        this.nom = "Le Restaurant";
        this.cafetiere = new Cafetiere();
        this.profit = 0.0f;
        this.listeClientServi = new ArrayList<>();
    }

    public Restaurant(String nom) {
        this.nom = nom;
        this.cafetiere = new Cafetiere();
        this.profit = 0.0f;
        this.listeClientServi = new ArrayList<>();
    }

    public Float servir(Client client) {
        if (client.commandeCafe == null) {
            return jetter(client);
        }
        if (client.tasse == null) {
            if (client.commandeCafe.quantiteLiquideMl > 100F) {
                client.tasse = new Tasse(500F);
                client.valeurFacture = 3F;
            } else {
                client.tasse = new Tasse();
                client.valeurFacture = 2F;
            }
        }
        if (client.commandeCafe.typeCafe == TypeCafe.BATARD) {
            return jetter(client);
        }

        client.valeurFacture += prix(client.commandeCafe.typeCafe, client.commandeCafe.quantiteLiquideMl);
        this.profit = this.profit + client.valeurFacture;

        if (client.tasse.quantiteCafeMax < client.commandeCafe.quantiteLiquideMl) {
            cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, client.tasse.quantiteCafeMax);
        } else {
            cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, client.commandeCafe.quantiteLiquideMl);
        }

        this.listeClientServi.add(client);

        return client.valeurFacture;
    }

    public Float jetter(Client client) {
        client.valeurFacture = 0F;
        System.out.println("Le client " + client.nom + " a été jeté hors du resto");
        return client.valeurFacture;
    }

    public Float prix(TypeCafe typeCafe, Float quantiteLiquideMl) {
        return switch (typeCafe) {
            case JAVA -> (float) TypeCafe.JAVA.getCoutParMl() * quantiteLiquideMl;
            case MOKA -> (float) TypeCafe.MOKA.getCoutParMl() * quantiteLiquideMl;
            case TYPICA -> (float) TypeCafe.TYPICA.getCoutParMl() * quantiteLiquideMl;
            case BOURBON -> (float) TypeCafe.BOURBON.getCoutParMl() * quantiteLiquideMl;
            case BATARD -> (float) TypeCafe.BATARD.getCoutParMl() * quantiteLiquideMl;
        };
    }

    public ArrayList<Client> getListeClientServi() {
        return listeClientServi;
    }

    public String getNom() {
        return nom;
    }
}