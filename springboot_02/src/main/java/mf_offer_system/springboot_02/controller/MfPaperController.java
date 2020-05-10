package mf_offer_system.springboot_02.controller;

import mf_offer_system.springboot_02.entity.MfPaper;
import mf_offer_system.springboot_02.service.MfPaperService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 纸张类型(MfPaper)表控制层
 *
 * @author makejava
 * @since 2020-05-09 20:50:39
 */
@RestController
@RequestMapping("mfPaper")
public class MfPaperController {
    /**
     * 服务对象
     */
    @Resource
    private MfPaperService mfPaperService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfPaper selectOne(Integer id) {
        return this.mfPaperService.queryById(id);
    }

}