package Cafetiere;

import java.util.ArrayList;
import java.util.Random;

public class MainExo3_2 {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant("Latte sur les rochers");
        Restaurant restaurant2 = new Restaurant("Une tasse de joie");
        Restaurant restaurant3 = new Restaurant();

        ArrayList<Client> listeClient1 = genererClientsAleatoires(20);
        ArrayList<Client> listeClient2 = genererClientsAleatoires(20);
        ArrayList<Client> listeClient3 = genererClientsAleatoires(20);

        ArrayList<Client> listeClientsExpulse = new ArrayList<>();

        System.out.println("Restaurant 1 : " + restaurant1.getNom());
        System.out.println("Restaurant 2 : " + restaurant2.getNom());
        System.out.println("Restaurant 3 : " + restaurant3.getNom());

        System.out.println("Liste des clients pour " + restaurant1.getNom() + " :");
        for (Client client : listeClient1) {
            System.out.println(client.nom);
        }

        System.out.println("Liste des clients pour " + restaurant2.getNom() + " :");
        for (Client client : listeClient2) {
            System.out.println(client.nom);
        }

        System.out.println("Liste des clients pour " + restaurant3.getNom() + " :");
        for (Client client : listeClient3) {
            System.out.println(client.nom);
        }
    }

    public static ArrayList<Client> genererClientsAleatoires(int nombreDeClients) {
        ArrayList<Client> listeClients = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < nombreDeClients; i++) {
            String nom = BanqueDeDonne.listeNoms.get(random.nextInt(BanqueDeDonne.listeNoms.size()));

            Cafe commandeCafe = BanqueDeDonne.listeCommandes.get(random.nextInt(BanqueDeDonne.listeCommandes.size()));

            Tasse tasse = random.nextBoolean() ? BanqueDeDonne.listeTasses.get(random.nextInt(BanqueDeDonne.listeTasses.size())) : null;

            Client client;
            if (tasse != null) {
                client = new Client(nom, commandeCafe, tasse);
            } else {
                client = new Client(nom, commandeCafe, false);
            }

            listeClients.add(client);
        }

        return listeClients;
    }
}