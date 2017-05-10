package cr.tec.genetic;

/**
 * Created by joseph on 5/10/17.
 */
import cr.tec.genetic.struct.EmployeeProto;
import javax.ws.rs.*;

@Path("/employee")
public class EmployeeService {
	@GET
	@Produces("application/x-protobuf")
	public EmployeeProto.Employee getEmployee() {
		return EmployeeProto.Employee.newBuilder()
				.setId(1)
				.setFirstname("Sam")
				.build();
	}
	@POST
	@Consumes("application/x-protobuf")
	@Produces("application/x-protobuf")
	public EmployeeProto.Employee reflect(EmployeeProto.Employee employee) {
		return employee;
	}
}
