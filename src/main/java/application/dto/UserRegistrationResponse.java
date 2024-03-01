package application.dto;

import lombok.Data;

@Data
public class UserRegistrationResponse {

    private Long userId;
    private String message;
    private Boolean success;

    public UserRegistrationResponse() {
    }

    public UserRegistrationResponse(Long userId, String message, Boolean success) {
        this.userId = userId;
        this.message = message;
        this.success = success;
    }

}