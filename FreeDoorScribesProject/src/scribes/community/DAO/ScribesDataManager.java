package scribes.community.DAO;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import scribes.community.data.User;

import scribes.community.data.Good;
import scribes.community.data.Service;
import scribes.community.data.Community;


import scribes.community.data.Bid;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class ScribesDataManager {

	private DB scribesDb;
	private DBCollection goodColl;
	private DBCollection serviceColl;
	private DBCollection communityColl;
	private DBCollection bidColl;
	private DBCursor cursor;
	private DBCollection userColl;
	
	public ScribesDataManager() {
		try {
			
			Mongo mongo = new Mongo( "localhost" , 27017 );
			//System.out.println("Connected Mongo DB successfully");
			scribesDb = mongo.getDB( "scribesdb" );
			
		    goodColl = scribesDb.getCollection("goods");
			serviceColl = scribesDb.getCollection("services");;
		    communityColl = scribesDb.getCollection("communities");;
			bidColl = scribesDb.getCollection("bids");
			userColl = scribesDb.getCollection("users");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static java.sql.Timestamp getCurrentDateTime() {
	    java.util.Date today = new java.util.Date();
	    return  new Timestamp(today.getTime());
	}

	/**
	 * 
	 * @return
	 */
	public List<Good> retrieveAllGoods() {
	
		List<Good> goods = new ArrayList<Good>();
	
	    cursor = goodColl.find();
	    try {
	    	while(cursor.hasNext()) {
	        	Good good = new Good();
	        	BasicDBObject obj = (BasicDBObject) cursor.next();
	        good.setGoodId(obj.getString("_id"));
	        	good.setCreaterEmail(obj.getString("createrEmail"));
	        	good.setName(obj.getString("name"));
	        	good.setDescription(obj.getString("description"));
	        	good.setStatus(obj.getString("status"));
	        	//good.setOwnerId(obj.getString("ownerId"));
	        	//good.setLastUpdatedBy(obj.getDate("lastUpdatedDate"));
	        	goods.add(good);
	    	}
	    }
    	catch (Exception e) {
	    	System.err.println(e.getMessage());
	    	e.printStackTrace();
	    }
	    finally {
	        cursor.close();
	    }
	   
		return goods;
	}
	/*public List<Bid> retrieveOffersByGoodId(String goodId) {
		List<gBid> gbids = new ArrayList<gBid>();
        BasicDBObject query = new BasicDBObject();
         query.put("goodId", goodId);
         cursor = gbidColl.find(query);
    try {
            while(cursor.hasNext()) {
                gBid gbid = new gBid();
                BasicDBObject obj = (BasicDBObject) cursor.next();
                gbid.setGoodId(obj.getString("goodId"));
                //bid.setBidderId(obj.getString("bidderId"));
                gbid.setBidderEmail(obj.getString("bidderEmail"));
                gbid.setComment(obj.getString("comment"));
                gbids.add(gbid);
            }
    }
    catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
    }
    finally {
        cursor.close();
    }
        return gbids;
	}*/
	
	/**
	 * 
	 * @param good
	 * @return
	 */
	public String createGood(Good good)  {
		String goodId = null;	
		
	    BasicDBObject document = new BasicDBObject();
		//doc.put("goodId", "1");
	    document.put("name", good.getName());
	    document.put("description", good.getDescription());
	    document.put("createrEmail", good.getCreaterEmail());
	    document.put("status", good.getStatus());
	   // document.put("ownerId", good.getOwnerId());
	    //doc.put("lastUpdatedDate", getCurrentDateTime());
	    goodColl.insert(document);
	    goodId = document.getString("_id");
	    
	    return goodId;
	}
	
	
	
	public Good getGoodById(String goodId) {
		Good good = new Good();
	    BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(goodId));
		DBObject dbObj = goodColl.findOne(query);
		
		if (dbObj != null) {
			//good.setGoodId(dbObj.get("_id").toString());
        	good.setCreaterEmail(dbObj.get("createrEmail").toString());
        	good.setName(dbObj.get("name").toString());
        	good.setDescription(dbObj.get("description").toString());
        	good.setStatus(dbObj.get("status").toString());
        	//good.setOwnerId(dbObj.get("ownerId").toString());
		}
		return good;
	}
	
	
	public void updateGood(Good good) {
		BasicDBObject document = new BasicDBObject();
		document.put("status", good.getStatus());
		document.put("name", good.getName());
		document.put("description", good.getDescription());
		document.put("createrEmail", good.getCreaterEmail());
		//document.put("ownerId", good.getOwnerId());
		//newDocument.put("description", good.getDescription());
		goodColl.update(new BasicDBObject().append("_id", new ObjectId(good.getGoodId())), document);
	}
	
	
	public void deleteGood(String goodId) {
		BasicDBObject document = new BasicDBObject();
		document.put("_id", new ObjectId(goodId));
		goodColl.remove(document);
	}
	
	
	
	public List<Good> getGoodsBySearchCriteria (String name,  String status, 
												String createrEmail, String ownerId) {
		List<Good> goods = new ArrayList<Good>();
		BasicDBObject query = new BasicDBObject();
		if (name!=null && name.length()>0)
			query.put("name", name);
		
		if (status!=null && status.length()>0)
			query.put("status", status);
		
		if (createrEmail!=null && createrEmail.length()>0)
			query.put("createrEmail", createrEmail);
		
		if (ownerId!=null && ownerId.length()>0)
			query.put("ownerId", ownerId);
		
 		cursor = goodColl.find(query);
	    try {
	    	while(cursor.hasNext()) {
	    		Good good = new Good();
	        	BasicDBObject obj = (BasicDBObject) cursor.next();
	        	//good.setGoodId(obj.getString("_id"));
	        	good.setCreaterEmail(obj.getString("createrEmail"));
	        	good.setName(obj.getString("name"));
	        	good.setDescription(obj.getString("description"));
	        	good.setStatus(obj.getString("status"));
	        	//good.setOwnerId(obj.getString("ownerId"));
	        	goods.add(good);
	    	}
	    }
    	catch (Exception e) {
	    	System.err.println(e.getMessage());
	    	e.printStackTrace();
	    }
	    finally {
	        cursor.close();
	    }
		return goods;
	}
	
	

	public List<Good> getGoodsByNameCriteria (String name)
	{
List<Good> goods = new ArrayList<Good>();
BasicDBObject query = new BasicDBObject();
//if (name!=null && name.length()>0)
query.put("name", name);

cursor = goodColl.find(query);
try {
while(cursor.hasNext()) {
Good good = new Good();
BasicDBObject obj = (BasicDBObject) cursor.next();
//good.setGoodId(obj.getString("_id"));
good.setCreaterEmail(obj.getString("createrEmail"));
good.setName(obj.getString("name"));
good.setDescription(obj.getString("description"));
good.setStatus(obj.getString("status"));
//good.setOwnerId(obj.getString("ownerId"));
goods.add(good);
}
}
catch (Exception e) {
System.err.println(e.getMessage());
e.printStackTrace();
}
finally {
cursor.close();
}
return goods;
}

	
	
	

	
	public String createService(Service service)  {
		String serviceId = null;
		BasicDBObject doc = new BasicDBObject();
	    doc.put("name", service.getName());
	    doc.put("description", service.getDescription());
	    doc.put("createrEmail", service.getCreaterEmail());
	    doc.put("status", service.getStatus());
	  //  doc.put("ownerId", service.getOwnerId());
	    serviceColl.insert(doc);
	    serviceId = doc.getString("_id");
		return serviceId; 
	}
	
	
	public List<Service> retrieveAllServices() {
		List<Service> services = new ArrayList<Service>();
	    cursor = serviceColl.find();
	    try {
	    	while(cursor.hasNext()) {
	    		Service service = new Service();
	        	BasicDBObject obj = (BasicDBObject) cursor.next();
	        	service.setServiceId(obj.getString("_id"));
	        	service.setCreaterEmail(obj.getString("createrEmail"));
	        	service.setName(obj.getString("name"));
	        	service.setDescription(obj.getString("description"));
	        	service.setStatus(obj.getString("status"));
	        	//service.setOwnerId(obj.getString("ownerId"));
	        	//good.setLastUpdatedBy(obj.getDate("lastUpdatedDate"));
	        	services.add(service);
	    	}
	    }
    	catch (Exception e) {
	    	System.err.println(e.getMessage());
	    	e.printStackTrace();
	    }
	    finally {
	        cursor.close();
	    }
		return services;
	}	
	

	
	public Service getServiceById(String serviceId) {
		Service service = new Service();
	    BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(serviceId));
		DBObject dbObj = serviceColl.findOne(query);
		if (dbObj != null) {
			service.setServiceId(dbObj.get("_id").toString());
			service.setCreaterEmail(dbObj.get("createrEmail").toString());
			service.setName(dbObj.get("name").toString());
        	service.setDescription(dbObj.get("description").toString());
        	service.setStatus(dbObj.get("status").toString());
        	//service.setOwnerId(dbObj.get("ownerId").toString());
		}
		return service;
	}
	

	
	public List<Service> getServicesBySearchCriteria(String name, String status, 
													String createrEmail, String ownerId) {
		List<Service> services = new ArrayList<Service>();
		BasicDBObject query = new BasicDBObject();
		if (name!=null && name.length()>0)
			query.put("name", name);
		if (status!=null && status.length()>0)
			query.put("status", status);
		if (createrEmail!=null && createrEmail.length()>0)
			query.put("createrEmail", createrEmail);
		if (ownerId!=null && ownerId.length()>0)
			query.put("ownerId", ownerId);
 		cursor = serviceColl.find(query);
 		
	    try {
	    	while(cursor.hasNext()) {
	    		Service service = new Service();
	        	BasicDBObject obj = (BasicDBObject) cursor.next();
	        	service.setServiceId(obj.getString("_id"));
	        	service.setCreaterEmail(obj.getString("createrEmail"));
	        	service.setName(obj.getString("name"));
	        	service.setDescription(obj.getString("description"));
	        	service.setStatus(obj.getString("status"));
	        //	service.setOwnerId(obj.getString("ownerId"));
	        	services.add(service);
	    	}
	    }
    	catch (Exception e) {
	    	System.err.println(e.getMessage());
	    	e.printStackTrace();
	    }
	    finally {
	        cursor.close();
	    }
		
		return services;
	}
	
	
	public void updateService(Service service) {
		BasicDBObject document = new BasicDBObject();
		document.put("status", service.getStatus());
		document.put("name", service.getName());
		document.put("description", service.getDescription());
		document.put("createrEmail", service.getCreaterEmail());
	//	document.put("ownerId", service.getOwnerId());
		serviceColl.update(new BasicDBObject().append("_id", new ObjectId(service.getServiceId())), document);
	}
	

	public void deleteService(String serviceId) {
		BasicDBObject document = new BasicDBObject();
		document.put("_id", new ObjectId(serviceId));
		serviceColl.remove(document);
	}
	
	
	

	
	
	public String createBid(Bid bid)  {
		 String bidId = null;
         BasicDBObject document = new BasicDBObject();
         //document.put("bidderId", bid.getBidderId());
         document.put("serviceId", bid.getServiceId());
         document.put("bidderEmail", bid.getBidderEmail());
         document.put("comment", bid.getComment());

         bidColl.insert(document);
         bidId = document.getString("_id");
         return bidId;	
	}
	public String createCommunity(Community community)  {
		String communityId = null;
		BasicDBObject document = new BasicDBObject();
		document.put("name", community.getName());
		document.put("url", community.getUrl());
		document.put("description", community.getDescription());
	    communityColl.insert(document);
	    communityId = document.getString("_id");
	    return communityId;
	}
	
	
	public List<Community> retrieveAllCommunities() {
		List<Community> communities = new ArrayList<Community>();
	    cursor = communityColl.find();
	    try {
	    	while(cursor.hasNext()) {
	    		Community community = new Community();
	        	BasicDBObject obj = (BasicDBObject) cursor.next();
	        	community.setName(obj.getString("name"));
	        	community.setUrl(obj.getString("url"));
	        	community.setDescription(obj.getString("description"));
	        	communities.add(community);
	    	}
	    }
    	catch (Exception e) {
	    	System.err.println(e.getMessage());
	    	e.printStackTrace();
	    }
	    finally {
	        cursor.close();
	    }
	   
		return communities;
	}
	public String createUser(User user)  {
		String userId = null;
		BasicDBObject doc = new BasicDBObject();
		doc.put("emailId", user.getEmailId());
	    doc.put("firstName", user.getFirstName());
	    doc.put("lastName", user.getLastName());
	    doc.put("password", user.getLastName());
	    doc.put("role", user.getRole());
	    userColl.insert(doc);
	    userId = doc.getString("_id");
		return userId;
	
	}
	
	public void deleteUser(String userid) {
		BasicDBObject document = new BasicDBObject();
		document.put("_id", new ObjectId(userid));
		userColl.remove(document);
	}

	public void updateUser(User user) {
	
		BasicDBObject doc = new BasicDBObject();
		doc.put("emailId", user.getEmailId());
	    doc.put("firstName", user.getFirstName());
	    doc.put("lastName", user.getLastName());
	    doc.put("password", user.getPassword());
	    doc.put("role", user.getRole());
	 //   userColl.update(new BasicDBObject().append("_id", new ObjectId(user.getUserId())), doc);
	}
	
	
	
	public User getUserById(String userId) {
		User user = new User();
	    BasicDBObject query = new BasicDBObject();
		query.put("email", userId);
		DBObject dbObj = userColl.findOne(query);
		
		if (dbObj != null) {
			//user.setUserId(dbObj.get("_id").toString());
			user.setEmailId(dbObj.get("emailId").toString());
			user.setFirstName(dbObj.get("firstName").toString());
			user.setLastName(dbObj.get("lastName").toString());
			user.setPassword(dbObj.get("password").toString());
			user.setRole(dbObj.get("role").toString());
		}
		return user;
	}
	public List<Bid> retrieveOffersByServiceId(String serviceId) {
        List<Bid> bids = new ArrayList<Bid>();
        BasicDBObject query = new BasicDBObject();
         query.put("serviceId", serviceId);
         cursor = bidColl.find(query);
    try {
            while(cursor.hasNext()) {
                Bid bid = new Bid();
                BasicDBObject obj = (BasicDBObject) cursor.next();
                bid.setServiceId(obj.getString("serviceId"));
                //bid.setBidderId(obj.getString("bidderId"));
                bid.setBidderEmail(obj.getString("bidderEmail"));
                bid.setComment(obj.getString("comment"));
                bids.add(bid);
            }
    }
    catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
    }
    finally {
        cursor.close();
    }
        return bids;
}



}