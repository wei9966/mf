package mf_offer_system.springboot_02.controller;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.service.MfOfferService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 明发报价表(MfOffer)表控制层
 *
 * @author makejava
 * @since 2020-05-09 23:48:09
 */
@RestController
@RequestMapping("mfOffer")
public class MfOfferController {
    /**
     * 服务对象
     */
    @Resource
    private MfOfferService mfOfferService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfOffer selectOne(Long id) {
        return this.mfOfferService.queryById(id);
    }

}