package fr.dauphine.demows.tomee;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Conversion d'une exception en reponse REST d'erreur 
 * @author Uiversité Paris IX - Dauphine, PSL
 *
 */
@Provider
public class ApplicationRestException implements ExceptionMapper<ApplicationException> {
	private static	final	Logger		logger	=LogManager.getLogger(ApplicationRestException.class);


	class RestEntityException{
		public int code;
		public String message;
		public RestEntityException(int code,String message) {this.code=code;this.message=message;}
	}
	
	public Response toResponse(ApplicationException ex) {
		logger.info("ApplicationException : "+ex);
		ResponseBuilder	res	=Response.status(ex.getHttpCode());
		RestEntityException errorEntity	=new RestEntityException(ex.getHttpCode(),ex.getMessage());
		res	=res.entity( errorEntity );
		//res	=res.type(MediaType.APPLICATION_JSON);
		res =res.header( "Content-Type", "application/json; charset=utf-8");
		Response	result	=res.build();
		return	result;
	}
}
