package FrescoPlay.Springboot.HandsOn2.Authentication;



import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component

public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {



@Override

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)

      throws IOException {

        response.addHeader("LoginUser", "Basic " +getRealmName());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        PrintWriter writer = response.getWriter();

        writer.println("HTTP Status 401 - " + authEx.getMessage());

    }

	@Override

	public void afterPropertiesSet() {

        setRealmName("springboot");

        super.afterPropertiesSet();

   }



}