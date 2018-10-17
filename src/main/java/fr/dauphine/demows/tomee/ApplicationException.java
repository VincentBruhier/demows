package fr.dauphine.demows.tomee;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationException extends Exception implements Serializable {
	
	/** default serialVersionUID */
	private static final long serialVersionUID = 1L;
		
	private	int	httpCode	=501;

	public	ApplicationException() {super();}
	public	ApplicationException(String message) {super(message);}
	public	ApplicationException(int httpCode,String message){
		super(message);
		this.setHttpCode(httpCode);
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public String getMessage() {
		return super.getMessage();
	}
	
	@Override
	public String toString() {
		return "ApplicationException["+httpCode+"] -> "+this.getMessage();
	}
	
	
	
}
