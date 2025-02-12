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


	public E defile() throws FileVideException{
		return null;
		//TODO

	}


	public void enfile(E element){
		//TODO

	}

}
