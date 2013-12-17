package scribes.community.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bid")
public class Bid  implements Serializable {
 
private static final long serialVersionUID = 1L;
 
private String bidId;
//private String goodId;

private String serviceId;
private String bidderEmail;
private String comment;
 
@XmlElement
public String getBidId() {
return bidId;
}
public void setBidId(String bidId) {
this.bidId = bidId;
}
/*@XmlElement
public String getGoodId() {
return goodId;
}
public void setGoodId(String goodId) {
this.goodId = goodId;
}*/
public String getServiceId() {
return serviceId;
}
public void setServiceId(String serviceId) {
this.serviceId = serviceId;
}
@XmlElement
public String getBidderEmail() {
return bidderEmail;
}
public void setBidderEmail(String bidderEmail) {
this.bidderEmail = bidderEmail;
}
@XmlElement
public String getComment() {
return comment;
}
public void setComment(String comment) {
this.comment = comment;
}
}