package boazy.dubbo.demo.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
@Path("user-srv")
public interface RestUserService extends UserService {
    @GET
    @Path("query")
    @Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    User queryUser(@QueryParam("name") String name);

    @POST
    @Path("register")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
    String registerUser(User user);
}
