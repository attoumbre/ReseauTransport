package fr.istic.csr.juvenal.nadege.reseautp.Database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fr.istic.csr.juvenal.nadege.reseautp.internals.Arret;
import fr.istic.csr.juvenal.nadege.reseautp.internals.Billeterie;
import fr.istic.csr.juvenal.nadege.reseautp.internals.Bus;
import fr.istic.csr.juvenal.nadege.reseautp.internals.Voyageur;

public class ReseauDatabase implements Database{
	
	Map<Integer, Voyageur> voyageur_;
    Map<Integer,Bus> bus_;
   
    private int voyageurCount_;
    private Arret arret_;
    private Billeterie billeterie_;
  
    public ReseauDatabase()
    {
    	arret_ = new Arret();
        voyageur_ = new HashMap<Integer, Voyageur>();
        bus_ = new HashMap<Integer, Bus>();
        billeterie_ = new Billeterie();
        
       //creation de 3 bus
        Bus bus = new Bus(arret_,1);
        bus_.put(1, bus);
        bus.start();
//        for(int i=0;i<3;i++) {
//        	Bus bus = new Bus(arret_,i);
//        	bus_.put(i, bus);
//        	
//        }
//        //lancer les bus créés
//        for(Bus b : bus_.values()) {
//        	
//        	try {
//        		b.start();
//        		
//			} catch (Exception e) {
//				
//			}
//        }

        
        
    }


	@Override
	public Collection<Voyageur> getVoyageurs() {
		
		return voyageur_.values();
	}

	@Override
	public Collection<Bus> getBus() {
		
		return bus_.values();
	}


	@Override
	public synchronized Voyageur createVoyageur(String name) {
		Voyageur voyageur = new Voyageur(name,arret_, billeterie_);
		
		voyageur.setVoyageurId(voyageurCount_);
		voyageur_.put(voyageurCount_, voyageur);
		voyageurCount_++;
		voyageur.start();
		return voyageur;
	}


	@Override
	public Voyageur getVoyageur(int id) {
		
		return voyageur_.get(id);
	}
	
	
	

}
