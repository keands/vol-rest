package vol;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Provider
@Consumes("application/json")
@Produces("application/json")
public class MyAppJsonProvider extends JacksonJsonProvider {
}