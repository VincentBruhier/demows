package fr.dauphine.demows.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="status")
public class StatusBean {
	
	private	int		codeHttp;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private	Date	date;
	private	String	fuseau;
	private	String	fqdn;
	private	String	ip;
	
	/**
	 * tableau des status de connexions : [ {"nom-connexion","<etat-connexion true/false>" } ]
	 */
	private	Map<String,Boolean>	connexions;
	
	public	StatusBean(){
		this.setCodeHttp(200);
		this.setConnexions(new HashMap<String,Boolean>());
	}
	
	
	
	@Override
	public String toString() {
		return "SupervisionBean [date=" + date + ", fuseau=" + fuseau + ", fqdn=" + fqdn + ", ip=" + ip
				+ ", connexions=" + connexions + "]";
	}



	/**
	 * @return the fqdn
	 */
	public String getFqdn() {
		return fqdn;
	}
	/**
	 * @param fqdn the fqdn to set
	 */
	public void setFqdn(String fqdn) {
		this.fqdn = fqdn;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the fuseau
	 */
	public String getFuseau() {
		return fuseau;
	}
	/**
	 * @param fuseau the fuseau to set
	 */
	public void setFuseau(String fuseau) {
		this.fuseau = fuseau;
	}
	
	/**
	 * ajoute un status a une connexion
	 * @param cxname
	 * @param status
	 */
	public	void addConnexionsStatus(String cxname,Boolean status){
		this.getConnexions().put(cxname, status);
	}

	/**
	 * @return the connexions
	 */
	public Map<String,Boolean> getConnexions() {
		return connexions;
	}

	/**
	 * @param connexions the connexions to set
	 */
	public void setConnexions(Map<String,Boolean> connexions) {
		this.connexions = connexions;
	}



	/**
	 * @return the codeHttp
	 */
	public int getCodeHttp() {
		return codeHttp;
	}



	/**
	 * @param codeHttp the codeHttp to set
	 */
	public void setCodeHttp(int codeHttp) {
		this.codeHttp = codeHttp;
	}
}
