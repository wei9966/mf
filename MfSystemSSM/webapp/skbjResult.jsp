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
    <title>书刊报价结果</title>
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
            <td>${baoJia.s_date}</td>
            <td>${baoJia.s_cName}</td>
            <td>${baoJia.s_pName}</td>
            <td>${baoJia.s_cpSize}</td>
            <td>${baoJia.s_count}</td>
            <td>${baoJia.s_fmKs}</td>
            <td>${baoJia.s_fmType}</td>
            <td>${baoJia.s_fmPs}</td>
            <td>${baoJia.s_fmMs}</td>
        </tr>
        <tr>
            <td colspan="5" rowspan="4"style="border-left: 0px white;"></td>
            <th >内芯克数</th>
            <th>内芯纸型</th>
            <th >内芯P数</th>
            <th>内芯墨色</th>
        </tr>
        <tr>
            <td>${baoJia.s_nxKs}</td>
            <td>${baoJia.s_nxType}</td>
            <td>${baoJia.s_nxPs}</td>
            <td>${baoJia.s_nxMs}</td>
        </tr>
        <tr>
            <th>插页克数</th>
            <th>插页纸型</th>
            <th>插页P数</th>
            <th>插页墨色</th>
        </tr>

        <tr>
            <td>${baoJia.s_cyKs}</td>
            <td>${baoJia.s_cyType}</td>
            <td>${baoJia.s_cyPs}</td>
            <td>${baoJia.s_cyMs}</td>
        </tr>
    </table>

    <table class="  table-hover t1" border="1" align="center" style="margin-top: 25px;" cellspacing="1" cellpadding="1" >
        <tr>
            <th>复膜</th>
            <th>装订方式</th>
            <th>配送方式</th>
            <th>特殊工艺</th>
            <td>${baoJia.s_h1}</td>
            <td>${baoJia.s_h2}</td>
            <td>${baoJia.s_h3}</td>
            <td>${baoJia.s_h4}</td>
            <td>${baoJia.s_h5}</td>
        </tr>
        <tr>
            <td>${baoJia.s_fumo}</td>
            <td>${baoJia.s_zd}</td>
            <td>${baoJia.s_sType}</td>
            <th>
                金额
            </th>
            <td>${baoJia.s_hv1}</td>
            <td>${baoJia.s_hv2}</td>
            <td>${baoJia.s_hv3}</td>
            <td>${baoJia.s_hv4}</td>
            <td>${baoJia.s_hv5}</td>
        </tr>
        <tr>
            <td></td>
            <th>配送金额</th>
            <td>${baoJia.s_pResult}</td>
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
            <h2>封面金额:<span id="s_fmResult">${baoJia.s_fmResult}</span></h2>
            <h2>内芯金额:<span id="s_nxResult">${baoJia.s_nxResult}</span></h2>
            <h2>插页金额:<span id="s_cyResult">${baoJia.s_cyResult}</span></h2>
            <h2>后期金额:<span id="s_hjgResult">${baoJia.s_hjgResult}</span></h2>
            <h2>配送金额:<span id="s_psResult">${baoJia.s_pResult}</span></h2>
            <h1>总金额:<span id="s_resultMoney">${baoJia.s_ResultMoney}</span></h1>
            <button hidden id="hproduce" class="btn-danger" style="width:100px;height: 50px;position: absolute;right: 0px;bottom: 0px; ">生产</button>
            <button hidden id="hdelete" class="btn-danger" style="width:100px;height: 50px;position: absolute;right: 101px;bottom: 0px; ">删除</button>
            <button id="hmodify" class="btn-danger" style="width:100px;height: 50px;position: absolute;right: 202px;bottom: 0px; ">修改</button>
        </div>
        <script>
            $(function () {
                var flag=${baoJia.s_flag};
                $(document).ready(function () {
                    if (flag==1){
                        $("#hproduce").show();
                        $("#hdelete").show();
                    }
                });
                $("#hproduce").click(function () {
                    var pName='${baoJia.s_pName}';
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
                    var hid='${baoJia.s_bjjl}';
                    var flagType=2;//1代表是画册
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
