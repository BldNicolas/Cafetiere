package Cafetiere;

public class Tasse {
    Float quantiteCafeMax;
    Cafe cafe;

    public Tasse() {
        this.quantiteCafeMax = 100F;
        this.cafe = new Cafe();
    }

    public Tasse(Float quantiteCafeMax) {
        this.quantiteCafeMax = quantiteCafeMax;
    }

    public Double boire(Float quantiteCafeBu) {
        Float quantiteCafeRestant = this.cafe.quantiteLiquideMl - quantiteCafeBu;
        this.cafe.quantiteLiquideMl = quantiteCafeRestant;
        return quantiteCafeRestant.doubleValue();
    }

    public void boire() {
        this.cafe.quantiteLiquideMl = 0F;
    }
}
