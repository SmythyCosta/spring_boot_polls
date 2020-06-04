package br.com.polls.payload;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	
	@NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    public LoginRequest() {
		// TODO Auto-generated constructor stub
	}
    
    public LoginRequest(@NotBlank String usernameOrEmail, @NotBlank String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}

}
