package top.zhuchl.mybatis.dao.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author zclys
 * @date 2021/2/26 15:01
 */
@Alias("UserInfo")
public class UserInfo {

    private Integer sysId;

    private String userAcco;

    private String userName;

    private String phoneNo;

    private String email;

    private Address address;

    private List<Address> adrs;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getUserAcco() {
        return userAcco;
    }

    public void setUserAcco(String userAcco) {
        this.userAcco = userAcco;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getAdrs() {
        return adrs;
    }

    public void setAdrs(List<Address> adrs) {
        this.adrs = adrs;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sysId=" + sysId +
                ", userAcco='" + userAcco + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", adrs=" + adrs +
                '}';
    }
}
