package cr.tec.genetic;


import javax.ws.rs.*;
import javax.ws.rs.core.*;


/**
 * Created by joseph on 5/26/17.
 */
@Path("/genetic")
public class GeneticService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Track getEmployee() {
		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}
}

