<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/16
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书刊报价</title>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
    <script>
        $(function () {
            $("#s_sub").click(function () {
                var cName=$("#s_cName").val();
                var pName=$("#s_pName").val();
                var fmType= $("#s_fmType").val();
                var fmKs=	$("#s_fmKs").val();
                var fmPs=$("#s_fmPs").val();
                var cpSize=$("#s_cpSize").val();
                var count=$("#s_count").val();
                var nxType=$("#s_nxType").val();
                var nxKs=$("#s_nxKs").val();
                var nxPs=$("#s_nxPs").val();
                var fumo=$("#s_fumo").val();
                var cyKs=$("#s_cyKs").val();
                var cyPs=$("#s_cyPs").val();
                var cyType=$("#s_cyType").val();
                var zd=$("#s_zd").val();
                var sType=$("#s_sType").val();
                var h1=$("#s_h1").val();
                var h2=$("#s_h2").val();
                var h3=$("#s_h3").val();
                var h4=$("#s_h4").val();
                var h5=$("#s_h5").val();
                var hv1=$("#s_hv1").val();
                var hv2=$("#s_hv2").val();
                var hv3=$("#s_hv3").val();
                var hv4=$("#s_hv4").val();
                var hv5=$("#s_hv5").val();
                var pResult=$("#s_pResult").val();
                var fmMs=$("#s_fmMs").val();
                var nxMs=$("#s_nxMs").val();
                var cyMs=$("#s_cyMs").val();
                if (fmType==""){
                    alert("封面纸型未填");
                    return false;
                }
                if (nxType==""){
                    alert("内芯纸型未填");
                    return false;
                }
                if (fmMs==""){
                    alert("封面墨色未填");
                    return false;
                }
                if (nxMs==""){
                    alert("内芯墨色未填");
                    return false;
                }
                if (fumo==""){
                    alert("复膜方式未填");
                    return false;
                }
                if (zd==""){
                    alert("装订方式未填");
                    return false;
                }
                if (hv1==""){
                    hv1=0;
                }
                if (hv2==""){
                    hv2=0;
                }
                if (hv3==""){
                    hv3=0;
                }
                if (hv4==""){
                    hv4=0;
                }
                if (hv5==""){
                    hv5=0;
                }
                if (cyPs==""){
                    cyPs=0;
                }
                if (cyKs==""){
                    cyKs=0;
                }
                if (pResult==""){
                    pResult=0;
                }
                var obj={
                    "s_cName":cName,
                    "s_pName":pName,
                    "s_fmType":fmType,
                    "s_fmKs":fmKs,
                    "s_fmPs":fmPs,
                    "s_cpSize":cpSize,
                    "s_count":count,
                    "s_nxType":nxType,
                    "s_nxKs":nxKs,
                    "s_nxPs":nxPs,
                    "s_fumo":fumo,
                    "s_zd":zd,
                    "s_sType":sType,
                    "s_hv1":hv1,
                    "s_hv2":hv2,
                    "s_hv3":hv3,
                    "s_hv4":hv4,
                    "s_hv5":hv5,
                    "s_h1":h1,
                    "s_h2":h2,
                    "s_h3":h3,
                    "s_h4":h4,
                    "s_h5":h5,
                    "s_pResult":pResult,
                    "s_cyType":cyType,
                    "s_cyKs":cyKs,
                    "s_cyPs":cyPs,
                    "s_fmMs":fmMs,
                    "s_nxMs":nxMs,
                    "s_cyMs":cyMs
                }
                var oo=  JSON.stringify(obj);
                alert(oo);
                $.ajax({
                    type:"post",
                    url:"baoJia",
                    dataType:"text",
                    data:{"oo":oo,"type":2},
                    success:function (msg) {
                        var a= JSON.parse(msg);
                        var fmResult=a.fmResult;
                        var nxResult=a.nxResult;
                        var hjgResult=a.hjgResult;
                        var cyResult=a.cyResult;
                        var psResult=a.psResult;
                        var resultMoney=a.resultMoney;
                        $("#s_fmResult").text(fmResult);
                        $("#s_nxResult").text(nxResult);
                        $("#s_cyResult").text(cyResult);
                        $("#s_hjgResult").text(hjgResult);
                        $("#s_psResult").text(psResult);
                        $("#s_resultMoney").text(resultMoney);
                    }
                });
            });
        });
    </script>

    <style>
        #s_result div h2 span{
            color: red;
        }
        #s_result{
            margin: 0px auto;
        }
        #s_resultMoney{
            color: red;
            font-size: 30px;
        }
        #s_result div h2 span{
            color: red;
        }
    </style>
