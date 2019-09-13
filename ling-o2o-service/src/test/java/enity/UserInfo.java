package enity;

import javax.persistence.*;

@Entity
@Table(name = "user_info_test")
public class UserInfo {

    @Id
    @Column(name = "user_name")
    private String userName;
    private String passwd;
    private String name;
    private String mobile;
    private String valid;
    @Version
    private Integer version;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getValid() {
        return valid;
    }

}