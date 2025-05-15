import java.util.*;

public class Brocante {

    private int phase = 1;

    private Emplacement[] tableEmplacements;
    private HashMap<String, Integer> mapRiverains;
    private ArrayDeque<Emplacement> pileEmplacementsLibres;
    private HashMap<String,Exposant> mapExposants;



    //private String tableRiverains[] 
    //inutile, regardez bien les schemas, cette table n'apparait pas !


    public int getPhase() {
        return phase;
    }

    public Exposant getExposant(String nom){return mapExposants.get(nom);}

    public Collection tousLesExposants(){
        return mapExposants.values();}

    /**
     * initialise une brocante avec nombre emplacements
     * @param nombreEmplacements le nombre d'emplacements
     * @param tableRiverains la table des riverains
     * @throws IllegalArgumentException si le nombre d'emplacements est negatif ou nul ou si la table des riverains est null
     */
    public Brocante(int nombreEmplacements, String[] tableRiverains) {
        //TODO
        if (nombreEmplacements <=0 || tableRiverains.length==0)
            throw new IllegalArgumentException();
        tableEmplacements = new Emplacement[nombreEmplacements];
        mapRiverains = new HashMap<>();
        for (int i = 0; i < nombreEmplacements; i++) {
            tableEmplacements[i]= new Emplacement(i);
        }
        for(String riverain : tableRiverains){
            mapRiverains.put(riverain,0);
        }

    }

    public boolean isRiverain(String riverain){
        return mapRiverains.containsKey(riverain);
    }

    public int nombreEmplacement(Exposant demandeur) {
        return mapRiverains.get(demandeur);
    }
    /**
     * reserve l'emplacement qui porte le numero passe en parametre au demandeur passe en parametre
     * La reservation reussit si
     *     l'emplacement est libre
     *     le demandeur est bien un riverain
     *     le riverain n'a pas encore 3 emplacements
     * @param demandeur le riverain qui demande un emplacement
     * @param numeroEmplacement le numero de l'emplacement souhaite
     * @return true si la reservation a reussi, false sinon
     * @throws IllegalArgumentException si le numero de l'emplacement n'existe pas
     * @throws IllegalStateException si on n'est pas en phase 1
     */
    public boolean reserver(Exposant demandeur, int numeroEmplacement) {
        //TODO
        if (!isRiverain(demandeur.getNom()))
            return false;
        if (phase != 1)
            throw new IllegalStateException();
        if (numeroEmplacement < 0 || numeroEmplacement >= tableEmplacements.length)
            throw new IllegalArgumentException();
        Integer nombreEmplacementDemandeur = mapRiverains.get(demandeur.getNom());
        if (tableEmplacements[numeroEmplacement].getExposant() != null)
            return false;
        if (nombreEmplacementDemandeur >= 3)
            return false;
        tableEmplacements[numeroEmplacement].setExposant(demandeur);
        mapRiverains.put(demandeur.getNom(), ++nombreEmplacementDemandeur);
        return true;
    }
        //Attention pour augmenter le nombre d'emplacements
        //Solution ko:
        //Integer nombreEmplacements = mapRiverains.get(demandeur);
        //mapRiverains.put(demandeur, nombreEmplacements++);
        //Solutions ok:
        //Integer nombreEmplacements = mapRiverains.get(demandeur);
        //mapRiverains.put(demandeur, ++nombreEmplacements);
        //ou:
        //Integer nombreEmplacements = mapRiverains.get(demandeur);
        //nombreEmplacements++;
        //mapRiverains.put(demandeur, nombreEmplacements);
    /**
     * attribue automatiquement un emmplacement libre au demandeur passe en parametre
     * @param demandeur le demandeur d'un emplacement
     * @return le numero de l'emplacement attribue ou -1 si plus d'emplacement libre
     * @throws IllegalStateException si on n'est pas en phase 2
     */
    public int attribuerAutomatiquementEmplacement(Exposant demandeur) {
        //TODO
        //POUR RIVERAINS ET NON RIVERAINS
        if (phase!=2)
            throw new IllegalStateException("MAUVAISE PHASE");
        if (pileEmplacementsLibres.isEmpty())
            return -1;
        int numeroAttribue = pileEmplacementsLibres.pop().getNumero();
        tableEmplacements[numeroAttribue].setExposant(demandeur);
        //int nombreEmplacementTotal = mapRiverains.get(demandeur.getNom());
        //mapRiverains.put(demandeur.getNom(), ++nombreEmplacementTotal);
        return numeroAttribue;
    }

    /**
     * a comme effet de passer de la phase 1 a la phase 2
     * si deja en phase 2, rien ne doit etre fait
     */
    public void changerPhase() {
        //TODO
        //Pensez a initialiser la pile!!!
        if (phase == 2)
            return ;
        phase = 2;
        pileEmplacementsLibres = new ArrayDeque<>(tableEmplacements.length);
        for (int i = 0; i < tableEmplacements.length; i++) {
            if (tableEmplacements[i].getExposant()==null){
                pileEmplacementsLibres.addFirst(tableEmplacements[i]);
            }

        }
    }

    @Override
    public String toString() {
        String aRenvoyer="";
        for (int i = 0; i < tableEmplacements.length; i++) {
            if(tableEmplacements[i].getExposant()==null){
                aRenvoyer +=  ("\n"+i+" : /");
            }else{
                aRenvoyer +=  ("\n"+i+" : "+tableEmplacements[i].getExposant());
            }
        }
        return aRenvoyer;
    }

    //Pour le debug
    public String donnerTableEmplacements() {
        if(tableEmplacements==null)
            return "null";
        return Arrays.toString(tableEmplacements);
    }

    //Pour le debug
    public String donnerMapRiverains() {
        if(mapRiverains==null)
            return "null";
        return mapRiverains.toString();
    }

    //Pour le debug
    public String donnerPileEmplacementsLibres() {
        if(pileEmplacementsLibres==null)
            return "null";
        return pileEmplacementsLibres.toString();
    }


  
}
