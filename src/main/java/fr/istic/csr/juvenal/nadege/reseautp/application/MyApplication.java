package fr.istic.csr.juvenal.nadege.reseautp.application;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import fr.istic.csr.juvenal.nadege.reseautp.resources.BusRessource;
import fr.istic.csr.juvenal.nadege.reseautp.resources.VoyageurEtat;
import fr.istic.csr.juvenal.nadege.reseautp.resources.VoyageursRessource;

/**
 *
 * Application.
 *
 * @author msimonin
 *
 */
public class MyApplication extends Application
{

    public MyApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        //lister voyageurs
        router.attach("/voyageurs", VoyageursRessource.class);
        //lister les etats des bus
        router.attach("/bus", BusRessource.class );
        //recuperer l'etat d'un bus
        router.attach("/voyageur/{voyageurId}", VoyageurEtat.class);
       
        
        return router;
    }
}