package scribes.community.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service")

public class Service implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceId;
	private String name;
	private String description;
	private String createrEmail;
	private String status;
	//private String type;
	//private String ownerId;
	
	@XmlElement
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	

	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement
	public String getCreaterEmail() {
		return createrEmail;
	}
	public void setCreaterEmail(String createrEmail) {
		this.createrEmail = createrEmail;
	}
	
	@XmlElement
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
/*	@XmlElement
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}*/
	
}

