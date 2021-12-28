package fr.istic.csr.juvenal.nadege.reseautp.internals;

public class Bus extends Thread{

	private static int busInitNumber;
	public enum BusState {STATIONNE, ENVOYAGE}
	private Arret arret;
	public static final int nmbclient=15;
	private BusState statebus;
	private int idBus;
	
	public Bus(Arret arret, int idBus) {
		super(null, null, "Bus-" + nextBusNum());
		this.arret = arret;
		this.idBus =idBus;
		this.statebus = BusState.ENVOYAGE;
		//this.setDaemon(true);
		
	}
	
	private synchronized static int nextBusNum() {
        return busInitNumber++;
    }
	
	public void voyager() {
		try { Thread.sleep(100000); } catch(InterruptedException e) {}
		this.statebus = BusState.ENVOYAGE;
		setStatebus(statebus);
	}
	
	public void stationner() {
		arret.stationner();
		this.statebus = BusState.STATIONNE;
		setStatebus(statebus);
		try { Thread.sleep(100000); } catch(InterruptedException e) {}
	}
	
	public void enVoyage() {
		arret.voyager();
		this.statebus = BusState.ENVOYAGE;
		setStatebus(statebus);
	}
	
	@Override
	public void run() {
		while(true) {
			//le bus voyage
			voyager();
			//garer le bus qi la place a l'arret est libre
			//stationner pendnant un temps
	        stationner();
	        //il attend si pas de bus sinon monte dans le bus
			enVoyage();
		}
		
	}

	public BusState getStatebus() {
		return statebus;
	}

	public void setStatebus(BusState statebus) {
		this.statebus = statebus;
	}

	public int getIdBus() {
		return idBus;
	}

	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}
}
