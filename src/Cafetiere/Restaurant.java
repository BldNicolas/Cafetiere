package Cafetiere;

public class Restaurant {
    Cafetiere cafetiere;
    Float profit;

    public Restaurant() {
        this.cafetiere = new Cafetiere();
        this.profit = 0.0f;
    }

    public Float servir(Client client) {
        if (client.commandeCafe == null) {
            return jetter(client);
        }
        if (client.tasse == null){
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

        return client.valeurFacture;
    }

    public Float jetter(Client client) {
        client.valeurFacture = 0F;
        System.out.println("Le client " + client.nom + " a été jeté hors du resto");
        return client.valeurFacture;
    }

    public Float prix(TypeCafe typeCafe, Float quantiteLiquideMl) {
        Float prix = 0F;
        switch (typeCafe) {
            case JAVA:
                prix = (float) + TypeCafe.JAVA.getCoutParMl() * quantiteLiquideMl;
                break;
            case MOKA:
                prix = (float) + TypeCafe.MOKA.getCoutParMl() * quantiteLiquideMl;
                break;
            case TYPICA:
                prix = (float) + TypeCafe.TYPICA.getCoutParMl() * quantiteLiquideMl;
                break;
            case BOURBON:
                prix = (float) + TypeCafe.BOURBON.getCoutParMl() * quantiteLiquideMl;
                break;
            case BATARD:
                prix = (float) + TypeCafe.BATARD.getCoutParMl() * quantiteLiquideMl;
                break;
        }
        return prix;
    }
}
