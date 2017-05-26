package cr.tec.genetic;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by joseph on 5/26/17.
 */
public class Application extends ResourceConfig {
	public Application() {
		register(JacksonFeature.class);
	}
}
