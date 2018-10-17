package fr.dauphine.demows.metier;

import javax.ejb.Stateless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.dauphine.demows.beans.RectangleInfoBean;

@Stateless
public class RectangleMetierImpl {
	private static	final	Logger		logger	=LogManager.getLogger(RectangleMetierImpl.class);
	
	public RectangleInfoBean getRectangleInfo(double cote1, double cote2) {
		logger.info("RectangleMetier.getRectangleInfo("+cote2+","+cote2+") ...");
		RectangleInfoBean	result	=new RectangleInfoBean(cote1,cote2);
		logger.info("RectangleMetier.getRectangleInfo("+cote2+","+cote2+") -> "+result);
        return result;
    }
}
