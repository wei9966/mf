package mf_offer_system.springboot_02.controller;

import mf_offer_system.springboot_02.entity.MfType;
import mf_offer_system.springboot_02.service.MfTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 报价类型表(MfType)表控制层
 *
 * @author makejava
 * @since 2020-05-09 20:51:18
 */
@RestController
@RequestMapping("mfType")
public class MfTypeController {
    /**
     * 服务对象
     */
    @Resource
    private MfTypeService mfTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfType selectOne(Integer id) {
        return this.mfTypeService.queryById(id);
    }

}