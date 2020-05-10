package mf_offer_system.springboot_02.controller;

import mf_offer_system.springboot_02.entity.MfAmoun;
import mf_offer_system.springboot_02.service.MfAmounService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 复膜(MfAmoun)表控制层
 *
 * @author makejava
 * @since 2020-05-09 23:48:23
 */
@RestController
@RequestMapping("mfAmoun")
public class MfAmounController {
    /**
     * 服务对象
     */
    @Resource
    private MfAmounService mfAmounService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfAmoun selectOne(Integer id) {
        return this.mfAmounService.queryById(id);
    }

}