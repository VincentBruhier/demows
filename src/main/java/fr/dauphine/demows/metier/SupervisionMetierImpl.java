package fr.dauphine.demows.metier;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.dauphine.demows.beans.ApplicationBean;
import fr.dauphine.demows.beans.StatusBean;
import fr.dauphine.demows.beans.SupervisionBean;
import fr.dauphine.demows.tomee.ApplicationException;
import fr.dauphine.demows.tomee.AppsBootstrap;


@Stateless
public class SupervisionMetierImpl {
	private static final Logger logger	=LogManager.getLogger(SupervisionMetierImpl.class);

	@EJB
    AppsBootstrap appsBootstrap;
	
	
	/**
	 * recuperation des informations sur l'application
	 * @return application description
	 */
	public ApplicationBean getAppProperties() {
		String	signature =this.getClass().getName()+".getAppProperties()";
		logger.info(signature + " ...");
		// execution
		ApplicationBean	result	=null;
		if ( this.appsBootstrap!=null ){
			if ( this.appsBootstrap.getApplicationBean()==null ){
				logger.error("ApplicationBroken at startup : app-properties unavailable");
			} else {
				result	=appsBootstrap.getApplicationBean();
			}
		}
		// resultat
		logger.info(signature+" -> " + result);
		return result;
	}
	
	/**
	 * recuperation du status du service
	 * @return service status
	 */
	public StatusBean getStatus() throws ApplicationException{
		String	signature =this.getClass().getName()+".getStatus()";
		logger.info(signature + " ...");
		// execution
		StatusBean		status =new StatusBean();
		status.setCodeHttp(200);
		
		try{
			status.setFqdn(InetAddress.getLocalHost().getHostName().toString());
			status.setIp(InetAddress.getLocalHost().getHostAddress().toString());
			logger.debug(signature+" [host="+status.getFqdn()+" ("+status.getIp()+")]");
		}catch(UnknownHostException ex){
			logger.error("ApplicationBroken at startup : host/ip unavailable");
			logger.error("  - class    : "+ex.getClass().getName());
			logger.error("  - message  : "+ex.getMessage());
		}
		
		// date au format ISO8601
		status.setDate( new Date() );		
		TimeZone dtz	=TimeZone.getDefault();
		status.setFuseau( dtz.getDisplayName() );
		logger.debug(signature+" [host="+status.getDate()+" (fuseau:"+status.getFuseau()+")]");
		
		// ~~~~ TESTS d'acces aux ressources ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		//
		//    << aucune connexions ou accès de ressources à tester >>
		//
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		// TEST EXCEPTION
		//if ( 1 != 2)
		//	throw new ApplicationException(303,"essai");
		
		// resultat
		logger.info(signature+" -> " + status+" (code-http="+status.getCodeHttp()+")");
		return status;
	}
	
	/**
	 * recuperation des informations et du status de l'application
	 * @return application description et service status
	 */
	public SupervisionBean getInfo() throws ApplicationException{
		String	signature =this.getClass().getName()+".getInfo()";
		logger.info(signature + " ...");
		// execution
		SupervisionBean result =new SupervisionBean();
		result.setStatusBean( this.getStatus() );
		result.setApplicationBean( this.getAppProperties() );
		if ( result.getApplicationBean()==null ){
			logger.error("ApplicationBroken at startup : app-properties unavailable");
			result.getStatusBean().setCodeHttp(500);
		} else {
			logger.debug(signature+" [application="+appsBootstrap.getApplicationBean()+"]");
			result.setApplicationBean(appsBootstrap.getApplicationBean());
		}
		// resultat
		logger.info(signature+" -> " + result+" (code-http="+result.getStatusBean().getCodeHttp()+")");
		return result;
	}

}
