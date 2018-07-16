/**
 * 
 */
package boazy.dubbo.demo.springboot.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @Company boazy
 * @author boazy
 * @Date Jul 10, 2018
 *
 */
@SpringBootApplication
@ImportResource({"classpath:/dubbo-demo-provider.xml"})
public class ProviderSpringBootApp {

	public static void main(String[] args) {
		System.out.println("dubbo springboot provider start...");
		SpringApplication.run(ProviderSpringBootApp.class, args);
		System.out.println("dubbo springboot provider started.");
	}

}