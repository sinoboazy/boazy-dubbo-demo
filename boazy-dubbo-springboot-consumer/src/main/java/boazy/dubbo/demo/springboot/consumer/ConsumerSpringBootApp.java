/**
 * 
 */
package boazy.dubbo.demo.springboot.consumer;

import boazy.dubbo.demo.api.DubboUserService;
import boazy.dubbo.demo.api.RestUserService;
import boazy.dubbo.demo.api.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
@SpringBootApplication
public class ConsumerSpringBootApp {

	@Reference(protocol = "dubbo")
	private DubboUserService dubboUserService;
	@Reference(protocol = "rest")
	private RestUserService restUserService;

	public static void main(String[] args) {
		System.out.println("dubbo springboot consumer start...");
		SpringApplication.run(ConsumerSpringBootApp.class, args);
		System.out.println("dubbo springboot consumer end.");
	}

	@Bean
	public ApplicationRunner runner() {
		return args -> {
			try {
				User user = dubboUserService.queryUser("springboot.dubboUser");
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println(user.getTel());
				dubboUserService.registerUser(new User("springboot.reg.dubboUser", "80088008-8091", "springboot.reg.dubboUser.job"));
			} catch (Exception e) {
				System.out.println("dubboUserService invoking error.");
				e.printStackTrace();
			}

			try {
				restUserService.registerUser(new User("springboot.reg.restUser", "80088008-8093", "springboot.restUser@126.com"));
			} catch (Exception e) {
				System.out.println("restUserService invoking error.");
				e.printStackTrace();
			}
		};
	}

}