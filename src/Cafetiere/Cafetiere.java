package Cafetiere;

public class Cafetiere {
    public Cafetiere() {

    }

    public void remplirTasse(Tasse tasse) {
        tasse.cafe.typeCafe = TypeCafe.MOKA;
        tasse.cafe.quantiteLiquideMl = tasse.quantiteCafeMax;
    }

    public void remplirTasse(Tasse tasse, TypeCafe typeCafe, Float quantiteARemplir) {
        tasse.cafe.typeCafe = typeCafe;
        if (quantiteARemplir > tasse.quantiteCafeMax) {
            tasse.quantiteCafeMax = quantiteARemplir;
        }
        tasse.cafe.quantiteLiquideMl = quantiteARemplir;
    }
}
