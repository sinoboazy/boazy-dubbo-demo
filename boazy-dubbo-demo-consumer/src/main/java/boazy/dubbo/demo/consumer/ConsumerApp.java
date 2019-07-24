package boazy.dubbo.demo.consumer;

import boazy.dubbo.demo.api.DubboUserService;
import boazy.dubbo.demo.api.HessianUserService;
import boazy.dubbo.demo.api.RestUserService;
import boazy.dubbo.demo.api.RmiUserService;
import boazy.dubbo.demo.api.User;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
public class ConsumerApp {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        System.out.println("dubbo consumer start...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath*:/META-INF/spring/*.xml"});
        context.start();

        try {
            DubboUserService dubboUserService = (DubboUserService) context.getBean("dubboUserService");
            User user = dubboUserService.queryUser("dubboUser");
            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println(user.getTel());
            dubboUserService.registerUser(new User("reg.dubboUser", "80808080-8081", "reg.dubboUser@126.com"));
        } catch (Exception e) {
            System.out.println("dubboUserService invoking error.");
            e.printStackTrace();
        }

        try {
            HessianUserService hessianUserService = (HessianUserService) context.getBean("hessianUserService");
            RpcContext.getContext();
            hessianUserService.registerUser(new User("reg.hessianUser", "80808080-8082", "hessianUser@126.com"));
        } catch (Exception e) {
            System.out.println("hessianUserService invoking error.");
            e.printStackTrace();
        }

        try {
            RmiUserService rmiUserService = (RmiUserService) context.getBean("rmiUserService");
            rmiUserService.registerUser(new User("reg.rmiUser", "80808080-8084", "rmiUser@126.com"));
        } catch (Exception e) {
            System.out.println("rmiUserService invoking error.");
            e.printStackTrace();
        }

        try {
            RestUserService restUserService = (RestUserService) context.getBean("restUserService");
            restUserService.registerUser(new User("reg.restUser", "80808080-8083", "restUser@126.com"));
        } catch (Exception e) {
            System.out.println("restUserService invoking error.");
            e.printStackTrace();
        }

        System.out.println("dubbo consumer end.");
        System.in.read();
    }

}
