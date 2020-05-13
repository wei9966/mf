package mf_offer_system.springboot_02.controller.administrators.color;

import mf_offer_system.springboot_02.entity.MfColor;
import mf_offer_system.springboot_02.service.MfColorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 墨色表(MfColor)表控制层
 *
 * @author makejava
 * @since 2020-05-09 20:48:24
 */
@RestController
@RequestMapping("mfColor")
public class MfColorController {
    /**
     * 服务对象
     */
    @Resource
    private MfColorService mfColorService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfColor selectOne(Integer id) {
        return this.mfColorService.queryById(id);
    }

}