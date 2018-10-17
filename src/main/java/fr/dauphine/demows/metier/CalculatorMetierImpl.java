package fr.dauphine.demows.metier;

import javax.ejb.Stateless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Stateless
public class CalculatorMetierImpl {
	private static	final	Logger		logger	=LogManager.getLogger(CalculatorMetierImpl.class);
	
	public int sum(int add1, int add2) {
		logger.info("CalculatorMetier.add("+add1+","+add2+") ...");
		int	result	=add1 + add2;
		logger.info("CalculatorMetier.add("+add1+","+add2+") -> "+result);
        return result;
    }

    public int multiply(int mul1, int mul2) {
		logger.info("CalculatorMetier.multiply("+mul1+","+mul2+") ...");
		int	result	=mul1*mul2;
		logger.info("CalculatorMetier.multiply("+mul1+","+mul2+") -> "+result);
        return result;
    }

}
