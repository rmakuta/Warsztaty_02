package pl.coderslab.user;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int groupId;

    public User() {
    }

    public User(String name, String email, String password, int groupId) {
        this.name = name;
        this.email = email;
        this.hashPassword(password);
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.hashPassword(password);
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void hashPassword(String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
