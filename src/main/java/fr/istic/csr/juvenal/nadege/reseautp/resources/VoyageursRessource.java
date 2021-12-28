package fr.istic.csr.juvenal.nadege.reseautp.resources;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import fr.istic.csr.juvenal.nadege.reseautp.backend.Backend;
import fr.istic.csr.juvenal.nadege.reseautp.internals.Voyageur;

public class VoyageursRessource extends ServerResource{
	
	private Backend backend_;
	
	public VoyageursRessource() {
		super();
		backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
	}
	 /**
	  * liste les voyageurs 
	  * @return
	  * @throws Exception
	  */
    @Get("Json")
    public Representation getVoyageurs() throws Exception{
    	
    	Collection<Voyageur> voyageurs = backend_.getDatabase().getVoyageurs();
    	Collection<JSONObject> jsonVoyageurs = new ArrayList<JSONObject>();
    	
    	for(Voyageur v : voyageurs) {
    		JSONObject current = new JSONObject();
    		current.put("id", v.getVoyageurId());
    		current.put("name", v.getNameVoyageur());
    		
    		jsonVoyageurs.add(current);
    	}
    	
    	JSONArray jsonArray = new JSONArray(jsonVoyageurs);
    	return new JsonRepresentation(jsonArray);
    }
    
    /**
     * poster un voyageur
     * @return
     * @throws Exception
     */
    @Post("Json")
    public Representation createVoyageur(JsonRepresentation representation) throws Exception{
    	JSONObject object = representation.getJsonObject();
    	String name = object.getString("name");
    	
    	Voyageur voyageur = backend_.getDatabase().createVoyageur(name);
    	JSONObject resultObject = new JSONObject();
    	resultObject.put("name", voyageur.getNameVoyageur());
    	resultObject.put("id", voyageur.getVoyageurId());
    	JsonRepresentation result = new JsonRepresentation(resultObject);
        return result;
    }

}
