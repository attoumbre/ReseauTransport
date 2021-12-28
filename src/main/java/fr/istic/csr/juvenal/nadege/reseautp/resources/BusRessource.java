package fr.istic.csr.juvenal.nadege.reseautp.resources;


import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.istic.csr.juvenal.nadege.reseautp.backend.Backend;
import fr.istic.csr.juvenal.nadege.reseautp.internals.Bus;

public class BusRessource extends ServerResource{

	 /** Backend.*/
    private Backend backend_;
    
    
    public BusRessource() {
    	super();
  	  backend_ = (Backend) getApplication().getContext().getAttributes()
                  .get("backend");
    }
    
    
	 /**
	  * lister l'etat des bus 
	  * @return
	  * @throws Exception
	  */
   @Get("Json")
   public Representation getBus() throws Exception{
   	
	   Collection<Bus> bus = backend_.getDatabase().getBus();
	   Collection<JSONObject> jsonBus = new ArrayList<JSONObject>();
	   
	   for(Bus b : bus) {
		   JSONObject current = new JSONObject();
		   current.put("id", b.getIdBus());
		   current.put("state", b.getStatebus());
		   jsonBus.add(current);
	   }
	   JSONArray jsonArray = new JSONArray(jsonBus);
   	return new JsonRepresentation(jsonArray);
   }
   
   
}
