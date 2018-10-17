package fr.dauphine.demows.wsrest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.dauphine.demows.beans.SupervisionBean;
import fr.dauphine.demows.metier.SupervisionMetierImpl;
import fr.dauphine.demows.tomee.ApplicationException;

@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Path("/rest/supervision")
@Stateless
public class SupervisionRest {
	private static final Logger logger	=LogManager.getLogger(SupervisionRest.class);

	@EJB
	SupervisionMetierImpl supervision;
	
	@Path("/")
	@GET
	public SupervisionBean getInfo(@Context HttpServletRequest request,@Context final HttpServletResponse response) throws ApplicationException{
		String	signature	=this.getClass().getName()+".getInfo()";
		logger.info(signature+" ...");
		// execution
		SupervisionBean result=this.supervision.getInfo();
		// code de la reponse HTTP
		response.setStatus(result.getStatusBean().getCodeHttp());
		// result
		logger.info(signature+" -> "+result+" (code-http="+result.getStatusBean().getCodeHttp()+")");
		return result;
	}
	
}
