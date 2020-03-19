<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/16
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>画册</title>
    <script type="text/javascript"  src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/hcbjJs.js" ></script>
    <style>
      #j>ul{
        margin: 0;
        padding-left: 0;
      }
      #j>ul li{
        margin: 0px auto;
        padding: 0px auto;
        list-style-type: none;
        text-align: left;
      }
      #j{
        margin-left:6px ;
        width: 144px;
        border: 1px black solid;
        background: white;
      }
      .op{
        background: #5ab4e2;
      }
    </style>
  </head>
  <body>
  <h1 align="center">画册报价</h1><br><br>
  <div class="form-group">
    <table class="table-hover t1" align="center" border="1" cellpadding="0" cellspacing="0" style="position: relative;" >
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
        <td><input type="text" id="hcName" required>
          <div id="j" style="position: absolute;" hidden>
            <ul id="j1"></ul>
          </div>
        </td>
        <td><input type="text" id="hpName"></td>
        <td><select name="hcpSize" id="hcpSize">
            <option value="大度32开210*140">大度32开210*140</option>
            <option value="正度32开130*185">正度32开130*185</option>
            <option value="大度16开210*285">大度16开210*285</option>
            <option value="正度16开185*260">正度16开185*260</option>
            <option value="大度8开420*285">大度8开420*285</option>
            <option value="正度8开370*260">正度8开370*260</option>
            <option value="大度4开420*570">大度4开420*570</option>
            <option value="正度4开370*520">正度4开370*520</option>
        </select></td>
        <td><input type="text" id="hcount"  required pattern="\d{0,6}"></td>
        <td><input type="text" id="hfmKs"    required pattern="\d{0,6}"></td>
        <td>
          <select name="fmType" id="hfmType">
            <option value=""></option>
            <option value="双胶纸">双胶纸</option>
            <option value="铜版纸">铜版纸</option>
          </select>
        </td>
        <td><input type="text" id="hfmPs"  required pattern="\d{0,6}"></td>
        <td>
          <select name="fmMs" id="hfmMs">
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
        <td ><input type="text" id="hnxKs"  required pattern="\d{0,6}"></td>
        <td>
          <select name="fmType" id="hnxType">
            <option value=""></option>
            <option value="双胶纸">双胶纸</option>
            <option value="铜版纸">铜版纸</option>
          </select>
        </td>
        <td ><input type="text" id="hnxPs"  required pattern="\d{0,6}"></td>
        <td>
          <select name="nxMs" id="hnxMs">
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
        <td ><input type="text" id="hcyKs"  required pattern="\d{0,6}"></td>
        <td>
          <select name="cyType" id="hcyType">
            <option value=""></option>
            <option value="双胶纸">双胶纸</option>
            <option value="铜版纸">铜版纸</option>
          </select>
        </td>
        <td ><input type="text" id="hcyPs"  required pattern="\d{0,6}"></td>
        <td>
          <select name="cyMs" id="hcyMs">
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
        <th><input type="text" name="h1" id="hh1"></th>
        <th><input type="text" name="h2" id="hh2"></th>
        <th><input type="text" name="h3" id="hh3"></th>
        <th><input type="text" name="h4" id="hh4"></th>
        <th><input type="text" name="h5" id="hh5"></th>
      </tr>
      <tr>
        <td><select name="fumo" id="hfumo">
          <option value=""></option>
          <option value="无">无</option>
          <option value="光膜">光膜</option>
          <option value="哑膜">哑膜</option>
        </select></td>
        <td>
          <select name="zd" id="hzd">
            <option value=""></option>
            <option value="无">无</option>
            <option value="胶装">胶装</option>
            <option value="骑马钉">骑马钉</option>
          </select>
        </td>
        <td>
          <select name="sType" id="hsType">
            <option value=""></option>
            <option value="自取">自取</option>
            <option value="配送">配送</option>
          </select>
        </td>
        <th>
          金额
        </th>
        <td><input type="text" name="hv1" id="hhv1"></td>
        <td><input type="text" name="hv2" id="hhv2"></td>
        <td><input type="text" name="hv3" id="hhv3"></td>
        <td><input type="text" name="hv4" id="hhv4"></td>
        <td><input type="text" name="hv5" id="hhv5"></td>
      </tr>
      <tr>
        <td></td>
        <th>配送金额</th>
        <td><input type="text" id="hpResult"></td>
        <td colspan="6"></td>
      </tr>
    </table>
      <%--自适应宽高--%>
    <script>
        $(document).ready(function () {
            var w=	$(".t1").width();
            var h=$(".t1").height();
            $("#hresult").width(w);
            $("#hresult").height(h);
            $("#hresult div").width(w);
        });
    </script>
    <div id="hresult">
      <div style="position: absolute;">
        <button id="hsub" class="btn-danger" style="width: 100px;height: 50px;position: absolute;right: 0px;font-size: 18px;">报价保存</button>
        <a href="hcbj.jsp" target="_self">
          <button id="hsave" class="btn-warning" style="width: 100px;height: 50px;position: absolute;right: 0px;bottom: 0;font-size: 15px;">新增报价</button>
        </a>
        <h2>封面金额:<span id="hfmResult"></span></h2>
        <h2>内芯金额:<span id="hnxResult"></span></h2>
        <h2>插页金额:<span id="hcyResult"></span></h2>
        <h2>后期金额:<span id="hhjgResult"></span></h2>
        <h2>配送金额:<span id="hpsResult"></span></h2>

        <h1>总金额:<span id="hresultMoney"></span></h1>
      </div>
    </div>
  </div>
  </body>
</html>
