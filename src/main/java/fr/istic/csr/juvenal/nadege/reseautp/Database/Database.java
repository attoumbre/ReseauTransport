package fr.istic.csr.juvenal.nadege.reseautp.Database;
import java.util.Collection;

import fr.istic.csr.juvenal.nadege.reseautp.internals.*;

public interface Database {
	
	/**
     * Retourne la liste des Voyageurs
     * @return Liste des voyageur
     */
    Collection<Voyageur> getVoyageurs();

    /**
     * lister l'etat des bus
     * @return 
     */
    Collection<Bus> getBus();
    
    /**
     * ajouter un auteur à la base de donnée
     * @param name
     * @return le voyageur ajouté
     */
    Voyageur createVoyageur(String name);
   
    /**
     * recuperer l'etat du voyageur
     * @param id
     * @return
     */
    Voyageur getVoyageur(int id);

}
