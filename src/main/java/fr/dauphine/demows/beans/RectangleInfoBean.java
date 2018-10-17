package fr.dauphine.demows.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rectangle")
public class RectangleInfoBean {
	
	private	double	coteLong		=1;
	private	double	coteCourt		=1;
	
	public	RectangleInfoBean(){this(1,1);}
	public	RectangleInfoBean(double cote){this(cote,cote);}			
	public	RectangleInfoBean(double cote1,double cote2){
		this.setCoteLong( Math.max(cote1, cote2) );
		this.setCoteCourt( Math.min(cote1, cote2) );
	}

	/**
	 * @return the coteLong
	 */
	@XmlElement(name="L")
	public double getCoteLong() {
		return coteLong;
	}

	/**
	 * @param coteLong the coteLong to set
	 */
	private void setCoteLong(double coteLong) {
		this.coteLong = coteLong;
	}

	/**
	 * @return the coteCourt
	 */
	@XmlElement(name="l")
	public double getCoteCourt() {
		return coteCourt;
	}

	/**
	 * @param coteCourt the coteCourt to set
	 */
	private void setCoteCourt(double coteCourt) {
		this.coteCourt = coteCourt;
	}
	
	/**
	 * @return the perimetre
	 */
	@XmlElement
	public double getPerimetre() {
		return this.getCoteCourt()*2 + this.getCoteLong()*2;
	}

	/**
	 * @return the aire
	 */
	@XmlElement
	public double getAire() {
		return this.getCoteCourt() * this.getCoteLong();
	}
	
	public	String	toString(){
		return "Rectangle[L="+this.getCoteLong()+" x l="+this.getCoteCourt()+"] -> Périmètre="+this.getPerimetre()+" Aire="+this.getAire();
	}

}
