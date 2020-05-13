package mf_offer_system.springboot_02.controller.authentication;

import lombok.extern.slf4j.Slf4j;
import mf_offer_system.springboot_02.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create By WeiBin on 2020/5/11 23:20
 */
@RestController
@Slf4j
public class BrowserSecurityController {
    //缓存最开始引发跳转的请求
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份验证时，跳转到这里
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)//未授权的状态码
    public JsonResult requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求时：" + targetUrl);
            //判断访问的url是否为一个.HTML后缀格式的请求
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                //重定向
                redirectStrategy.sendRedirect(request, response, "/user/login");
            }
        }
        return new JsonResult("400", "返回的服务需要身份认证，请引到用户到登陆页面");
    }
}
