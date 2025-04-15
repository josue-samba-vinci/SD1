import java.util.Comparator;
//NE PAS OUBLIER SINON ON NE PEUX PAS CREER COMPARE TO
public class Etudiant implements Comparable<Etudiant>{
	//NE PAS OUBLIER DE'AJOUTER LE IMPLEMENTS
	
	private int numeroMatricule;
	private String nom;
	private String prenom;
	
	
	public Etudiant(int numeroMatricule, String nom, String prenom) {
		super();
		this.numeroMatricule = numeroMatricule;
		this.nom = nom;
		this.prenom = prenom;
	}
	

	public int getNumeroMatricule() {
		return numeroMatricule;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	


	// A NE PAS MODIFIER : le numero de matricule est l'identifiant unique
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (numeroMatricule != other.numeroMatricule)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return numeroMatricule;
	}
	
	@Override
	public String toString() {
		return "Etudiant [numeroMatricule=" + numeroMatricule + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}

	//PERMETTRA DE SAVOIR QUI EST LE PLUS GRAND
	public int compareTo(Etudiant etudiant){
		return numeroMatricule - etudiant.numeroMatricule;
	}
	
	
}
