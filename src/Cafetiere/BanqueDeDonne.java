package Cafetiere;

import java.util.ArrayList;
import java.util.Arrays;


public class BanqueDeDonne {

	
	public static ArrayList<String> listeNoms = new ArrayList<>(Arrays.asList(
            "Gregoire", "Denise", "Alexandre", "Patrick-Robert",
            "Sylvie", "Elisabeth", "Frederic", "Bernard", "David",
            "David", "Madeleine", "Emile", "Nathalie", "Jereme ",
            "Victor", "Robert", "Thibaut", "Pauline", "Arthur",
            "Josephine", "Laurence", "Augustin", "Zacharie", "Aurore")) ;
	
	public static ArrayList<Tasse> listeTasses = new ArrayList<>(Arrays.asList(
            new Tasse(), new Tasse(), new Tasse(), new Tasse(),
            new Tasse(200F), new Tasse(250F), new Tasse(300F), new Tasse(350F),
            new Tasse(500F), new Tasse(1000F), new Tasse(2000f), new Tasse(4000F)
    )) ;
	
	public static ArrayList<Cafe> listeCommandes = new ArrayList<> (Arrays.asList(
			new Cafe(), new Cafe(), new Cafe(), new Cafe(), 
			new Cafe(TypeCafe.BOURBON, 100F), new Cafe(TypeCafe.BOURBON, 200F), new Cafe(TypeCafe.BOURBON, 400F), new Cafe(TypeCafe.BOURBON, 600F),
			new Cafe(TypeCafe.JAVA, 1000F), new Cafe(TypeCafe.JAVA, 2000F), new Cafe(TypeCafe.JAVA, 4100F), new Cafe(TypeCafe.JAVA, 1F),
			new Cafe(TypeCafe.BATARD, 100F), new Cafe(TypeCafe.BATARD, 100000F), new Cafe(TypeCafe.TYPICA, 100F), new Cafe(TypeCafe.MOKA, 100F)
			)) ;

}