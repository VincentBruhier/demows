package fr.dauphine.demows.metier;


import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class CalculatorMetierTest {
	private static	final	Logger		logger	=LogManager.getLogger(CalculatorMetierTest.class);
	
	@Rule
	public TestName name = new TestName();
	
	@Test
	public void testSum() {
		CalculatorMetierImpl calculator	=new CalculatorMetierImpl();

		logger.info(this.getClass().getSimpleName()+"."+name.getMethodName()+" sum(3,2) ...");
		assertEquals("sum(3,2) -> 5",5,calculator.sum(3,2));

		logger.info(this.getClass().getSimpleName()+"."+name.getMethodName()+" sum(13,-2) ...");
		assertEquals("sum(13,-2) -> 11",11,calculator.sum(13,-2));
    }

	@Test
	public void testMultiply() {
		CalculatorMetierImpl calculator	=new CalculatorMetierImpl();

		logger.info(this.getClass().getSimpleName()+"."+name.getMethodName()+" multiply(3,2) ...");
		assertEquals("multiply(3,2) -> 6",6,calculator.multiply(3,2));

		logger.info(this.getClass().getSimpleName()+"."+name.getMethodName()+" sum(-4,-3) ...");
		assertEquals("multiply(-4,-3) -> 12",12,calculator.multiply(-4,-3));
    }


}
