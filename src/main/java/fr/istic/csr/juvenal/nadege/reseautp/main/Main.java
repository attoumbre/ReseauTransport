package fr.istic.csr.juvenal.nadege.reseautp.main;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.data.Protocol;

import fr.istic.csr.juvenal.nadege.reseautp.application.MyApplication;
import fr.istic.csr.juvenal.nadege.reseautp.backend.Backend;

/**
 * Main RESTlet minimal example
 *
 * @author msimonin
 */
public final class Main
{

    /** Hide constructor. */
    private Main()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Main method.
     *
     * @param args  The arguments of the commande line
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        // Create a component
        Component component = new Component();
        Context context = component.getContext().createChildContext();
        component.getServers().add(Protocol.HTTP, 8124);

        // Create an application
        Application application = new MyApplication(context);
        
        Backend backend = new Backend();
        context.getAttributes().put("backend", backend);
        component.getDefaultHost().attach(application);

        // Start the component
        component.start();
    }

}