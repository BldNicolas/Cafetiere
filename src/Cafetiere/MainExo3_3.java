package Cafetiere;

import java.util.ArrayList;
import java.util.Random;

public class MainExo3_3 {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant("Quick");
        Restaurant restaurant2 = new Restaurant("Burger King");
        Restaurant restaurant3 = new Restaurant();

        ArrayList<Client> listeClient1 = genererClientsAleatoires(20);
        ArrayList<Client> listeClient2 = genererClientsAleatoires(20);
        ArrayList<Client> listeClient3 = genererClientsAleatoires(20);

        ArrayList<Client> listeClientsExpulse = new ArrayList<>();

        Restaurant[] restaurants = {restaurant1, restaurant2, restaurant3};

        servirClients(listeClient1, restaurants, listeClientsExpulse);
        servirClients(listeClient2, restaurants, listeClientsExpulse);
        servirClients(listeClient3, restaurants, listeClientsExpulse);

        afficherResultats(restaurants, listeClientsExpulse);
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

    public static void servirClients(ArrayList<Client> listeClients, Restaurant[] restaurants, ArrayList<Client> listeClientsExpulse) {
        Random random = new Random();

        for (Client client : listeClients) {
            Restaurant restaurant = restaurants[random.nextInt(restaurants.length)];

            Float facture = restaurant.servir(client);

            if (facture == 0) {
                listeClientsExpulse.add(client);
            }
        }
    }

    public static void afficherResultats(Restaurant[] restaurants, ArrayList<Client> listeClientsExpulse) {
        for (Restaurant restaurant : restaurants) {
            System.out.println("Nom du restaurant : " + restaurant.getNom());
            System.out.println("Profit total : " + restaurant.profit + "€");
            System.out.println("Nombre de clients servis : " + restaurant.getListeClientServi().size());
            System.out.println();
        }

        System.out.println("Nombre de clients expulsés : " + listeClientsExpulse.size());
        System.out.println("Liste des clients expulsés :");
        for (Client client : listeClientsExpulse) {
            System.out.println("- " + client.nom);
        }
        System.out.println();
    }
}