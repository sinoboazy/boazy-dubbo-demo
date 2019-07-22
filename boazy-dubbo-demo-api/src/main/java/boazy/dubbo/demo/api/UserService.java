package boazy.dubbo.demo.api;

/**
 *
 * @author boazy@126.com
 * @date Jul 10, 2018
 *
 */
public interface UserService {
    User queryUser(String name);
    String registerUser(User user);
}
