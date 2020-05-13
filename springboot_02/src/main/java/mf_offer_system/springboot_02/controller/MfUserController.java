package mf_offer_system.springboot_02.controller;

import mf_offer_system.springboot_02.entity.MfUser;
import mf_offer_system.springboot_02.service.MfUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(MfUser)表控制层
 *
 * @author makejava
 * @since 2020-05-10 22:39:31
 */
@RestController
@RequestMapping("mfUser")
public class MfUserController {
    /**
     * 服务对象
     */
    @Resource
    private MfUserService mfUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfUser selectOne(Integer id) {
        return this.mfUserService.queryById(id);
    }

    

}