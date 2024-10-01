package Cafetiere;

public class Cafe {
    TypeCafe typeCafe;
    Float quantiteLiquideMl;

    public Cafe() {
        this.typeCafe = TypeCafe.MOKA;
        this.quantiteLiquideMl = 100F;
    }

    public Cafe(TypeCafe typeCafe, Float quantiteLiquideMl) {
        this.typeCafe = typeCafe;
        this.quantiteLiquideMl = quantiteLiquideMl;
    }
}
