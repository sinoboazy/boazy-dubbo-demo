package boazy.dubbo.demo.provider;

import org.apache.dubbo.container.Main;

/**
 * @author boazy@126.com
 * @date Jul 10, 2018
 */
public class ProviderApp {

    public static void main(String[] args) {
        System.out.println("dubbo provider start...");
        Main.main(args);
        System.out.println("dubbo provider started.");
    }

}
