package src.model.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long uId;

    @Column(unique = true, nullable = false)
    private String uName;

    @Column(unique = true, nullable = false)
    private String uEmail;

    @Column(nullable = false)
    private String password;


    public User() {
    }

    public User(String uName, String password, String uEmail) {

        this.uName = uName;
        this.password = password;
        this.uEmail = uEmail;
    }

    public Long getUserId() {
        return this.uId;
    }

    public void setUserId(Long uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return this.uName;
    }

    public void setUserName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.uEmail;
    }

    public void setEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Override
    public String toString() {
        return "User: " + this.uName + " | " + "Email: " + this.uEmail;
    }












}
