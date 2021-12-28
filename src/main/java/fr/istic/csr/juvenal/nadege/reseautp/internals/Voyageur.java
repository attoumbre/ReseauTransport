package fr.istic.csr.juvenal.nadege.reseautp.internals;

public class Voyageur extends Thread{
	
	private static int clientInitNumber;
	private Billeterie billeterie;
	public enum VoyageurState {SANSBILLET, AVECBILLET, MONTEBUS}
	private Arret arret;
	private int voyageurId;
	private VoyageurState statVoyageur;
	
	private String nameVoyageur;


	public Voyageur(String nameVoyageur,Arret arret, Billeterie billeterie) {
		 super(null, null, "Voyageur-" + nextClientNum());
		this.arret = arret ;
		this.billeterie = billeterie;
		this.statVoyageur = VoyageurState.SANSBILLET;
		this.nameVoyageur = nameVoyageur;
	}
	
	private synchronized static int nextClientNum() {
        return clientInitNumber++;
    }
	
	
	public void acheterBillet() {
		
		this.statVoyageur = VoyageurState.SANSBILLET;
		setStatVoyageur(statVoyageur);
		try { Thread.sleep(10000); } catch(InterruptedException e) {}
		billeterie.achat();
	}
	

	public void goToArret() {
		this.statVoyageur= VoyageurState.AVECBILLET;
		arret.goArret();
		setStatVoyageur(statVoyageur);
	}
	
	public void voyager() {
		
		arret.monterBus();
		this.statVoyageur= VoyageurState.MONTEBUS;
		setStatVoyageur(statVoyageur);
	}

	@Override
	public void run() {
		//le client achette un ticket 
		acheterBillet();
		//il se rend à l'arret de bus
		goToArret();
		
		//attendre le bus
        //il attend si pas de bus sinon monte dans le bus
		voyager();
	}

	public int getVoyageurId() {
		return voyageurId;
	}

	public void setVoyageurId(int voyageurId) {
		this.voyageurId = voyageurId;
	}

	public VoyageurState getStatVoyageur() {
		return statVoyageur;
	}

	public void setStatVoyageur(VoyageurState statVoyageur) {
		this.statVoyageur = statVoyageur;
	}

	public String getNameVoyageur() {
		return nameVoyageur;
	}

	public void setNameVoyageur(String nameVoyageur) {
		this.nameVoyageur = nameVoyageur;
	}
	
	
}
