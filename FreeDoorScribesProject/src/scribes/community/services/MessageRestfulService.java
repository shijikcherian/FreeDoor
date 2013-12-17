/**
 * 
 */
package scribes.community.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/** test purpose for restful up and running by using Apache wink **/


@Path("/message")
public class MessageRestfulService {
	/**
	 * 
	 * @param msg
	 * @return
	 */
	//http://localhost:8080/FreeDoorScribes/rest/message/{message}
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {
		String result = "Restful example : " + msg;
		return Response.status(200).entity(result).build();
 
	}
	
	
	/**
	 * <pre>
	 * curl -X GET -H 'Accept:application/json' http://localhost:8080/simple/rest/simple/about
	 * </pre>
	 * 
	 * @return
	 */
	
	//http://localhost:8080/scribesfreedoor/message/about
	@Path("/about")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String about() {
		System.out.println("---> MessageRestfulService: about");
		return "{\"about\" : \"a test for restful service up and running only, no business scanrios here\"}";
	}

}
