package top.zhuchl.mybatis.dao.entity;

import org.apache.ibatis.type.Alias;

/**
 * 关联表实体DO
 *
 * @author zclys
 * @date 2021/4/10 9:46
 */
@Alias("Address")
public class Address {

    private String addressId;

    private String provice;

    private String city;

    private String street;

    private String eaHouseAddress;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getEaHouseAddress() {
        return eaHouseAddress;
    }

    public void setEaHouseAddress(String eaHouseAddress) {
        this.eaHouseAddress = eaHouseAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", provice='" + provice + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", eaHouseAddress='" + eaHouseAddress + '\'' +
                '}';
    }
}
