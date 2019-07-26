package boazy.dubbo.demo.provider;

import boazy.dubbo.demo.api.DubboUserService;
import boazy.dubbo.demo.api.User;
import com.alibaba.fastjson.JSONObject;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
public class DubboUserServiceImpl implements DubboUserService {

    public DubboUserServiceImpl() {
    }

    @Override
    public User queryUser(String name) {
        return new User(name, "8081", "dubbo.user.srv@126.com");
    }

    @Override
    public String registerUser(User user) {
        if (null == user) {
            System.err.println("null dubbo.user.");
            return "{}";
        }
        System.out.println("dubbo.user.username=" + (null != user ? user.getName() : null));
        System.out.println("dubbo.user.email=" + (null != user ? user.getEmail() : null));
        System.out.println("dubbo.user.tel=" + (null != user ? user.getTel() : null));
        return JSONObject.toJSONString(user);
    }

}
