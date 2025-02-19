public class FileImplChainee<E> implements File<E>{

	private Noeud tete;
	private Noeud queue;
	private int taille;

	public FileImplChainee(){
		tete=null;
		queue=null;
		taille=0;
	}

	public int taille(){
		return taille;
	}

	public boolean estVide(){
		return taille==0;
	}

	/**
	 * renvoie l'element qui se trouve en tete de file sans l'enlever de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E premier()throws FileVideException{
		//TODO
		//return null;
		if (taille == 0)
			throw new FileVideException();
		return tete.element;
	}

	/**
	 * renvoie l'element qui se trouve en tete de file et l'enleve de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E defile() throws FileVideException{
		//TODO
		//return null;
		if (taille == 0)
			throw new FileVideException();
		Noeud oldTete = tete;
		tete = tete.suivant;
		taille--;
		return oldTete.element;
	}

	/**
	 * ajoute un element en fin de file (queue)
	 * @param element l'element a ajouter
	 */
	public void enfile(E element){
		//TODO
		Noeud nouveauNoeud = new Noeud(element);
		if (estVide()){
			tete = nouveauNoeud;
			queue = nouveauNoeud;
		}else {
			queue.suivant = nouveauNoeud;
			queue = nouveauNoeud;
		}
		taille++;
	}



	


	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	// tete 'a' 'b' 'c' queue : ['a','b','c']
	public FileImplChainee(Object[] table) {
		if(table == null)
			throw new IllegalArgumentException();
		this.taille = table.length;

		if(taille==0)
			return;
		queue = new Noeud((E)table[table.length-1],null);
		Noeud noeud = queue;
		for (int i = table.length-2; i>=0;i--) {
			noeud = new Noeud((E)table[i],noeud);
		}
		this.tete=noeud;
	}

	// A ne pas modifier ! Methode utilisee pour les tests
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				return "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer+=" "+baladeur.element;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}

	// classe interne
	private class Noeud{
		private E element;
		private Noeud suivant;

		private Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
		
		private Noeud(E element){
			this.element = element;
			this.suivant = null;
		}

	}

} 



