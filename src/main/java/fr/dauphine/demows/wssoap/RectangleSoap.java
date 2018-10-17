package fr.dauphine.demows.wssoap;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.dauphine.demows.beans.RectangleInfoBean;
import fr.dauphine.demows.metier.RectangleMetierImpl;



@Stateless
@WebService(
        portName = "RectanglePort",
        serviceName = "RectangleService",
        targetNamespace = "http://dauphine.fr/wsdl",
        endpointInterface = "fr.dauphine.demows.wssoap.RectangleWs")
public class RectangleSoap implements RectangleWs {

	/**
	 * Bean CalculatorMetierImpl
	 */
	@EJB
	RectangleMetierImpl	rectangleImpl;
	
	/**
	 * couche d'exposition SOAP de la méthode CalculatorMetierImpl.sum
	 */
    public RectangleInfoBean getInfo(double cote1,double cote2) {
        return rectangleImpl.getRectangleInfo(cote1,cote2);
    }
}