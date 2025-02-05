// implementation d'une pile en utilisant un tableau de taille variable redimensionnable

import java.util.Arrays;

public class PileDeCaracteresImpl implements PileDeCaracteres{

	private char[] table; 			// ne modifiez pas cet identifiant, va servir pour les tests
	private int nombreCaracteres; 	// taille logique
								  	//ne mofifiez pas cet identifiant, va servir pour les tests

	
	public PileDeCaracteresImpl(){
		table = new char[4];
		nombreCaracteres = 0;
	}

	
	public PileDeCaracteresImpl(int capacite){
		if (capacite <= 0)
			throw new IllegalArgumentException("la taille physique ne peut etre negative ou nulle");
		table = new char[capacite];
		nombreCaracteres = 0;
	}

	
	public int taille(){
		return nombreCaracteres;
	}

	
	public boolean estVide(){
		return nombreCaracteres == 0;
	}

	/**
	 * renvoie le caractere qui se trouve au sommet de la pile sans l'enlever de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char sommet()throws PileVideException{
		// TODO
		if (nombreCaracteres == 0)
			throw new PileVideException();
		return table[nombreCaracteres-1];
	}

	/**
	 * renvoie le caractere qui se trouve au sommet de la pile et l'enleve de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char pop() throws PileVideException{
		return ' ';
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)

	}

	/**
	 * ajoute le caractere c sur la pile
	 * @param caractere le caractere a ajouter
	 */
	public void push(char c){
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)

	}

	//A NE PAS MODIFIER
	@Override
	public String toString() {
		if(table==null)
			return null;
		String s = "pile =";
		for (int i = 0; i < nombreCaracteres; i++) {
			s = s + " " + table[i];
		}
		return s;
	}

} 
