package mf_offer_system.springboot_02.controller;

import mf_offer_system.springboot_02.entity.MfTonprice;
import mf_offer_system.springboot_02.service.MfTonpriceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 吨价表(MfTonprice)表控制层
 *
 * @author makejava
 * @since 2020-05-09 20:51:09
 */
@RestController
@RequestMapping("mfTonprice")
public class MfTonpriceController {
    /**
     * 服务对象
     */
    @Resource
    private MfTonpriceService mfTonpriceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfTonprice selectOne(Integer id) {
        return this.mfTonpriceService.queryById(id);
    }

}