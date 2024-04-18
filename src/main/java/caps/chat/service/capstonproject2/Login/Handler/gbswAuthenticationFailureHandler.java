package caps.chat.service.capstonproject2.Login.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.io.IOException;

@Slf4j
@Component
public class gbswAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException{

        String ErrorMessage = "";

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        if(exception instanceof BadCredentialsException) {
            ErrorMessage = "Invalid Username or Password";
        } else if(exception instanceof DisabledException) {
            ErrorMessage = "Locked";
        } else if(exception instanceof CredentialsExpiredException) {
            ErrorMessage = "Expired password";
        }


        objectMapper.writeValue(response.getWriter(), ErrorMessage);
    }
}
