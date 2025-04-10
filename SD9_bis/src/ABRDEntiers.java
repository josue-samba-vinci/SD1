import java.util.ArrayList;

public class ABRDEntiers {

	private NoeudEntier racine;
	//	private int taille = 0; 	// cfr DEFI

	public ABRDEntiers () {
		racine = null ;
	}

	public int taille() {
		// ATTENTION! cette methode est en O(N)
		// cfr DEFI
		return taille(racine);
	}

	private int taille(NoeudEntier n) {
		if (n == null)
			return 0;
		return 1 + taille(n.gauche) + taille(n.droit);
	}

	public boolean estVide() {
		return racine == null;
	}



	/**
	 * insere un entier dans l'ABR
	 * Les doublons sont acceptes (cfr enonce)
	 * @param entier l'entier a inserer
	 */
	public void insere(int entier) {
		//TODO
		racine = insere(racine, entier);
	}

	private NoeudEntier insere(NoeudEntier noeud, int entier){

		if (noeud == null){
			return new NoeudEntier(entier);
		}
		if (entier >= noeud.entier) {
			noeud.droit = insere(noeud.droit, entier);
			return noeud;
		}
		noeud.gauche = insere(noeud.gauche, entier);
		return noeud;
	}


	/**
	 * verifie la presence d'un entier dans l'ABR
	 * @param entier l'entier recherche
	 * @return true si l'entier est present, false sinon
	 */
	public boolean contient(int entier) {
		//TODO
		return contient(racine, entier);
	}

	private boolean contient(NoeudEntier noeud, int entier){
		if(noeud == null)
			return false;
		if(noeud.entier == entier)
			return true;
		if(entier >= noeud.entier)
			return contient(noeud.droit, entier);
		return contient(noeud.gauche, entier);
	}

	/**
	 * renvoie, sans le supprimer, le plus petit entier contenu dans l'ABR
	 * @return le min
	 * @throws ArbreVideException si l'arbre est vide
	 */
	public int min() throws ArbreVideException{
		//TODO
		// Cette methode peut etre ecrite de facon iterative
		// Ou se trouve le plus petit entier dans l'arbre ?
		// Reflechissez !
		return min(racine);
	}

	private int min(NoeudEntier noeud){
		int min = 0;
		if (noeud == null)
			throw new ArbreVideException();
		if (noeud.gauche != null)
			return min(noeud.gauche);
		if (noeud.gauche == null)
			min = noeud.entier;
		return min;
	}

	/**
	 * supprime le plus petit entier contenu dans l'ABR
	 * @throws ArbreVideException si l'arbre est vide
	 */
	public void supprimeMin() throws ArbreVideException {
		//TODO
		if (racine == null) {
			throw new ArbreVideException();
		}
		racine = supprimeMin(racine);
	}

	private NoeudEntier supprimeMin(NoeudEntier noeud) {

		if (noeud.gauche == null) {
			// REMPLACE LE NOEUD PAR LA RACINE DE SON NOEUD DROIT
			//Le return contenu dans NOEUD.GAUCHE permet de remonter les changements dans l'arbre, comme si chaque personne disait à son parent :
			//"Voici ma nouvelle branche familiale après avoir fait les modifications."
			//Si l'enfant supprime quelqu'un et dit : "Voici mon nouveau sous-arbre", alors le parent met à jour son lien avec ce sous-arbre.
			return noeud.droit;
		}
		// Continue la recherche récursive à gauche
		//Capture le résultat de la suppression
		//
		//Met à jour le lien parent-enfant
		//
		//Garantit que tous les ancêtres voient le changement
		noeud.gauche = supprimeMin(noeud.gauche);
		return noeud;
	}
	//La récursion agit comme une vague qui :
	//
	//Descend jusqu'au minimum 🌊
	//
	//Remonte en réparant les liens un par un
			// La methode supprimeMin() est plus simple que la methode supprime()
			// Le noeud qui contient le plus petit entier n'a pas de fils gauche
			// Reflechissez !


