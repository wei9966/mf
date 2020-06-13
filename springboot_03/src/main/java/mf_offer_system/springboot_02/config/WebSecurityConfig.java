package mf_offer_system.springboot_02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Create By WeiBin on 2020/5/10 22:51
 *
 * @author WB
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 进行登录之后的判断用的
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 放行登录
                .antMatchers("/login/**","/static/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // 开启表单认证
                .formLogin()
                // 地址写的是 映射的路径
//                .loginPage("/user/login")
                // 必须添加
//                .loginProcessingUrl("/login")
                .permitAll()
                // 第二个参数，如果不写成true，则默认登录成功以后，访问之前被拦截的页面，而非去我们规定的页面
                .defaultSuccessUrl("/user/person", true).successHandler(new MyLoginSuccessHandle())
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .csrf()
                .disable()
                .httpBasic();
        //X-Content-Type-Options头设置应许加载静态资源
        http.headers().frameOptions().sameOrigin();
    }
}
