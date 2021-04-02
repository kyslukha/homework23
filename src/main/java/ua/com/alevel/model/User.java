package ua.com.alevel.model;

public class User {
    Integer user_id;
    String name;
    String last_name;
    String address;
    Integer post_code;
    String email;

    public User(String name, String last_name, String address,  String email) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {return last_name; }

    public void setLast_name (String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer user_id, String name, String last_name, String address, Integer post_code, String email) {
        this.user_id = user_id;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
    }
}
