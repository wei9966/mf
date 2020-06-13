package mf_offer_system.springboot_02.config;

import mf_offer_system.springboot_02.service.impl.MfUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Create By WeiBin on 2020/5/10 23:14
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MfUserServiceImpl mfUserServiceImpl;

    /**
     * 进行身份认证
     *
     * @param authentication 身份信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取输入的用户名和密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("输入的用户名" + name + "\t密码" + password);
        UserDetails userDetails = mfUserServiceImpl.loadUserByUsername(name);
        //进行密码比对
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //进行比对结果
        System.out.println("查询的用户名和密码" + userDetails.getUsername() + "\t查询的密码" + userDetails.getPassword());
        boolean flag = password.equals(userDetails.getPassword());
        System.out.println("用户名密码是否正确" + flag);
        if (flag) {
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }
        //验证失败返回null
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