	/**
	 * renvoie la hauteur de l'arbre
	 * @return la hauteur de l'arbre ou -1 si l'arbre est vide
	 */
	public int hauteur() {
		//TODO
		// Ex C
		if (estVide())
			return -1;
		return hauteur(racine);

	}

	private int hauteur(NoeudEntier noeud){
		//if (noeud.droit!=null)
		//	return 1+hauteur(noeud.droit)+hauteur(noeud.gauche);
		//if (noeud.gauche!=null)
		//	return 1+hauteur(noeud.droit)+hauteur(noeud.gauche);
		//return
		if (noeud == null)
			return -1;
		int hauteurGauche = hauteur(noeud.gauche);
		int hauteurDroit = hauteur(noeud.droit);
		if (hauteurGauche > hauteurDroit) {
			return 1 + hauteurGauche;
		} else {
			return 1 + hauteurDroit;
		}
	}

	/**
	 * supprime une fois l'entier de l'ABR
	 * @param entier l'entier a supprimer
	 */
	public boolean supprime(int entier) {
		//TODO
		// DEFI!!!!!!!!!!!!!!
		return false;

	}

	/**
	 * construit une table triee par ordre croissant contenant les entiers de l'ABR
	 * @return la table construite
	 */
	public int[] toArray() {
		//TODO
		// DEFI !!!!!!!!!!!
		return null;

	}

