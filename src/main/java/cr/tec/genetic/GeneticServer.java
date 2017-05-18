package cr.tec.genetic;

import cr.tec.genetic.struct.GreeterGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

import cr.tec.genetic.struct.EmployeeProto.HelloReply;
import cr.tec.genetic.struct.EmployeeProto.HelloRequest;
import io.grpc.stub.StreamObserver;


/**
 * Created by joseph on 5/17/17.
 */
public class GeneticServer {
	private Server server;
	private static final Logger logger = Logger.getLogger(GeneticServer.class.getName());

	private void start() throws IOException {
		int port = 50531;
		server = ServerBuilder.forPort(port).build().start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				// Use stderr here since the logger may have been reset by its JVM shutdown hook.
				System.err.println("*** shutting down gRPC server since JVM is shutting down");
				GeneticServer.this.stop();
				System.err.println("*** server shut down");
			}
		});
	}

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	/**
	 * Main launches the server from the command line.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		final GeneticServer server = new GeneticServer();
		server.start();
		server.blockUntilShutdown();
	}

	static class GreeterImpl extends GreeterGrpc.GreeterImplBase {

		@Override
		public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
			HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		}
	}
}
