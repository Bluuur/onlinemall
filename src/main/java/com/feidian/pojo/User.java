package com.feidian.pojo;


import java.util.Objects;

public class User {

    private Long uid;
    private String userName;
    private String gender;
    private String birthday;
    private String password;
    private String consignee;
    private Long phoneNumber;
    private String address;

    public User() {
    }

    public User(Long uid, String userName, String gender, String birthday, String password, String consignee, Long phoneNumber, String address) {
        this.uid = uid;
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.password = password;
        this.consignee = consignee;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", password='" + password + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) && Objects.equals(userName, user.userName) && Objects.equals(gender, user.gender) && Objects.equals(birthday, user.birthday) && Objects.equals(password, user.password) && Objects.equals(consignee, user.consignee) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, userName, gender, birthday, password, consignee, phoneNumber, address);
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
