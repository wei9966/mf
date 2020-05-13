package mf_offer_system.springboot_02.config;

import mf_offer_system.springboot_02.util.ConstantUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Create By WeiBin on 2020/5/10 23:36
 *
 * @author WB
 */
@Component
public class MyLoginSuccessHandle implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获取角色
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals(ConstantUtil.USER_TYPE_ADMIN)) {
                //管理员去到修改界面
                response.sendRedirect("/user/administrator");
            }
            if (authority.getAuthority().equals(ConstantUtil.USER_TYPE_NORMAL_BLACK)) {
                //普通用户去到报价界面,然后根据不同权限显示不同页面
                //保存session
                request.getSession().setAttribute("user", "black");
                response.sendRedirect("/user/person");
            }
            if (authority.getAuthority().equals(ConstantUtil.USER_TYPE_NORMAL_COLOR)) {
                //普通用户去到报价界面,然后根据不同权限显示不同页面
                request.getSession().setAttribute("user", "color");
                response.sendRedirect("/user/person");
            }
        }
    }
}
