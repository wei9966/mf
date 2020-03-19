<%@ page import="com.google.gson.Gson" %><%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/17
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
    <title>画册报价结果</title>
</head>
<body>
<h1 align="center">画册报价</h1><br><br>
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
            <td>${baoJia.hdate}</td>
            <td>${baoJia.hcName}</td>
            <td>${baoJia.hpName}</td>
            <td>${baoJia.hcpSize}</td>
            <td>${baoJia.hcount}</td>
            <td>${baoJia.hfmKs}</td>
            <td>${baoJia.hfmType}</td>
            <td>${baoJia.hfmPs}</td>
            <td>${baoJia.hfmMs}</td>
        </tr>
        <tr>
            <td colspan="5" rowspan="4"style="border-left: 0px white;"></td>
            <th >内芯克数</th>
            <th>内芯纸型</th>
            <th >内芯P数</th>
            <th>内芯墨色</th>
        </tr>
        <tr>
            <td>${baoJia.hnxKs}</td>
            <td>${baoJia.hnxType}</td>
            <td>${baoJia.hnxPs}</td>
            <td>${baoJia.hnxMs}</td>
        </tr>
        <tr>
            <th>插页克数</th>
            <th>插页纸型</th>
            <th>插页P数</th>
            <th>插页墨色</th>
        </tr>

        <tr>
            <td>${baoJia.hcyKs}</td>
            <td>${baoJia.hcyType}</td>
            <td>${baoJia.hcyPs}</td>
            <td>${baoJia.hcyMs}</td>
        </tr>
    </table>

    <table class="  table-hover t1" border="1" align="center" style="margin-top: 25px;" cellspacing="1" cellpadding="1" >
        <tr>
            <th>复膜</th>
            <th>装订方式</th>
            <th>配送方式</th>
            <th>特殊工艺</th>
            <td>${baoJia.hh1}</td>
            <td>${baoJia.hh2}</td>
            <td>${baoJia.hh3}</td>
            <td>${baoJia.hh4}</td>
            <td>${baoJia.hh5}</td>
        </tr>
        <tr>
            <td>${baoJia.hfumo}</td>
            <td>${baoJia.hzd}</td>
            <td>${baoJia.hsType}</td>
            <th>
                金额
            </th>
            <td>${baoJia.hhv1}</td>
            <td>${baoJia.hhv2}</td>
            <td>${baoJia.hhv3}</td>
            <td>${baoJia.hhv4}</td>
            <td>${baoJia.hhv5}</td>
        </tr>
        <tr>
            <td></td>
            <th>配送金额</th>
            <td>${baoJia.hpResult}</td>
            <td colspan="6"></td>
        </tr>
    </table>
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
            <h2>封面金额:<span id="hfmResult">${baoJia.hfmResult}</span></h2>
            <h2>内芯金额:<span id="hnxResult">${baoJia.hnxResult}</span></h2>
            <h2>插页金额:<span id="hcyResult">${baoJia.hcyResult}</span></h2>
            <h2>后期金额:<span id="hhjgResult">${baoJia.hhjgResult}</span></h2>
            <h2>配送金额:<span id="hpsResult">${baoJia.hpResult}</span></h2>
            <h1>总金额:<span id="hresultMoney">${baoJia.hResultMoney}</span></h1>
            <button hidden id="hproduce" class="btn-danger" style="width:100px;height: 50px;position: absolute;right: 0px;bottom: 0px; ">生产</button>
            <button hidden id="hdelete" class="btn-danger" style="width:100px;height: 50px;position: absolute;right: 101px;bottom: 0px; ">删除</button>
            <button id="hmodify" class="btn-danger" style="width:100px;height: 50px;position: absolute;right: 202px;bottom: 0px; ">修改</button>
        </div>
        <script>
            $(function () {
               var flag=${baoJia.hflag};
               $(document).ready(function () {
                    if (flag==1){
                        $("#hproduce").show();
                        $("#hdelete").show();
                    }
               });
               $("#hproduce").click(function () {
                   var pName='${baoJia.hpName}';
                   var flag1='<%=request.getAttribute("flag")%>';
                    if (pName==""){
                        alert("印刷名为空，请修改后进行生产");
                    }else{<% Gson g= new Gson();%>
                        var a='<%=g.toJson(request.getAttribute("baoJia"))%>';
                        var url="work?type=1&BaoJia="+a+"&flag="+flag1;
                        location.href=encodeURI(url);
                    }
               });
               $("#hdelete").click(function () {
                   /**
                    * id 是对应实体类的id
                    * hid 是对应的报价记录的id
                    * @type {string}
                    */
                   var id='${baoJia.id}';
                   var hid='${baoJia.hbjjl}';
                   var flagType=1;//1代表是画册
                   var flag=1; //1 代表是报价记录
                   $.ajax({
                       type:"post",
                       url:"delete",
                       dataType:"text",
                       data:{"id":id,"hid":hid,"flag":flag,"flagType":flagType},
                       success:function (msg) {
                           alert(msg);
                          location.href="baoJiaSel?type=1&flag=3";
                       }
                   });
               });
            });
        </script>

    </div>
</div>
</body>
</html>
