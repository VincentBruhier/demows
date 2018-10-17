package fr.dauphine.demows.wsrest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.dauphine.demows.beans.RectangleInfoBean;
import fr.dauphine.demows.metier.RectangleMetierImpl;

@Produces(MediaType.APPLICATION_JSON)
@Path("/rest/rectangle")
public class RectangleRest {

	/**
	 * Bean RectangleMetierImpl
	 */
	@EJB
	RectangleMetierImpl	rectangleImpl;
	
	/**
	 * couche d'exposition rest de la méthode CalculatorMetierImpl.sum
	 */
    @Path("/info")
    @GET
    public RectangleInfoBean getInfo(@QueryParam("cote1") double cote1,@QueryParam("cote2") double cote2){
		return rectangleImpl.getRectangleInfo(cote1,cote2);
	}
	
}
