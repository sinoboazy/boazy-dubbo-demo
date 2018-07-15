package boazy.dubbo.demo.provider;

import boazy.dubbo.demo.api.RestUserService;
import boazy.dubbo.demo.api.User;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @Company boazy
 * @author boazy
 * @Date Jul 10, 2018
 *
 */
@Path("user-srv")
public class RestUserServiceImpl implements RestUserService {

	public RestUserServiceImpl() {
	}

	@GET
	@Path("query")
	@Produces({ ContentType.APPLICATION_JSON_UTF_8 })
	@Override
	public User queryUser(@QueryParam("name") String name) {
		return new User(name, "8083", "rest.user.srv@126.com");
	}

	@POST
	@Path("register")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ ContentType.APPLICATION_JSON_UTF_8 })
	@Override
	public String registerUser(User user) {
		if (null == user) {
			System.err.println("null rest.user.");
			return "{}";
		}
		System.out.println("rest.user.username=" + (null != user ? user.getName() : null));
		System.out.println("rest.user.email=" + (null != user ? user.getEmail() : null));
		System.out.println("rest.user.tel=" + (null != user ? user.getTel() : null));
		return JSONObject.toJSONString(user);
	}

}
