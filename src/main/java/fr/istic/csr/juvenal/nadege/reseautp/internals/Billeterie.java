package fr.istic.csr.juvenal.nadege.reseautp.internals;

public class Billeterie {

	private int billet =0 ;
	
	/**
	 * On supposera qu'on n'achete pas assez de billet et qu'on arrive jamais à un debordement 
	 */
	public synchronized void achat() {

		billet++;
		System.out.println("nom Thread :"+Thread.currentThread().getName()+" le nombre de billet acheté est: "+billet);
	}
}
