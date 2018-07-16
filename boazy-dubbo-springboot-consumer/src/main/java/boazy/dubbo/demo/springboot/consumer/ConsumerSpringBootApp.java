/**
 * 
 */
package boazy.dubbo.demo.springboot.consumer;

import java.io.IOException;

import boazy.dubbo.demo.api.RestUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import boazy.dubbo.demo.api.DubboUserService;
import boazy.dubbo.demo.api.User;

/**
 * 
 * @Company boazy
 * @author boazy
 * @Date Jul 10, 2018
 *
 */
@SpringBootApplication
@ImportResource({"classpath:/dubbo-demo-consumer.xml"})
public class ConsumerSpringBootApp {

	public static void main(String[] args) throws IOException {
		System.out.println("dubbo springboot consumer start...");
		ApplicationContext ctx = SpringApplication.run(ConsumerSpringBootApp.class, args);
		
		try {
			DubboUserService dubboUserService = (DubboUserService) ctx.getBean("dubboUserService");
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
			RestUserService restUserService = (RestUserService) ctx.getBean("restUserService");
			restUserService.registerUser(new User("springboot.reg.restUser", "80088008-8093", "springboot.restUser@126.com"));
		} catch (Exception e) {
			System.out.println("restUserService invoking error.");
			e.printStackTrace();
		}
		
		System.out.println("dubbo springboot consumer end.");
		System.in.read();
	}

}