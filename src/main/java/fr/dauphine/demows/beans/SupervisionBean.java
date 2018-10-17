package fr.dauphine.demows.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="supervision")
public class SupervisionBean {

	private	ApplicationBean	applicationBean;
	private	StatusBean		statusBean;
	/**
	 * @return the applicationBean
	 */
	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}
	/**
	 * @param applicationBean the applicationBean to set
	 */
	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}
	/**
	 * @return the statusBean
	 */
	public StatusBean getStatusBean() {
		return statusBean;
	}
	/**
	 * @param statusBean the statusBean to set
	 */
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
	@Override
	public String toString() {
		return "SupervisionBean [applicationBean=" + applicationBean + ", statusBean=" + statusBean + "]";
	}
	
	
}
