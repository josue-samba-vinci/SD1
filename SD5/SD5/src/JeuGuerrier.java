
public class JeuGuerrier {
	
	public static void main(String[] args) {
		EquipeGuerriers equipe = new EquipeGuerriers(3, 10);
		int pointsDeVieDuMal = 30;

		// A COMPLETER
		int nombreGuerriersRestants = equipe.nombreGuerriersEnVie();
		while (pointsDeVieDuMal > 0 && nombreGuerriersRestants > 0) {
			System.out.println("L'equipe compte guerriers en vie");
			int PVPerdusGuerrier = lancerDe();
			Guerrier guerrier = equipe.jouer(PVPerdusGuerrier);
			System.out.println("Suite au combat entre la creature du mal et le guerrier n" + guerrier.getNumero());
			System.out.println("Le guerrier vient de perdre " + PVPerdusGuerrier + " points de vie");
			int PVGuerrier = guerrier.getPointsDeVie();
			if (PVGuerrier < 1)
				System.out.println("Le guerrier est mort");
			else
				System.out.println("Il lui reste " + PVGuerrier + " points de vie");
			int PVPerdusMal = lancerDe();
			pointsDeVieDuMal -= PVPerdusMal;
			System.out.println("La creature du mal vient de perdre " + PVPerdusMal + " points de vie");
			if (pointsDeVieDuMal < 1)
				System.out.println("La creature du mal est morte");
			else
				System.out.println("Il lui reste " + pointsDeVieDuMal + " points de vie");
		}
		if (equipe.nombreGuerriersEnVie() == 0) ;
		System.out.println("Tous les guerriers sont morts");

	}
		
//		System.out.println("L'equipe compte guerriers en vie");
//		System.out.println("Suite au combat entre la creature du mal et le guerrier n�");
//		System.out.println("Le guerrier vient de perdre points de vie");
//		System.out.println("La creature du mal vient de perdre points de vie");
//		System.out.println("Il lui reste points de vie");
//		System.out.println("Le guerrier est mort");
//		System.out.println("La creature du mal est morte");
//		System.out.println("Tous les guerriers sont morts");

	
	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}
	
}
