package mf_offer_system.springboot_02.config;

import com.alibaba.fastjson.JSON;
import mf_offer_system.springboot_02.util.JsonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create By WeiBin on 2020/5/11 21:36
 * @author WB
 */
@Component
public class MySimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JsonResult jsonResult = new JsonResult("400", "登录失败");
        httpServletResponse.getWriter().write(JSON.toJSONString(jsonResult));
    }
}

