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
import scribes.community.data.Service;

@Path("/services")
public interface IScribesServicesService {
	//http://localhost:8080/scribesfreedoor/services
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	List<Service> getAllServices();
	
	@Path("/{id}")
	@GET
	@Produces( {   MediaType.APPLICATION_JSON } )
	public Service getServiceById (@PathParam("id") String id);
	
	@POST
	@Consumes( { MediaType.APPLICATION_JSON } )
	public Response createService (Service good);
	
	@Path("/{id}")
	@PUT
	@Consumes( { MediaType.APPLICATION_JSON } )
	public Response updateService (@PathParam("id") String id, Service good);
	
	@Path("/{id}")
	@DELETE
	public Response deleteService (@PathParam("id") String id);
	
	@Path("/offers/{serviceId}")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Bid> getBidsByServiceId (@PathParam("serviceId") String serviceId);
	
	 //add a new bid to a goodId
    @Path("/offers/{serviceId}")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response createBid (@PathParam("serviceId") String serviceId, Bid bid);
	
	//return a service by search criteria
	@Path("/search")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Service> getServicesBySearchCriteria (@QueryParam("name") String name, @QueryParam("status") String status,
			 		@QueryParam("createrEmail") String createrEmail, @QueryParam("ownerId") String ownerId);

}
	



