package fr.dauphine.demows.wssoap;

import javax.jws.WebService;


@WebService(targetNamespace = "http://dauphine.fr/wsdl")
public interface CalculatorWs {

    public int sum(int add1, int add2);

    public int multiply(int mul1, int mul2);
}