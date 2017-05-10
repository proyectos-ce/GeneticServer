package cr.tec.genetic;

/**
 * Created by joseph on 5/10/17.
 */
import javax.ws.rs.core.MediaType;

/**
 * Protobuf media type constants: string mime type and JAX-RS MediaType.
 *
 * @author Alexander Shabanov
 */
public final class ProtobufMediaType {
	private ProtobufMediaType() {}

	public static final String MIME = "application/x-protobuf";

	public static final MediaType MEDIA_TYPE = new MediaType("application", "x-protobuf");
}