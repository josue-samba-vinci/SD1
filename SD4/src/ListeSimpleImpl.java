import java.util.Iterator;

/**
 * implementation de l'interface ListeSimple avec une liste simplement chainee
 */

public class ListeSimpleImpl<E> implements ListeSimple<E> {

    private Noeud tete;
    private int taille;
    //private int numVersion; //pour l'ex supplementaire


    public ListeSimpleImpl() {
        tete = null;
        taille = 0;
    }

    public int taille() {
        return taille;
    }

    public boolean estVide() {
        return taille == 0;
    }

    /**
     * renvoie l element de tete sans l enlever
     * @return l element de tete
     * @throws ListeVideException si la liste est vide
     */
    // renvoie l element contenu dans le noeud de tete
    public E premier() throws ListeVideException {
        // TODO
        if (taille==0)
            throw new ListeVideException();
        return tete.element;
    }

    /**
     * insere un nouvel element en tete de liste
     * @param element le nouvel element a inserer en tete
     */
    // insere un nouveau noeud en tete de liste avec l element
    public void insererEnTete(E element) {
        // TODO
        Noeud newTete = new Noeud(element, tete);
        tete = newTete;
        taille++;
    }

    /**
     * verifie la presence de l element passe en parametre dans la liste
     * @param element l element recherche
     * @return true si l element est present, false sinon
     */
    // verifie la presence d un noeud contenant l element passe en parametre
    public boolean contient(E element) {
        // TODO
        Noeud baladeur = tete;
        while (baladeur!= null) {
            if (baladeur.element.equals(element)) {
                return true;
            }
            baladeur = baladeur.suivant;
        }
        return false;
    }


    /**
     * insere le 2eme element passe en parametre apres la premiere occurrence du 1er element passe en parametre
     * @param element l element apres lequel un nouvel element doit etre insere
     * @param elementAInserer le nouvel element a inserer
     * @return true si le 1er element passe en parametre est present dans la liste, false sinon
     */
    // insere un nouveaud noeud apres le noeud contenant la premiere occurrence de l'element passe en parametre
    public boolean insererApres(E element, E elementAInserer) {
        // TODO
        //return false;
        Noeud baladeur = tete;
        Noeud elementApres = new Noeud(elementAInserer,null);
        while (baladeur != null){
            if (baladeur.element.equals(element)) {
                elementApres.suivant = baladeur.suivant;
                baladeur.suivant = elementApres;
                taille++;
                return true;
            }
            baladeur = baladeur.suivant;
        }
        return false;
    }


    //supprime le noeud contenant la premiere occurrence de l'element passe en parametre
    public boolean supprimer(E element) {
        // TODO
        //return false;
        Noeud baladeur = tete;
        if (tete == null)
            return false;
        if (tete.element.equals(element)){
            tete = baladeur.suivant;
            taille--;
            return true;
        }
        while (baladeur.suivant != null){
            if (baladeur.suivant.element.equals(element)){
                baladeur.suivant = baladeur.suivant.suivant;
                taille--;
                return true;
            }
            baladeur = baladeur.suivant;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new IterateurImpl();
    }


    private class IterateurImpl implements Iterator {

        private Noeud noeudNext;
        private int version;  // pour l'ex supplementaire


        // Au depart le noeud "next" est le noeud de tete
        private IterateurImpl() {
            noeudNext = tete;
            //version = numVersion;  // pour l'ex supplementaire
        }

        @Override
        // verifie si le noeud "next" est null
        //ICI IL FAUT COMPRENDRE QUE NEXT EST LA TETE ;
        public boolean hasNext() {
            // TODO
            //return false;
            if (noeudNext==null)
                return false;
            return true;
        }


        @Override
        // renvoie l element qui se trouve dans le noeud "next"
        // le noeud "next" passe au noeud suivant
        public E next() {
            // TODO
            // pensez a consulter la JAVADOC de la classe Iterator!!!
            //return null;
            Noeud next = noeudNext;
            if (hasNext()){
                noeudNext = noeudNext.suivant;
                return next.element;
            }
            return null;
        }
    }

    private class Noeud {
        private E element;
        private Noeud suivant;

        public Noeud(E element, Noeud suivant) {
            this.element = element;
            this.suivant = suivant;
        }
    }


    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String toString() {
        String aRenvoyer = "";
        Noeud baladeur = tete;
        int cpt = 0;
        while (baladeur != null) {
            cpt++;
            if (cpt > taille) {
                aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
                return aRenvoyer;
            }
            aRenvoyer += " " + baladeur.element;
            baladeur = baladeur.suivant;
        }
        return aRenvoyer;
    }


    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public ListeSimpleImpl(Object[] table) {
        if (table == null)
            throw new IllegalArgumentException();
        this.taille = table.length;
        for (int i = table.length - 1; i >= 0; i--) {
            E element = (E) table[i];
            this.tete = new Noeud(element, tete);
        }
    }

}
