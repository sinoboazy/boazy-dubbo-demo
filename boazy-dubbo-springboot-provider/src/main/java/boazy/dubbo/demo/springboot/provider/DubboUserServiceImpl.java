package boazy.dubbo.demo.springboot.provider;

import boazy.dubbo.demo.api.DubboUserService;
import boazy.dubbo.demo.api.User;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @Company boazy
 * @author boazy
 * @Date Jul 10, 2018
 *
 */
public class DubboUserServiceImpl implements DubboUserService {

	public DubboUserServiceImpl() {
	}

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
		System.out.println("springboot.dubbo.user.username=" + (null != user ? user.getName() : null));
		System.out.println("springboot.dubbo.user.email=" + (null != user ? user.getEmail() : null));
		System.out.println("springboot.dubbo.user.tel=" + (null != user ? user.getTel() : null));
		return JSONObject.toJSONString(user);
	}

}
