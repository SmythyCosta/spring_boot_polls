package br.com.polls.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.polls.payload.LoginRequest;
import br.com.polls.security.JwtTokenProvider;
import br.com.polls.security.util.JwtTokenUtil;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    JwtTokenProvider tokenProvider;
	
	@Bean
	@Order(1)
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.polls.controller"))
				.paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Polls API")
				.description("API documentation for accessing the endpoints of Polls System.").version("1.0")
				.build();
	}
	
	@Bean
	public SecurityConfiguration security() {
		
		String token = null;
		token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTkwNDA5OTgxLCJleHAiOjE1OTEwMTQ3ODF9.aS869tELsEnOvLQzpZczeUqVRfyG3gK8owdckM5whmrzTkATe9wIS5bP66V2aq6kAxhCx-cqy-91PEg3svcB8g";
		/*
		 LoginRequest loginMock = new LoginRequest("smythy.costa@gmail.com", "123456");
		 try {
			
			 Authentication authentication = authenticationManager.authenticate(
		                new UsernamePasswordAuthenticationToken(
		                		loginMock.getUsernameOrEmail(),
		                		loginMock.getPassword()
		                )
		        );

		    SecurityContextHolder.getContext().setAuthentication(authentication);
		    token = tokenProvider.generateToken(authentication);
		    System.out.println("Success Mock for Swagger Token : "+token);
		    
		} catch (Exception e) {
			token = "";
			System.out.println("Error when using user data to move the token : "+e);
		}
    	*/
		return new SecurityConfiguration(null, null, null, null, "Bearer " + token, ApiKeyVehicle.HEADER, "Authorization", ",");
	}
	
}

