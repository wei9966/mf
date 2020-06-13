package mf_offer_system.springboot_02.controller.administrators.ton;

import mf_offer_system.springboot_02.entity.MfTonprice;
import mf_offer_system.springboot_02.service.MfTonpriceService;
import mf_offer_system.springboot_02.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 吨价表(MfTonprice)表控制层
 *
 * @author makejava
 * @since 2020-05-09 20:51:09
 */
@Controller
@RequestMapping("mfTonprice")
public class MfTonpriceController {
    /**
     * 服务对象
     */
    @Resource
    private MfTonpriceService mfTonpriceService;

    @RequestMapping("/tonPage")
    public String toTonPage(Model model) {
        //查询出所有的吨价表
        List<MfTonprice> mfTonprices = mfTonpriceService.queryAllByLimit(0, 10);
        model.addAttribute("mfTonprices", mfTonprices);
        return "administrators/administrator_ton";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    @ResponseBody
    public MfTonprice selectOne(@PathVariable("id") Integer id) {
        return this.mfTonpriceService.queryById(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult updateOne(@RequestBody MfTonprice mfTonprice) {
        this.mfTonpriceService.update(mfTonprice);
        return new JsonResult("200", "修改成功");
    }

}