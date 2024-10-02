package Cafetiere;

public class Cafetiere {
    public Cafetiere() {

    }

    public void remplirTasse(Tasse tasse) {
        tasse.cafe.typeCafe = TypeCafe.MOKA;
        tasse.cafe.quantiteLiquideMl = tasse.quantiteCafeMax;
    }

    public void remplirTasse(Tasse tasse, TypeCafe typeCafe, Float quantiteARemplir) {
        if (tasse.cafe != null && tasse.cafe.typeCafe != typeCafe) {
            tasse.cafe = new Cafe(TypeCafe.BATARD, tasse.cafe.quantiteLiquideMl + quantiteARemplir);
        } else {
            tasse.cafe = new Cafe(typeCafe, quantiteARemplir);
        }
    }
}
