package fr.istic.csr.juvenal.nadege.reseautp.internals;

public class Arret {
	
	private int nbVoyageurMonte;
	private int nbVoyageur;
	private int busEstla;
	
	
	public Arret() {
		nbVoyageur=0;
		busEstla=0;
		nbVoyageurMonte=0;
	}
	
	
	/**
	 * Incrementer le nombre de personne qui sont à l'arret 
	 * Nous l'ajoutons pour savoir combien de personnes il y a à l'arret
	 */
	public synchronized void goArret() {
		nbVoyageur++;
		System.out.println("nom Thread :"+Thread.currentThread().getName()+" il y a  "+nbVoyageur+ " voyageur(s) à l'arret");
	}
	
	
	
	/**
	 * le voyageur pourra monter dans le bus quand le bus sera present et aura un nb de place vide <15 (Bus.nmclient)
	 */
	public synchronized void monterBus() {
		while(nbVoyageurMonte==Bus.nmbclient || busEstla==0) {
			try {
				System.out.println("nom Thread :"+Thread.currentThread().getName()+" est en attente");
				wait();
				
			} catch (Exception e) {
				
			}
		}
		nbVoyageurMonte++;
		nbVoyageur--;
		System.out.println("nom Thread :"+Thread.currentThread().getName()+" le bus contient "+nbVoyageurMonte);
		System.out.println("il reste "+nbVoyageur+" voyageur(s) à l'arret");
	}
	
	/**
	 * un seul bus pourra stationner à la fois
	 * Nous avons choisi une intiere pour signaler la presence du bus 
	 * 
	 */
	public synchronized void stationner() {
		while(busEstla==1) {
			try {
				wait();
			} catch (Exception e) {
				
			}
			
		}
		
		busEstla++;
		nbVoyageurMonte=0;
		System.out.println("nom Thread :"+Thread.currentThread().getName()+" le bus a garé");
		notifyAll();
		
	}
	/**
	 * fin de stationnement le bus part
	 */
	public synchronized void voyager() {
		System.out.println("nom Thread :"+Thread.currentThread().getName()+" le bus est partis");
		busEstla --;
		notifyAll();
	}

}



