package mf_offer_system.springboot_02.controller;

import mf_offer_system.springboot_02.entity.MfBingding;
import mf_offer_system.springboot_02.service.MfBingdingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 装订方式(MfBingding)表控制层
 *
 * @author makejava
 * @since 2020-05-09 23:48:31
 */
@RestController
@RequestMapping("mfBingding")
public class MfBingdingController {
    /**
     * 服务对象
     */
    @Resource
    private MfBingdingService mfBingdingService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfBingding selectOne(Integer id) {
        return this.mfBingdingService.queryById(id);
    }

}