/**
 * 
 */
package scribes.community.interfaces;

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



import scribes.community.data.*;

@Path("/goods")
public interface IScribesGoodsService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Good> getAllGoods();
	
	@Path("/creategood")
	@POST
	@Consumes( { MediaType.APPLICATION_JSON } )
	public Response createGood (Good good);
	
	
	
}
