package boazy.dubbo.demo.api;

import java.io.Serializable;

/**
 *
 * @author boazy@126.com
 * @Date Jul 10, 2018
 *
 */
public class User implements Serializable {
    private static final long serialVersionUID = -2126520241783756715L;

    private String name;
    private String tel;
    private String email;

    public User() {
    }

    public User(String name, String tel, String email) {
        this.name = name;
        this.tel = tel;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
