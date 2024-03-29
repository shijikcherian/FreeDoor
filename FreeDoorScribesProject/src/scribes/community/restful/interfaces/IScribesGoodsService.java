/**
 * 
 */
package scribes.community.restful.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import scribes.community.data.Bid;

import scribes.community.data.Good;
@Path("/goods")
public interface IScribesGoodsService {
	//http://localhost:8080/scribesfreedoor/goods
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	public List<Good> getAllGoods();
	
		
		@Path("/{id}")
		@GET
		@Produces( {   MediaType.APPLICATION_JSON } )
		public Good getGoodById (@PathParam("id") String id);
		//public Good getGoodById (@PathParam("id") String id);
		
		@POST
		@Consumes( { MediaType.APPLICATION_JSON } )

		public Response createGood (Good good);
		
		
		@Path("/{id}")
		@PUT

		@Consumes( { MediaType.APPLICATION_JSON } )

		public Response updateGood (@PathParam("id") String id, Good good);
		//public Response updateGood (@PathParam("id") String id, Good good);
		
		
		@Path("/{id}")
		@DELETE
		public Response deleteGood (@PathParam("id") String id);
		
		
	/*	
		@Path("/{id}/offers")
		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		public List<Bid> getBidsByGoodId (@PathParam("id") String id);
		*/
		
		//add a new bid to a goodId
		@Path("/{id}/offers")
		@POST
		@Consumes({ MediaType.APPLICATION_JSON })
		public Response createBid (@PathParam("id") String goodId, Bid bid);
		
		

		@Path("/search")
		@POST

		@Produces({ MediaType.APPLICATION_JSON })

		public List<Good> getGoodsBySearchCriteria ( String name, @QueryParam("status") String status,
										 @QueryParam("createrEmail") String createrEmail, @QueryParam("ownerId") String ownerId);

		
		@Path("/searchname")
		@POST
		@Produces({ MediaType.APPLICATION_JSON })
		@Consumes( { MediaType.APPLICATION_JSON } )
		public List<Good> getGoodsByNameCriteria (String name);
		
	

	
}
