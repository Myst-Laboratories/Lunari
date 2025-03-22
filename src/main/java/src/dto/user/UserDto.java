package src.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {

    @NotEmpty(message = "Username is required")
    private String uName;
    @Email(message = "Email is invalid")
    private String uEmail;

    private String uPassword;

    public UserDto() {}

    public UserDto(String uName, String uEmail, String uPassword) {
        super();
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPassword = uPassword;
    }

    public String getUName() {
        return this.uName;
    }
    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUEmail() {
        return this.uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getUPassword() {
        return this.uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }






}