</head>
<body>
<h1 align="center">书刊报价</h1><br><br>
<div class="form-group">
    <table class="table-hover t1" align="center" border="1" cellpadding="0" cellspacing="0" >
        <tr >
            <th>日期</th>
            <th>客户名称</th>
            <th>文件名称</th>
            <th>成品尺寸</th>
            <th>成品数量</th>
            <th>封面克数</th>
            <th>封面纸型</th>
            <th>封面P数</th>
            <th>封面墨色</th>
        </tr>
        <tr >
            <td></td>
            <td><input type="text" id="s_cName" required></td>
            <td><input type="text" id="s_pName"></td>
            <td><select name="s_cpSize" id="s_cpSize">
                <option value="大度32开210*140">大度32开210*140</option>
                <option value="正度32开130*185">正度32开130*185</option>
                <option value="大度16开210*285">大度16开210*285</option>
                <option value="正度16开185*260">正度16开185*260</option>
                <option value="大度8开420*285">大度8开420*285</option>
                <option value="正度8开370*260">正度8开370*260</option>
                <option value="大度4开420*570">大度4开420*570</option>
                <option value="正度4开370*520">正度4开370*520</option>
            </select></td>
            <td><input type="text" id="s_count"  required pattern="\d{0,6}"></td>
            <td><input type="text" id="s_fmKs"    required pattern="\d{0,6}"></td>
            <td>
                <select name="fmType" id="s_fmType">
                    <option value=""></option>
                    <option value="双胶纸">双胶纸</option>
                    <option value="铜版纸">铜版纸</option>
                </select>
            </td>
            <td><input type="text" id="s_fmPs"  required pattern="\d{0,6}"></td>
            <td>
                <select name="fmMs" id="s_fmMs">
                    <option value=""></option>
                    <option value="k">K</option>
                    <option value="cmyk">CMYK</option>
                    <option value="双色">双色</option>
                    <option value="三色">三色</option>
                    <option value="专色">专色</option>
                </select>
            </td>

        </tr>
        <tr>
            <td colspan="5" rowspan="4"style="border-left: 0px white;"></td>
            <th >内芯克数</th>
            <th>内芯纸型</th>
            <th >内芯P数</th>
            <th>内芯墨色</th>
        </tr>
        <tr>
            <td ><input type="text" id="s_nxKs"  required pattern="\d{0,6}"></td>
            <td>
                <select name="fmType" id="s_nxType">
                    <option value=""></option>
                    <option value="双胶纸">双胶纸</option>
                    <option value="铜版纸">铜版纸</option>
                </select>
            </td>
            <td ><input type="text" id="s_nxPs"  required pattern="\d{0,6}"></td>
            <td>
                <select name="nxMs" id="s_nxMs">
                    <option value=""></option>
                    <option value="k">K</option>
                    <option value="cmyk">CMYK</option>
                    <option value="双色">双色</option>
                    <option value="三色">三色</option>
                    <option value="专色">专色</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>插页克数</th>
            <th>插页纸型</th>
            <th>插页P数</th>
            <th>插页墨色</th>
        </tr>

        <tr>
            <td ><input type="text" id="s_cyKs"  required pattern="\d{0,6}"></td>
            <td>
                <select name="cyType" id="s_cyType">
                    <option value=""></option>
                    <option value="双胶纸">双胶纸</option>
                    <option value="铜版纸">铜版纸</option>
                </select>
            </td>
            <td ><input type="text" id="s_cyPs"  required pattern="\d{0,6}"></td>
            <td>
                <select name="cyMs" id="s_cyMs">
                    <option value=""></option>
                    <option value="k">K</option>
                    <option value="cmyk">CMYK</option>
                    <option value="双色">双色</option>
                    <option value="三色">三色</option>
                    <option value="专色">专色</option>
                </select>
            </td>
        </tr>
    </table>

    <table class="  table-hover t1" border="1" align="center" style="margin-top: 25px;" cellspacing="1" cellpadding="1" >
        <tr>
            <th>复膜</th>
            <th>装订方式</th>
            <th>配送方式</th>
            <th>特殊工艺</th>
            <th><input type="text" name="s_1" id="s_h1"></th>
            <th><input type="text" name="s_2" id="s_h2"></th>
            <th><input type="text" name="s_3" id="s_h3"></th>
            <th><input type="text" name="s_4" id="s_h4"></th>
            <th><input type="text" name="s_5" id="s_h5"></th>
        </tr>
        <tr>
            <td><select name="fumo" id="s_fumo">
                <option value=""></option>
                <option value="无">无</option>
                <option value="光膜">光膜</option>
                <option value="哑膜">哑膜</option>
            </select></td>
            <td>
                <select name="zd" id="s_zd">
                    <option value=""></option>
                    <option value="无">无</option>
                    <option value="胶装">胶装</option>
                    <option value="骑马钉">骑马钉</option>
                </select>
            </td>
            <td>
                <select name="sType" id="s_sType">
                    <option value=""></option>
                    <option value="自取">自取</option>
                    <option value="配送">配送</option>
                </select>
            </td>
            <th>
                金额
            </th>
            <td><input type="text" name="s_v1" id="s_hv1"></td>
            <td><input type="text" name="s_v2" id="s_hv2"></td>
            <td><input type="text" name="s_v3" id="s_hv3"></td>
            <td><input type="text" name="s_v4" id="s_hv4"></td>
            <td><input type="text" name="s_v5" id="s_hv5"></td>
        </tr>
        <tr>
            <td></td>
            <th>配送金额</th>
            <td><input type="text" id="s_pResult"></td>
            <td colspan="6"></td>
        </tr>
    </table>
    <script>
        $(document).ready(function () {
            var w=	$(".t1").width();
            var h=$(".t1").height();
            $("#s_result").width(w);
            $("#s_result").height(h);
            $("#s_result div").width(w);
        });
    </script>
    <div id="s_result">
        <div style="position: absolute;">
            <button id="s_sub" class="btn-danger" style="width: 100px;height: 50px;position: absolute;right: 0px;font-size: 18px;">报价保存</button>
            <a href="4.html" target="_self">
                <button id="s_save" class="btn-warning" style="width: 100px;height: 50px;position: absolute;right: 0px;bottom: 0;font-size: 15px;">新增报价</button>
            </a>
            <h2>封面金额:<span id="s_fmResult"></span></h2>
            <h2>内芯金额:<span id="s_nxResult"></span></h2>
            <h2>插页金额:<span id="s_cyResult"></span></h2>
            <h2>后期金额:<span id="s_hjgResult"></span></h2>
            <h2>配送金额:<span id="s_psResult"></span></h2>
            <h1>总金额:<span id="s_resultMoney"></span></h1>
        </div>
    </div>
</div>
</body>
</html>
