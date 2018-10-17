package fr.dauphine.demows.wssoap;

import javax.jws.WebService;

import fr.dauphine.demows.beans.RectangleInfoBean;

@WebService(targetNamespace = "http://dauphine.fr/wsdl")
public interface RectangleWs {

    public RectangleInfoBean getInfo(double cote1, double cote2);

}