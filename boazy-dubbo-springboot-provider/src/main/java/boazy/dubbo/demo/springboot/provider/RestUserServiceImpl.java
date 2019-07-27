package boazy.dubbo.demo.springboot.provider;

import boazy.dubbo.demo.api.RestUserService;
import boazy.dubbo.demo.api.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

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
@Service(protocol = "rest")
public class RestUserServiceImpl implements RestUserService {

    @GET
    @Path("query")
    @Produces({ContentType.APPLICATION_JSON_UTF_8})
    @Override
    public User queryUser(@QueryParam("name") String name) {
        return new User(name, "8093", "springboot.rest.user.srv@126.com");
    }

    @POST
    @Path("register")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({ContentType.APPLICATION_JSON_UTF_8})
    @Override
    public String registerUser(User user) {
        if (null == user) {
            System.err.println("null springboot.rest.user.");
            return "{}";
        }
        System.out.println("springboot.rest.user.username=" + user.getName());
        System.out.println("springboot.rest.user.email=" + user.getEmail());
        System.out.println("springboot.rest.user.tel=" + user.getTel());
        return JSONObject.toJSONString(user);
    }

}
