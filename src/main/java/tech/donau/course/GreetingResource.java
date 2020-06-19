package tech.donau.course;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class GreetingResource {
    public static final String TOKEN = "dev";

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello " + UUID.randomUUID().toString();
    }

    @GET
    @Path("/html/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return "Hello, " + name;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addHello(@HeaderParam("token") String hName, @QueryParam("token") String qName, String body) {
        String token = hName != null ? hName : qName;
        if (!TOKEN.equals(token)) {
            throw new RuntimeException("Unauthorized");
        }
        return "<h2>Hello, " + token + "!</h2>";
    }
}