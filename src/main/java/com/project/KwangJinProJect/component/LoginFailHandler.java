package com.project.KwangJinProJect.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Slf4j
public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
      log.info("로그인 실패");

      String errorMSG;
      if (exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) {
          errorMSG = "아이디 또는 비밀번호가 맞지 않습니다.";
      } else if (exception instanceof UsernameNotFoundException) {
          errorMSG = "존재하지 않는 아이디입니다.";
      } else {
          errorMSG = "이유 모름";
      }

      errorMSG = URLEncoder.encode(errorMSG, "UTF-8");
      setDefaultFailureUrl("/loginPage?error=true&exception=" + errorMSG);
        super.onAuthenticationFailure(request, response, exception);
    }
}
