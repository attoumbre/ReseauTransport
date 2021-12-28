package fr.istic.csr.juvenal.nadege.reseautp.backend;

import fr.istic.csr.juvenal.nadege.reseautp.Database.Database;
import fr.istic.csr.juvenal.nadege.reseautp.Database.ReseauDatabase;

public class Backend {
	
	Database database;

    public Backend() {
        database = new ReseauDatabase();
    }

    public Database getDatabase() {
        return database;
    }
}


