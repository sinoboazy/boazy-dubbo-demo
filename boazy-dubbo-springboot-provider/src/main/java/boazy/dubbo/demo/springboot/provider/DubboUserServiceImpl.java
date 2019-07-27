package boazy.dubbo.demo.springboot.provider;

import boazy.dubbo.demo.api.DubboUserService;
import boazy.dubbo.demo.api.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
@Service(protocol = "dubbo")
public class DubboUserServiceImpl implements DubboUserService {

    @Override
    public User queryUser(String name) {
        return new User(name, "8091", "springboot.dubbo.user.srv@126.com");
    }

    @Override
    public String registerUser(User user) {
        if (null == user) {
            System.err.println("null springboot.dubbo.user.");
            return "{}";
        }
        System.out.println("springboot.dubbo.user.username=" + user.getName());
        System.out.println("springboot.dubbo.user.email=" + user.getEmail());
        System.out.println("springboot.dubbo.user.tel=" + user.getTel());
        return JSONObject.toJSONString(user);
    }

}
