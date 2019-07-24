package boazy.dubbo.demo.provider;

import boazy.dubbo.demo.api.RestUserService;
import boazy.dubbo.demo.api.User;
import com.alibaba.fastjson.JSONObject;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
public class RestUserServiceImpl implements RestUserService {

    public User queryUser(String name) {
        return new User(name, "8083", "rest.user.srv@126.com");
    }

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
