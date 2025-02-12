// implementation de l'interface File via une table circulaire

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner
	

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}

	public int taille(){
		return taille;
	}

	public boolean estVide(){
		return taille == 0;
	}


	public E premier()throws FileVideException{
		if(taille==0)
			throw new FileVideException();
		return (E)table[indiceTete];
	}

	/**
	 * renvoie l'element qui se trouve en tete de file et l'enleve de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E defile() throws FileVideException{
		//return null;
		//TODO
		if (taille==0)
			throw new FileVideException();
		Object oldTete = table[indiceTete];
		taille--;
		indiceTete++;
		if (indiceTete>=table.length)
			indiceTete=0;
		return (E) oldTete;
	}

	/**
	 * ajoute un element en fin de file (queue)
	 * @param element l'element a ajouter
	 */
	public void enfile(E element){
		//TODO
		if (taille==table.length){
			Object[] newTable = new Object[table.length*2];
			for (int i = 0; i < taille; i++) {
				newTable[i]=table[indiceTete];
				indiceTete++;
				if (indiceTete>= table.length)
					indiceTete=0;
			}
			table=newTable;
			}
		table[(taille+indiceTete)% table.length]=element;
		taille++;
	}

}
