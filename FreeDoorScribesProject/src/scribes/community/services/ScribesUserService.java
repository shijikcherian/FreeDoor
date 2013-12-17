/**
 * 
 */
package scribes.community.services;



import javax.ws.rs.PathParam;

import javax.ws.rs.core.Response;


import scribes.community.data.User;
import scribes.community.restful.interfaces.IScribesUserService;
import scribes.community.DAO.ScribesDataManager;


public class ScribesUserService implements IScribesUserService {

	private ScribesDataManager sdm = new ScribesDataManager();


	@Override
	public Response createUser(User user) {
		String userId = sdm.createUser(user);
		System.out.println("Created user");	
		String result = "User created: " + userId + "-" + user;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(201).entity(result).build();   
	}


	@Override
	public Response updateUser(@PathParam("id") String userId, User user) {
		user.setUserId(userId);
		sdm.updateUser(user);
		String result = "User Updated : " + userId;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(200).entity(result).build();
	}


	@Override
	public Response deleteUser(@PathParam("id") String userId) {
		sdm.deleteUser(userId);
		String result = "User Deleted : " + userId;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(200).entity(result).build();
	}


	/*@Override
	public User getUserById(@PathParam("id") String userId) {
		User user = null;		
		try {
			user = sdm.getUserById(userId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public Response getUserByEmailId(String userId, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}
	

	*/
}

