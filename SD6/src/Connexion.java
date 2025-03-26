public class Connexion {
   
	Ensemble<Login> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGIN
	
	public Connexion(){
		// A COMPLETER
		ensembleDesConnectes = new EnsembleTableBooleens<>(500);
	}

	public int nombreDeConnectes(){
		// A COMPLETER
		return ensembleDesConnectes.taille();
	}
	
	// ajoute le login s'il n'est pas encore connecte
	public boolean connecter(Login login){
		// A COMPLETER
		return ensembleDesConnectes.ajouter(login);

	}
	
	// retire le login s'il est connecte
	public boolean deconnecter(Login login){
		// A COMPLETER
		return ensembleDesConnectes.enlever(login);
	}

	public boolean estConnecte(Login login){
		// A COMPLETER
		return ensembleDesConnectes.contient(login);
	}
	
	

	
}

