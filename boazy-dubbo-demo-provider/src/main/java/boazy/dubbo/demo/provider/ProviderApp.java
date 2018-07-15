package boazy.dubbo.demo.provider;

import com.alibaba.dubbo.container.Main;

/**
 *
 * @Company boazy
 * @author boazy
 * @Date Jul 10, 2018
 *
 */
public class ProviderApp {

    public static void main(String[] args) {
        System.out.println("dubbo provider start...");
        Main.main(args);
        System.out.println("dubbo provider started.");
    }

}
