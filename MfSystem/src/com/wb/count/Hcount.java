package com.wb.count;

import com.wb.dao.DunJiaDao;
import com.wb.dao.impl.DunJiaDaoImpl;
import com.wb.pojo.BaoJia;
import com.wb.pojo.Price;
import com.wb.pojo.ResultMoney;
import com.wb.util.CountUtil;

/**
 * 获取画册价格
 */
public class Hcount {
    private  DunJiaDao d=new DunJiaDaoImpl();

    public ResultMoney getResult(BaoJia b){
        ResultMoney rs=new ResultMoney();
        double fmResult=getFmResult(b)+getFmYinGong(b,b.getHfmPs());
        double nxResult=getNxResult(b)+getnxYinGong(b);
        double hjgResult=getHjgResult(b);
        double psResult=b.getHpResult();
        double cyResult;
        if(b.getHcyType()==""||b.getHcyType().equals("")){
            cyResult=0;
        }else{
             cyResult=getCyRseult(b)+getCyYinGong(b);
        }
        rs.setFmResult(fmResult);
        rs.setNxResult(nxResult);
        rs.setHjgResult(hjgResult);
        rs.setPsResult(psResult);
        rs.setCyResult(cyResult);
        rs.setResultMoney(rs.ResultMoney());
        return rs;
    }

    private double getCyYinGong(BaoJia b) {
        return b.getHcyPs()/CountUtil.getKaiBie(b.getHcpSize())/2.0*getFmYinGong(b,b.getHcyPs())*2.0;
    }

    private double getCyRseult(BaoJia b) {
        Price p=new Price();
        p.setKd(b.getHcyKs());
        p.setSize(b.getHcpSize());
        p.setdPrice(d.getDunJia(b.getHcyType()));
        double pageSingle = CountUtil.getPageSingle(p);
        int count=b.getHcount()+CountUtil.getZount(b.getHcount());
        return (b.getHcyPs()/CountUtil.getKaiBie(b.getHcpSize())*count)/4*pageSingle;
    }


    /**
     * 获取内芯印工价格
     * @param b
     * @return
     */
    private double getnxYinGong(BaoJia b) {
        return b.getHnxPs()/CountUtil.getKaiBie(b.getHcpSize())/2.0*getFmYinGong(b,b.getHnxPs())*2.0;
    }

    /**
     * 获取封面印工价格
     * @param b
     * @return
     */
    private double getFmYinGong(BaoJia b,int p) {
        int price=0;
      int pp=CountUtil.getYinBanCount(p);
        if (b.getHcount()>=500){
            price=150;
        }else {
        price=50;
        }
        return pp*price;
    }

    /**
     * 获取封面纸价格
     * @param b
     * @return
     */
    private double getFmResult(BaoJia b) {
        Price p=new Price();
        p.setKd(b.getHfmKs());
        p.setSize(b.getHcpSize());
        p.setdPrice(d.getDunJia(b.getHfmType()));
        double pageSingle = CountUtil.getPageSingle(p);
        int count=b.getHcount()+CountUtil.getZount(b.getHcount());
        double k=CountUtil.getKaiBie(b.getHcpSize());
        double c=b.getHfmPs()/k;
        double d=c*count;
        return d/4.0*pageSingle;
    }

    /**
     * 获取内芯纸价格
     * @param b
     * @return
     */
    private double getNxResult(BaoJia b) {
        Price p=new Price();
        p.setKd(b.getHnxKs());
        p.setSize(b.getHcpSize());
        p.setdPrice(d.getDunJia(b.getHnxType()));
        double pageSingle = CountUtil.getPageSingle(p);
        int count=b.getHcount()+CountUtil.getZount(b.getHcount());
        return (b.getHnxPs()/CountUtil.getKaiBie(b.getHcpSize())*count)/4*pageSingle;
    }

    /**
     * 获取后加工价格
     * @param b
     * @return
     */
    private double getHjgResult(BaoJia b) {
        double fumo=0;
        double zd=0;
        if (b.getHfumo().equals("光膜")){
            fumo=b.getHcount()*0.11;
            if (fumo<50){
                fumo=50;
            }
        }else if(b.getHfumo().equals("哑膜")){
            fumo=b.getHcount()*0.12;
            if (fumo<50){
                fumo=50;
            }
        }else{
            fumo=0;
        }


        if (b.getHzd().equals("胶装")){
            if (b.getHnxPs()<200){
                zd=(b.getHnxPs()/8*0.03+0.25)*b.getHcount();
            }else {
                zd=(b.getHnxPs()/8*0.03+0.35)*b.getHcount();
            }
        }else if(b.getHzd().equals("骑马钉")){
            zd=(b.getHnxPs()/8*0.03+0.05)*b.getHcount();
        }else {
            zd=0;
        }
        return fumo+zd+b.getHhv1()+b.getHhv2()+b.getHhv3()+b.getHhv4()+b.getHhv5();
    }
}
