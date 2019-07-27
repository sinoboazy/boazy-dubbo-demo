package boazy.dubbo.demo.springboot.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
@EnableAutoConfiguration
public class ProviderSpringBootApp {

    public static void main(String[] args) {
        System.out.println("dubbo springboot provider start...");
        SpringApplication.run(ProviderSpringBootApp.class, args);
        System.out.println("dubbo springboot provider started.");
    }

}