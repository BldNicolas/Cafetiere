package Cafetiere;

public class MainExo3_1 {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant("Latte sur les rochers");
        Restaurant restaurant2 = new Restaurant("Une tasse de joie");
        Restaurant restaurant3 = new Restaurant();

        System.out.println("Restaurant 1 : " + restaurant1.getNom());
        System.out.println("Restaurant 2 : " + restaurant2.getNom());
        System.out.println("Restaurant 3 : " + restaurant3.getNom());
    }
}