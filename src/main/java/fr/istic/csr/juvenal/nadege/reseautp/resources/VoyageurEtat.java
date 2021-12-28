package fr.istic.csr.juvenal.nadege.reseautp.resources;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.istic.csr.juvenal.nadege.reseautp.backend.Backend;
import fr.istic.csr.juvenal.nadege.reseautp.internals.Voyageur;

public class VoyageurEtat extends ServerResource{
	
	private Backend backend_;
	private Voyageur voyageur_;
	public VoyageurEtat() {
		super();
		backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
	}

	 @Get("json")
	  public Representation getVoyageur() throws JSONException
	    {
		 String voyageurIdString = (String) getRequest().getAttributes().get("voyageurId");
		 int voyageurId = Integer.valueOf(voyageurIdString);
		 voyageur_ = backend_.getDatabase().getVoyageur(voyageurId);
		 JSONObject voyageurObject = new JSONObject();
		 voyageurObject.put("name", voyageur_.getNameVoyageur());
		 voyageurObject.put("id", voyageur_.getVoyageurId());
		 voyageurObject.put("etat", voyageur_.getStatVoyageur());
		 
		 
		 return new JsonRepresentation(voyageurObject);
	    }
}