	private void toArrayInterne(NoeudEntier n, int[] t, int indiceDebut) {
		//TODO
		// DEFI!!!
	}

	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS!!!
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ABRDEntiers a = (ABRDEntiers)obj;
		return this.equals(a);
	}

	public boolean equals(ABRDEntiers a) {
		return equals(racine, a.racine);
	}

	private boolean equals(NoeudEntier n1, NoeudEntier n2){
		if(n1==null && n2==null)
			return true;
		if(n1==null || n2==null)
			return false;
		if(n1.entier!=n2.entier)
			return false;
		return equals(n1.gauche,n2.gauche) && equals(n1.droit,n2.droit);
	}

	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS!!!
	public String toString() {
		return toString(racine);
	}

	private String toString(NoeudEntier n) {
		if (n==null)
			return "";
		if (n.gauche == null && n.droit == null)
			return ""+n.entier;
		if (n.gauche == null)
			return ""+n.entier+" "+toString(n.droit);
		if (n.droit == null)
			return toString(n.gauche)+" "+n.entier;
		return toString(n.gauche)+" "+n.entier+" "+toString(n.droit);
	}


	/**********************************************
	 * Debut du toString de Loic LeCharlier
	 **********************************************/
	public String toStringLoic() {
		String arbre = "\n" ;
		if (racine!=null) {
			ArrayList<ArrayList<Object>> niveaux = niveau() ;
			int nbNiveaux = niveaux.size()-1;
			int nbBlanc = (int) Math.pow(2, nbNiveaux)-1 ;
			arbre = arbre  + this.addBlanc(nbBlanc) + racine.entier +'\n';
			for (int i=2 ; i<=nbNiveaux ;i++) {
				ArrayList<Object> niv = niveaux.get(i) ;
				int nbNoeuds = niv.size() ;
				int nbBlancInt = 1 ;
				int nbBlancExt = (int) Math.pow(2, nbNiveaux-i+3)-3 ;
				int nbLignes = (int) Math.pow(2, nbNiveaux-i+1)-1 ;
				for (int k=0 ; k<nbLignes ; k++) {
					nbBlanc-- ;
					arbre = arbre + addBlanc(nbBlanc);
					for (int j=0 ; j<nbNoeuds/2 ; j++) {
						if (niveaux.get(i-1).get(j) instanceof String) {
							arbre = arbre + " " + addBlanc(nbBlancInt) + " " ;
						} else {
							if (niv.get(2*j) instanceof String) {
								arbre = arbre + " " ;
							} else {
								arbre = arbre + "/" ;
							}
							arbre = arbre + addBlanc(nbBlancInt) ;
							if (niv.get(2*j+1) instanceof String) {
								arbre = arbre + " " ;
							} else {
								arbre = arbre + "\\" ;
							}
						}
						arbre = arbre + addBlanc(nbBlancExt) ;	
					}
					arbre = arbre + '\n' ;
					nbBlancInt+=2 ;
					nbBlancExt-=2 ;
				}
				nbBlanc = (int) Math.pow(2, nbNiveaux-i+1)-1 ;
				arbre = arbre + addBlanc(nbBlanc-1) ;
				for (int j=0 ; j<nbNoeuds ; j++) {
					if (niv.get(j) instanceof String)
						arbre = arbre + "   " ;
					else
						arbre = arbre + format((int) niv.get(j)) ;
					if (j!=nbNoeuds-1)
						arbre = arbre + addBlanc((int) Math.pow(2, nbNiveaux-i+2)-3) ;
				}
				arbre = arbre + '\n' ;
			}
		}
		return arbre ;
	}

	private String addBlanc(int n) {
		String st = "" ;
		for (int i=0 ; i<n ; i++) {
			st = st + " " ;
		}
		return st ;
	}

	private String format(int nombre) {
		String st = ""+nombre ;
		if (st.length()==1)
			st = " "+st+" " ;
		else if (st.length()==2)
			st = " "+st ;
		return st ;
	}
	private ArrayList<ArrayList<Object>> niveau() {
		ArrayList<ArrayList<Object>> niveaux = new ArrayList<ArrayList<Object>>() ;
		niveaux.add(null) ;
		niveau(racine,1,niveaux) ;
		int nbNiveaux = niveaux.size() ;
		ArrayList<Object> liste = niveaux.get(nbNiveaux-1) ;
		int taille = liste.size();
		boolean vide = true ;
		int ni=0 ;
		while (ni<taille && vide) {
			vide = liste.get(ni) instanceof String ;
			ni++ ;
		}
		if (vide) {
			niveaux.remove(nbNiveaux-1) ;
		}
		nbNiveaux = niveaux.size() ;
		for (int i=3 ;i<nbNiveaux ; i++) {
			ArrayList<Object> listep = niveaux.get(i-1) ;
			liste = niveaux.get(i) ;
			int lo = listep.size();
			for (int j=0 ; j<lo ; j++) {
				if (listep.get(j) instanceof String) {
					liste.add(2*j,"null") ;
					liste.add(2*j,"null") ;
				}
			}
		}

		return niveaux ;
	}

	private void niveau(NoeudEntier noeud, int hauteur, ArrayList<ArrayList<Object>> niveaux) {
		if (niveaux.size()<=hauteur)
			niveaux.add(new ArrayList<Object>()) ;
		niveaux.get(hauteur).add(noeud.entier) ;
		if (noeud.gauche!=null) {
			niveau(noeud.gauche,hauteur+1,niveaux) ;
			if (noeud.droit==null) {
				if (niveaux.size()<=hauteur+1)
					niveaux.add(new ArrayList<Object>()) ;
				niveaux.get(hauteur+1).add("null") ;
			} else {
				niveau(noeud.droit,hauteur+1,niveaux) ;
			}
		} else if (noeud.droit !=null) {
			if (noeud.gauche==null) {
				if (niveaux.size()<=hauteur+1)
					niveaux.add(new ArrayList<Object>()) ;
				niveaux.get(hauteur+1).add("null") ;
			} 
			niveau(noeud.droit,hauteur+1,niveaux) ;
		} else {
			if (niveaux.size()<=hauteur+1)
				niveaux.add(new ArrayList<Object>()) ;
			niveaux.get(hauteur+1).add("null") ;
			niveaux.get(hauteur+1).add("null") ;
		}
	}

	/*************************************************
	 * Fin du toString de Loic LeCharlier
	 **********************************************/ 



	// classe interne
	public class NoeudEntier {

		private int entier; 
		private NoeudEntier gauche;
		private NoeudEntier droit;

		private NoeudEntier(int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}

		private NoeudEntier(NoeudEntier g, int entier, NoeudEntier d) {
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}

}
