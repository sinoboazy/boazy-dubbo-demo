package boazy.dubbo.demo.provider;

import boazy.dubbo.demo.api.HessianUserService;
import boazy.dubbo.demo.api.User;
import com.alibaba.fastjson.JSONObject;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
public class HessianUserServiceImpl implements HessianUserService {

    @Override
    public User queryUser(String name) {
        return new User(name, "8082", "hessian.user.srv@126.com");
    }

    @Override
    public String registerUser(User user) {
        if (null == user) {
            System.err.println("null hessian.user.");
            return "{}";
        }
        System.out.println("hessian.user.username=" + (null != user ? user.getName() : null));
        System.out.println("hessian.user.email=" + (null != user ? user.getEmail() : null));
        System.out.println("hessian.user.tel=" + (null != user ? user.getTel() : null));
        return JSONObject.toJSONString(user);
    }

}
