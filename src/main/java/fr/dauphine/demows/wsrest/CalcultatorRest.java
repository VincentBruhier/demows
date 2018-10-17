package fr.dauphine.demows.wsrest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.dauphine.demows.metier.CalculatorMetierImpl;

@Produces(MediaType.APPLICATION_JSON)
@Path("/rest/calculator")
public class CalcultatorRest {

	/**
	 * Bean CalculatorMetierImpl
	 */
	@EJB
	CalculatorMetierImpl	calculatorImpl;
	
	/**
	 * couche d'exposition rest de la méthode CalculatorMetierImpl.sum
	 */
    @Path("/sum")
    @GET
    public int sum(@QueryParam("param1") int param1,@QueryParam("param2") int param2){
		return calculatorImpl.sum(param1,param2);
	}
	

    /**
	 * couche d'exposition rest de la méthode CalculatorMetierImpl.multiply
	 */
    @Path("/multiply")
    @GET
    public int multiply(@QueryParam("param1") int param1,@QueryParam("param2") int param2){
		return calculatorImpl.multiply(param1,param2);
	}
}
