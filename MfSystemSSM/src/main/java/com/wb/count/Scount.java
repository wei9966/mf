package com.wb.count;

import com.wb.pojo.Price;
import com.wb.pojo.ResultMoney;
import com.wb.pojo.SBaoJia;
import com.wb.service.DunJiaService;
import com.wb.util.CountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 获取书刊价格
 */
@Controller
public class Scount {
    @Autowired
    private DunJiaService dunJiaService;

    public ResultMoney getResult(SBaoJia b){
        ResultMoney rs=new ResultMoney();
        double fmResult=getFmResult(b)+getFmYinGong(b);
        double nxResult=getNxResult(b)+getnxYinGong(b);
        double S_jgResult=getS_jgResult(b);
        double psResult=b.getS_pResult();
        double cyResult;
        if(b.getS_cyType()==""||b.getS_cyType().equals("")){
            cyResult=0;
        }else{
            cyResult=getCyRseult(b)+getCyYinGong(b);
        }
        rs.setFmResult(fmResult);
        rs.setNxResult(nxResult);
        rs.setHjgResult(S_jgResult);
        rs.setPsResult(psResult);
        rs.setCyResult(cyResult);
        rs.setResultMoney(rs.ResultMoney());
        return rs;
    }

    private double getCyYinGong(SBaoJia b) {
        return b.getS_cyPs()/CountUtil.getKaiBie(b.getS_cpSize())/2.0*getFmYinGong(b)*2.0;
    }

    private double getCyRseult(SBaoJia b) {
        Price p=new Price();
        p.setKd(b.getS_cyKs());
        p.setSize(b.getS_cpSize());
        p.setdPrice(dunJiaService.getDunJia(b.getS_cyType()));
        double pageSingle = CountUtil.getPageSingle(p);
        int count=b.getS_count()+CountUtil.getZount(b.getS_count());
        return (b.getS_cyPs()/CountUtil.getKaiBie(b.getS_cpSize())*count)/4*pageSingle;
    }


    /**
     * 获取内芯印工价格
     * @param b
     * @return
     */
    private double getnxYinGong(SBaoJia b) {
        return b.getS_nxPs()/CountUtil.getKaiBie(b.getS_cpSize())/2.0*getFmYinGong(b)*2.0;
    }

    /**
     * 获取封面印工价格
     * @param b
     * @return
     */
    private double getFmYinGong(SBaoJia b) {
        if (b.getS_count()>200){
            return 150;
        }
        return 50;
    }

    /**
     * 获取封面纸价格
     * @param b
     * @return
     */
    private double getFmResult(SBaoJia b) {
        Price p=new Price();
        p.setKd(b.getS_fmKs());
        p.setSize(b.getS_cpSize());
        p.setdPrice(dunJiaService.getDunJia(b.getS_fmType()));
        double pageSingle = CountUtil.getPageSingle(p);
        int count=b.getS_count()+CountUtil.getZount(b.getS_count());
        double k=CountUtil.getKaiBie(b.getS_cpSize());
        double c=b.getS_fmPs()/k;
        double d=c*count;
        return d/4.0*pageSingle;
    }

    /**
     * 获取内芯纸价格
     * @param b
     * @return
     */
    private double getNxResult(SBaoJia b) {
        Price p=new Price();
        p.setKd(b.getS_nxKs());
        p.setSize(b.getS_cpSize());
        p.setdPrice(dunJiaService.getDunJia(b.getS_nxType()));
        double pageSingle = CountUtil.getPageSingle(p);
        int count=b.getS_count()+CountUtil.getZount(b.getS_count());
        return (b.getS_nxPs()/CountUtil.getKaiBie(b.getS_cpSize())*count)/4*pageSingle;
    }

    /**
     * 获取后加工价格
     * @param b
     * @return
     */
    private double getS_jgResult(SBaoJia b) {
        double fumo=0;
        double zd=0;
        if (b.getS_fumo().equals("光膜")){
            fumo=b.getS_count()*0.11;
            if (fumo<50){
                fumo=50;
            }
        }else if(b.getS_fumo().equals("哑膜")){
            fumo=b.getS_count()*0.12;
            if (fumo<50){
                fumo=50;
            }
        }else{
            fumo=0;
        }


        if (b.getS_zd().equals("胶装")){
            if (b.getS_nxPs()<200){
                zd=(b.getS_nxPs()/8*0.03+0.25)*b.getS_count();
            }else {
                zd=(b.getS_nxPs()/8*0.03+0.35)*b.getS_count();
            }
        }else if(b.getS_zd().equals("骑马钉")){
            zd=(b.getS_nxPs()/8*0.03+0.05)*b.getS_count();
        }else {
            zd=0;
        }
        return fumo+zd;
    }
}
