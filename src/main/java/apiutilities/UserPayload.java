package apiutilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPayload {

    @JsonProperty("id")
    private int id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("userStatus")
    private int userStatus;

    public UserPayload(int idNo, String userName, String firstname, String lastname, String emailAdd, String passWord, String phoneNo, int userstatus) {
        this.id = idNo;
        this.username = userName;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = emailAdd;
        this.password = passWord;
        this.phone = phoneNo;
        this.userStatus = userstatus;
    }

}
