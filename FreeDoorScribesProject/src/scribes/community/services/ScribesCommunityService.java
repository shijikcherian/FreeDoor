/**
 * 
 */
package scribes.community.services;


import java.util.List;


import javax.ws.rs.core.Response;

import scribes.community.data.Community;
import scribes.community.DAO.ScribesDataManager;

import scribes.community.restful.interfaces.IScribesCommunityService;
public class ScribesCommunityService implements IScribesCommunityService {
	
	private ScribesDataManager sdm = new ScribesDataManager();
	
	@Override
	public Response createCommunity(Community community) {
		String communityId = sdm.createCommunity(community);
		String result = "Good created : " + communityId + "-" + community;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(201).entity(result).build();
	}

	
	@Override
	public List<Community> retrieveAllCommunities() {
		List<Community> communities = sdm.retrieveAllCommunities();
		return communities;
	}

}
