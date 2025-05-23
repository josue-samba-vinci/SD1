import java.util.Scanner;

public class GestionBrocante {

	private static MonScanner scanner = new MonScanner("lancement.txt");
	private static Brocante brocante;

	public static void main(String[] args) {

		System.out.println("**********************");
		System.out.println("gestion d'une brocante");
		System.out.println("**********************");
		System.out.println();

		// configuration de la brocante
		System.out.println("Configuration de la brocante");
		System.out.println("----------------------------");
		System.out.print("Entrez le nombre d'emplacements : ");
		int nombreEmplacements = scanner.nextInt();
		System.out.print("Entrez le nombre de riverains : ");
		int nombreRiverains = scanner.nextInt();
		scanner.nextLine();
		String[] tableRiverains = new String[nombreRiverains];
		for (int i = 0; i < tableRiverains.length; i++) {
			System.out.print("Entrez le nom du riverain " + (i + 1) + " : ");
			String nomRiv  = scanner.nextLine();
			tableRiverains[i] = nomRiv;
		}
		brocante = new Brocante(nombreEmplacements, tableRiverains);
		System.out.println();
		// Phase 1
		System.out.println("Phase 1");
		System.out.println("-------");
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> reserver un emplacement");
			System.out.println("2 -> afficher la brocante");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
				case 1:
					reserverPhase1();
					break;
				case 2:
					afficherTout();
					break;
			}

		} while (choix >= 1 && choix <= 2);

		brocante.changerPhase();
		System.out.println();
		System.out.println();

		// Phase 2
		System.out.println("Phase 2");
		System.out.println("-------");
		choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> reserver un emplacement");
			System.out.println("2 -> afficher la brocante");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
				case 1:
					reserverPhase2();
					break;
				case 2:
					afficherTout();
					break;
			}

		} while (choix >= 1 && choix <= 2);

		System.out.println("Fin de la brocante!");
	}

	private static void reserverPhase1() {
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();

		System.out.print("Entrez l'email : ");
		String email = scanner.nextLine();
		Exposant exposant = new Exposant(nom,email);


		System.out.print("Entrez le numero de l'emplacement : ");
		int numero = scanner.nextInt();
		scanner.nextLine();
		//TODO
		try{
			if (brocante.reserver(exposant, numero))
				System.out.println("résa ok");
			else System.out.println("résa a échoué");
		}catch(IllegalArgumentException e){
			System.out.println("Le numero de l'emplacement n'existe pas !");
		}catch(IllegalStateException e) {
			System.out.println("Pas en phase 1 !");
		}catch(Exception e) {
			System.out.println("exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void reserverPhase2() {
		System.out.print("Entrez le nom : ");
		String nom = scanner.nextLine();

		System.out.print("Entrez l'email : ");
		String email = scanner.nextLine();
		Exposant exposant = new Exposant(nom,email);
		//TODO
		try{
			if (brocante.attribuerAutomatiquementEmplacement(exposant)!=0)
				System.out.println("résa ok");
			else System.out.println("résa a échoué");
		}catch(IllegalStateException e){
			System.out.println("Pas en phase 2");
		}catch(Exception e) {
			System.out.println("exception innatendue");
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void afficherTout() {
		System.out.println("Emplacements :") ;
		System.out.println("--------------") ;
		System.out.println() ;
		System.out.println(brocante) ;
		//System.out.println() ;
	}
}
