package fr.dauphine.demows.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="application")
public class ApplicationBean {
	
	private	String	name;
	private	String	version;
	private	String	url;
	private	String	environment;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}
	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	@Override
	public String toString() {
		return "ApplicationBean [name=" + name + ", version=" + version + ", environment=" + environment + ", url=" + url +"]";
	}
	
	
}
