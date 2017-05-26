package cr.tec.genetic;


import cr.tec.genetic.geneticStructures.DNA;
import cr.tec.genetic.geneticStructures.PopulationManager;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Vector;


/**
 * Created by joseph on 5/26/17.
 */
@Path("/genetic")
public class GeneticService {

	private static PopulationManager pop1 = new PopulationManager();
	private static PopulationManager pop2 = new PopulationManager();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/{id}")
	public Vector<DNA> getFirstPopulation(@PathParam("id") int id) {
		if (id == 1) {
			pop1.initialize(50);
			return pop1.getPopulation();
		} else {
			pop2.initialize(50);
			return pop2.getPopulation();
		}
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{id}")
	public Vector<DNA> updatePopulation(@PathParam("id") int id, Vector<DNA> vector) {
		if (id == 1) {
			pop1.setPopulation(vector);
			pop1.createNextGeneration();
			return pop1.getPopulation();

		} else {
			pop2.setPopulation(vector);
			pop2.createNextGeneration();
			return pop2.getPopulation();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get/{id}")
	public Vector<DNA> getPopulation(@PathParam("id") int id) {
		if (id == 1) {
			return pop1.getPopulation();
		} else {
			return pop2.getPopulation();
		}
	}
}

