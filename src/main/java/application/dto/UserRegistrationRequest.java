package application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.yourcompany.validation.PasswordStrength;

@Data
@NoArgsConstructor
public class UserRegistrationRequest {

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @PasswordStrength
    private String password;

    public UserRegistrationRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
