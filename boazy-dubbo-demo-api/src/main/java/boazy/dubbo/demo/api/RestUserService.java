package boazy.dubbo.demo.api;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author boazy@126.com
 * @date Jul 10, 2018
 *
 */
@Path("user-srv")
public interface RestUserService extends UserService {
    @GET
    @Path("query")
    @Produces({ ContentType.APPLICATION_JSON_UTF_8 })
    User queryUser(@QueryParam("name") String name);

    @POST
    @Path("register")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ ContentType.APPLICATION_JSON_UTF_8 })
    String registerUser(User user);
}
