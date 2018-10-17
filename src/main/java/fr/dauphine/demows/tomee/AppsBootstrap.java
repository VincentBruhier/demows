package fr.dauphine.demows.tomee;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.dauphine.demows.beans.ApplicationBean;


@Singleton
@Startup
@DependsOn("StartupBean")
public class AppsBootstrap {
	private static	final	Logger		logger	=LogManager.getLogger(AppsBootstrap.class);
	
	// fichier de resources
    public	static	final	String	APP_PROPERTIES		="application.properties";
    
    // Attributs
    private	ApplicationBean			applicationBean		=null;
 	 	
    @PostConstruct
    public void initialize(){
    	logger.info(this.getClass().getSimpleName()+".initialize()");
        
        
        // lecture des 2 fichiers de properties
        final Properties appProperties	=new Properties();
        try {
        	appProperties.load(AppsBootstrap.class.getClassLoader().getResourceAsStream(APP_PROPERTIES));
			if ( appProperties!=null && !appProperties.isEmpty()){
				ApplicationBean	applicationBean	=new ApplicationBean();
				if ( appProperties.containsKey("application.name") )
					applicationBean.setName( appProperties.getProperty("application.name") );
				if ( appProperties.containsKey("application.version") )
					applicationBean.setVersion( appProperties.getProperty("application.version") );
				if ( appProperties.containsKey("application.url") )
					applicationBean.setUrl( appProperties.getProperty("application.url") );
				if ( appProperties.containsKey("application.env") )
					applicationBean.setEnvironment( appProperties.getProperty("application.env") );
				
				
				logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				logger.info("Application");
				logger.info("  name        : "+applicationBean.getName());
				logger.info("  version     : "+applicationBean.getVersion());
				logger.info("  url         : "+applicationBean.getUrl());
				logger.info("  environment : "+applicationBean.getEnvironment());
				logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
				this.setApplicationBean( applicationBean );
				logger.info("Application Properties : "+this.getApplicationBean());
								
			} else {
				logger.error(this.getClass().getSimpleName()+".initialize() -> failed (proprietes non defini)");
				this.setApplicationBean( null );
			}
			
		} catch (IOException ex) {
			logger.error("Can not read '<<classpath>>/"+APP_PROPERTIES+"' file");
			ex.printStackTrace();
			logger.error(this.getClass().getSimpleName()+".initialize() -> failed (missing file '"+APP_PROPERTIES+"')");
			this.setApplicationBean( null );
		}
        
        if ( this.getApplicationBean()!=null )
        	logger.info(this.getClass().getSimpleName()+".initialize -> application-properties : "+this.getApplicationBean());
        else
        	logger.error(this.getClass().getSimpleName()+".initialize -> application-properties not loaded");
    }
        
    
    @PreDestroy
    public void destroy() {
        logger.info(this.getClass().getSimpleName()+".destroy()");
    }
	/** @return the applicationBean */
	public ApplicationBean getApplicationBean(){return applicationBean;}
	/** @param applicationBean the applicationBean to set */
	public void setApplicationBean(ApplicationBean applicationBean){this.applicationBean = applicationBean;}
	
}