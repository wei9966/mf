package mf_offer_system.springboot_02.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户表(MfUser)实体类
 *
 * @author makejava
 * @since 2020-05-10 22:39:31
 */
@Data
public class MfUser implements Serializable, UserDetails {
    private static final long serialVersionUID = -45909892187862895L;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 角色id
     */
    private List<MfRole> roles;
    /**
     * 角色id
     */
    private Integer roleId;
    private boolean enabled;
    private boolean locked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (MfRole mfRole : roles) {
            authorities.add(new SimpleGrantedAuthority(mfRole.getRoleType()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}