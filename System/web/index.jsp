<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/15
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>明发印刷</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
    <script>
        $(function () {
            $("#sub").click(function () {
                var date=$("#date").val();
                var cName=$("#cName").val();
                var pName=$("#pName").val();
                var fengMian= $("#fengMian").val();
                var fmKs=	$("#fmKs").val();
                var fmPs=$("#fmPs").val();
                var cpSize=$("#cpSize").val();
                var count=$("#count").val();
                var neiXin=$("#neiXin").val();
                var nxKs=$("#nxKs").val();
                var nxPs=$("#nxPs").val();
                var fumo=$("#fumo").val();
                var zd=$("#zd").val();
                var sType=$("#sType").val();
                var h1=$("#h1").val();
                var h2=$("#h2").val();
                var h3=$("#h3").val();
                var hv1=$("#hv1").val();
                var hv2=$("#hv2").val();
                var hv3=$("#hv3").val();
                var obj={
                    "date":date,
                    "cName":cName,
                    "pName":pName,
                    "fengMian":fengMian,
                    "fmKs":fmKs,
                    "fmPs":fmPs,
                    "cpSize":cpSize,
                    "count":count,
                    "neiXin":neiXin,
                    "nxKs":nxKs,
                    "nxPs":nxPs,
                    "fumo":fumo,
                    "zd":zd,
                    "sType":sType,
                    "hv1":hv1,
                    "hv2":hv2,
                    "hv3":hv3,
                    "h1":h1,
                    "h2":h2,
                    "h3":h3,
                }
                var oo=  JSON.stringify(obj);
                $.ajax({
                    type:"post",
                    url:"test",
                    dataType:"text",
                    data:{"oo":oo},
                    success:function (msg) {
                        var a= JSON.parse(msg);
                        var fmResult=a.fmResult;
                        var nxResult=a.nxResult;
                        var hjgResult=a.hjgResult;
                        var psResult=a.psResult;
                        var resultMoney=a.resultMoney;
                        $("#fmResult").text(fmResult);
                        $("#nxResult").text(nxResult);
                        $("#hjgResult").text(hjgResult);
                        $("#psResult").text(psResult);
                        $("#resultMoney").text(resultMoney);
                    }
                });
            });
        });
    </script>
  </head>
  <body>
  <h1 align="center">报价</h1><br><br>
  <div class="form-group">
    <table class="table-hover t1" align="center" border="1" cellpadding="0" cellspacing="0" >
      <tr >
        <th>日期</th>
        <th>客户名称</th>
        <th>文件名称</th>
        <th>内芯克数</th>
        <th>内芯纸型</th>
        <th>内芯P数</th>
        <th>成品尺寸</th>
        <th>成品数量</th>
      </tr>
      <tr >
        <td><input type="text" id="date"></td>
        <td><input type="text" id="cName"></td>
        <td><input type="text" id="pName"></td>
        <td><input type="text" id="nxKs" value="0"></td>
        <td>
          <select name="nxType" id="nxType">
            <option value="双胶纸">双胶纸</option>
            <option value="铜版纸">铜版纸</option>
          </select>
        </td>
        <td><input type="text" id="nxPs" value="0"></td>
        <td><input type="text" id="cpSize"></td>
        <td><input type="text" id="count" value="0"></td>
      </tr>
      <tr>
        <td colspan="3" rowspan="2"style="border-left: 0px white;"></td>
        <th >封面克数</th>
        <th>封面纸型</th>
        <th >封面P数</th>
        <td colspan="2" rowspan="2" style="border: none;"></td>
      </tr>
      <tr>
        <td ><input type="text" id="fmKs" value="0"></td>
        <td>
          <select name="fmType" id="fmType">
            <option value="双胶纸">双胶纸</option>
            <option value="铜版纸">铜版纸</option>
          </select>
        </td>
        <td ><input type="text" id="fmPs" value="0"></td>
      </tr>
    </table>

    <table class="  table-hover t1" border="1" align="center" style="margin-top: 25px;" cellspacing="1" cellpadding="1" >
      <tr>
        <th>复膜</th>
        <th>装订方式</th>
        <th>送货</th>
        <th>特殊工艺</th>
        <th><input type="text" name="h1" id="h1"></th>
        <th><input type="text" name="h2" id="h2"></th>
        <th><input type="text" name="h3" id="h3"></th>
      </tr>
      <tr>
        <td><select name="fumo" id="fumo">
          <option value="光膜">光膜</option>
          <option value="哑膜">哑膜</option>
        </select></td>
        <td>
          <select name="zd" id="zd">
            <option value="胶装">胶装</option>
            <option value="骑马钉">骑马钉</option>
          </select>
        </td>
        <td>
          <select name="sType" id="sType">
            <option value="自取">自取</option>
            <option value="配送">配送</option>
          </select>
        </td>
        <th>
          金额
        </th>
        <td><input type="text" name="hv1" id="hv1" value="0"></td>
        <td><input type="text" name="hv2" id="hv2" value="0"></td>
        <td><input type="text" name="hv3" id="hv3" value="0"></td>
      </tr>
      <tr>
        <td colspan="2"></td>
        <td><input type="text" id="pResult"></td>
        <td colspan="4"></td>
      </tr>
    </table>
    <script>
        $(document).ready(function () {
            var w=	$(".t1").width();
            var h=$(".t1").height();
            $("#result").width(w);
            $("#result").height(h);
            $("#result div").width(w);
        });
    </script>
    <div id="result">
      <div style="position: absolute;">
        <button id="sub" class="btn-danger" style="width: 100px;height: 50px;position: absolute;right: 0px;">报价</button>
        <h2>封面金额:<span id="fmResult"></span></h2>
        <h2>内芯金额:<span id="nxResult"></span></h2>
        <h2>后期金额:<span id="hjgResult"></span></h2>
        <h2>配送金额:<span id="psResult"></span></h2>
        <br>
        <br>
        <br>
        <br>
        <h1>总金额:<span id="resultMoney"></span></h1>
      </div>
    </div>
  </div>
  </body>
</html>
