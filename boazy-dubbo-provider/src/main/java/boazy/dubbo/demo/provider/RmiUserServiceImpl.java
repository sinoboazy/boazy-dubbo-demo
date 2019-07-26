package boazy.dubbo.demo.provider;

import boazy.dubbo.demo.api.RmiUserService;
import boazy.dubbo.demo.api.User;
import com.alibaba.fastjson.JSONObject;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
public class RmiUserServiceImpl implements RmiUserService {

    @Override
    public User queryUser(String name) {
        return new User(name, "8084", "rmi.user.srv@126.com");
    }

    @Override
    public String registerUser(User user) {
        if (null == user) {
            System.err.println("null rmi.user.");
            return "{}";
        }
        System.out.println("rmi.user.username=" + (null != user ? user.getName() : null));
        System.out.println("rmi.user.email=" + (null != user ? user.getEmail() : null));
        System.out.println("rmi.user.tel=" + (null != user ? user.getTel() : null));
        return JSONObject.toJSONString(user);
    }

}
