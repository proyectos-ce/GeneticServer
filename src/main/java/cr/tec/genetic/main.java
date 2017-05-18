package cr.tec.genetic;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import cr.tec.genetic.struct.EmployeeProto.Employee;
import cr.tec.genetic.struct.EmployeeProto.Department;

import com.google.protobuf.Parser;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Created by joseph on 5/9/17.
 */
public class main {

	public static void main(String[] args) {





		// creating the employee
		Employee john = Employee.newBuilder()
				.setId(1)
				.setFirstname("John")
				.setLastname("Villegas")
				.setCountry("CR")
				.setSalary(100000)
				.addDept(
					Department.newBuilder()
						.setDeptname("Finance")
				)
				.addDept(
					Department.newBuilder()
						.setDeptname("Administration")
				)
				.build();

		try {
			System.out.println(JsonFormat.printer().print(john));
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}




		try {
			FileOutputStream output = new FileOutputStream("/home/joseph/data.bin");
			john.writeTo(output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
