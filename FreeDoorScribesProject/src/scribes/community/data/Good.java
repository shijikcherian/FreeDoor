package scribes.community.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONObject;

@XmlRootElement(name = "good")
public class Good implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String goodId;
	private String name;
	private String status;
	private String description;
	
	private String createrEmail;
	@XmlElement
	public String getGoodId() {
		return goodId;
	}
	
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	//Getters Setters

	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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


	

	
}
