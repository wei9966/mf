package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.dao.MfRoleDao;
import mf_offer_system.springboot_02.dao.MfUserDao;
import mf_offer_system.springboot_02.entity.MfRole;
import mf_offer_system.springboot_02.entity.MfUser;
import mf_offer_system.springboot_02.service.MfUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户表(MfUser)表服务实现类
 *
 * @author makejava
 * @since 2020-05-10 22:39:31
 */
@Service("mfUserService")
public class MfUserServiceImpl implements MfUserService, UserDetailsService {
    @Resource
    private MfUserDao mfUserDao;
    @Resource
    private MfRoleDao mfRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public MfUser queryById(Integer userId) {
        return this.mfUserDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MfUser> queryAllByLimit(int offset, int limit) {
        return this.mfUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfUser 实例对象
     * @return 实例对象
     */
    @Override
    public MfUser insert(MfUser mfUser) {
        this.mfUserDao.insert(mfUser);
        return mfUser;
    }

    /**
     * 修改数据
     *
     * @param mfUser 实例对象
     * @return 实例对象
     */
    @Override
    public MfUser update(MfUser mfUser) {
        this.mfUserDao.update(mfUser);
        return this.queryById(mfUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.mfUserDao.deleteById(userId) > 0;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        MfUser mfUser = new MfUser();
        mfUser.setUserName(userName);
        List<MfUser> mfUsers = mfUserDao.queryAll(mfUser);
        if (!(mfUsers.size() > 0)) {
            throw new RuntimeException("账户不存在");
        }
        //获取这个用户的权限
        MfUser myUser = mfUsers.get(0);
        MfRole mfRole = mfRoleDao.queryById(myUser.getRoleId());
        ArrayList<MfRole> list = new ArrayList<>();
        list.add(mfRole);
        myUser.setRoles(list);
        System.out.println("用户信息" + myUser);
        return myUser;
    }
}