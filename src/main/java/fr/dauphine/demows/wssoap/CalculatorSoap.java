package fr.dauphine.demows.wssoap;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.dauphine.demows.metier.CalculatorMetierImpl;



@Stateless
@WebService(
        portName = "CalculatorPort",
        serviceName = "CalculatorService",
        targetNamespace = "http://dauphine.fr/wsdl",
        endpointInterface = "fr.dauphine.demows.wssoap.CalculatorWs")
public class CalculatorSoap implements CalculatorWs {

	/**
	 * Bean CalculatorMetierImpl
	 */
	@EJB
	CalculatorMetierImpl	calculatorImpl;
	
	/**
	 * couche d'exposition SOAP de la méthode CalculatorMetierImpl.sum
	 */
    public int sum(int add1, int add2) {
        return calculatorImpl.sum(add1,add2);
    }

    /**
	 * couche d'exposition SOAP de la méthode CalculatorMetierImpl.multiply
	 */
    public int multiply(int mul1, int mul2) {
        return calculatorImpl.multiply(mul1,mul2);
    }
}