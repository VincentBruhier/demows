package fr.dauphine.demows.tomee;


import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup
public class StartupBean {
    public enum States {BEFORESTARTED, STARTED, PAUSED, SHUTTINGDOWN};
    private States state;
    
    @PostConstruct
    public void initialize() {
    	System.out.println("--- java-env ----------------------------------");
    	Map<String, String> env = System.getenv();
    	for (String envName : env.keySet()) {
    		System.out.format("%s=%s%n", envName, env.get(envName));
    	}
    	System.out.println("-----------------------------------------------");
    	
        state = States.BEFORESTARTED;
        // Perform intialization
        state = States.STARTED;
        System.out.println("Service Started");
    }
    
    @PreDestroy
    public void terminate() {
        state = States.SHUTTINGDOWN;
        // Perform termination
        System.out.println("Shut down in progress");
    }
    public States getState() {
        return state;
    }
    public void setState(States state) {
        this.state = state;
    }
}
