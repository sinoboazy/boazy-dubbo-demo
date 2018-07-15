package boazy.dubbo.demo.api;

/**
 *
 * @Company boazy
 * @author boazy
 * @Date Jul 10, 2018
 *
 */
public interface UserService {
    User queryUser(String name);
    String registerUser(User user);
}
