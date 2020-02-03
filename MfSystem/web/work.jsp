<%@ page import="com.google.gson.Gson" %><%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/16
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/workJs.js"></script>
    <style>
        .t1 tr th,td{
            font-size: 22px;
            width: 100px;
            text-align: center;
        }
        .t1 #w_hDate{
            width: 300px;
            height: 50px;
        }
        .t1 #w_jiTai{
            width: 200px;
            height: 30px;
        }
        .t1 #w_other{
            width: 800px;
            height: 50px;
        }
        
        #w_jiTai{
            width: 200px;
        }
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
            width: 198px;
            border: 1px black solid;
            background: white;
        }
        .op{
            background: #5ab4e2;
        }
    </style>
    <script>
        $(function () {
            //提交工单事件
            $("#product").click(function () {
                var jiTai=$("#w_jiTai").val();
                var hDate=$("#w_hDate").val();
                var other=$("#w_other").val();
                if (jiTai==""){
                    alert("印刷机台未选择");
                    return false;
                };
                if (hDate==""){
                    alert("交货日期未填写");
                    return false;
                };
                <%Gson g=new Gson();%>
                var w='<%=g.toJson(request.getAttribute("work"))%>';
                var flag='${flag}';
                var flag1='${flag1}';
                var url="work?type=2&w_hDate="+hDate+"&w_jiTai="+jiTai+"&w_other="+other+"&work="+w+"&flag="+flag+"&flag1="+flag1;
                location.href=encodeURI(url);
            });
        });

    </script>
</head>
<body>
<div id="father">
    <h1 align="center">明发印刷厂生产工单</h1>
    <table border="1" class="t1" cellpadding="5" cellspacing="0" align="center" style="position:relative;">
        <tr>
            <th>开单日期</th>
            <td colspan="4">${work.w_kDate}</td>
            <th>客户名称</th>
            <td colspan="4">${work.w_cName}</td>
        </tr>
        <tr>
            <th rowspan="2">常规信息</th>
            <th>印刷名称</th>
            <td colspan="3">${work.w_pName}</td>
            <th>成品数量</th>
            <td colspan="3">${work.w_count}</td>
        </tr>
        <tr>
            <th>
                接单日期
            </th>
            <td colspan="3">${work.w_jDate}</td>
            <th>交货日期</th>
            <td colspan="3"><input type="date" id="w_hDate"></td>
        </tr>
        <tr>
            <th rowspan="5">印刷工艺</th>
            <th>印刷机台</th>
            <td colspan="2"><input type="text" id="w_jiTai">
                <div id="j" style="position: absolute;" hidden>
                    <ul id="j1"></ul>
                </div>
            </td>
            <th>产品尺寸</th>
            <td colspan="2">${work.w_cSize}</td>
            <th>拼板尺寸</th>
            <td>${work.w_pSize}</td>
        </tr>
        <tr>
            <th>印刷信息</th>
            <th>纸张</th>
            <th>开别</th>
            <th>正数</th>
            <th>放数</th>
            <th>合全开数</th>
            <th>印刷墨色</th>
            <th>印版数量</th>
        </tr>
        <tr>
            <th>封面</th>
            <td>${work.w_fmPage}</td>
            <td>${work.w_fmKb}</td>
            <td>${work.w_fmZcount}</td>
            <td>${work.w_fmFcount}</td>
            <td>${work.w_fmHcount}</td>
            <td>${work.w_fmYellow}</td>
            <td></td>
        </tr>
        <tr>
            <th>内页</th>
            <td>${work.w_nxPage}</td>
            <td>${work.w_nxKb}</td>
            <td>${work.w_nxZcount}</td>
            <td>${work.w_nxFcount}</td>
            <td>${work.w_nxHcount}</td>
            <td>${work.w_nxYellow}</td>
            <td></td>
        </tr>
        <tr>
            <th>插页</th>
            <td>${work.w_cyPage}</td>
            <td>${work.w_cyKb}</td>
            <td>${work.w_cyZcount}</td>
            <td>${work.w_cyFcount}</td>
            <td>${work.w_cyHcount}</td>
            <td>${work.w_cyYellow}</td>
            <td></td>
        </tr>
        <tr>
            <th>备注</th>
            <td colspan="8"><input type="text" id="w_other"></td>
        </tr>
        <tr>
            <th>后加工</th>
            <td colspan="8">${work.w_hjg}</td>
        </tr>
        <tr>
            <td colspan="9">
                <button id="product" style="width: 100px;height: 35px;">生产</button>
            </td>
        </tr>
    </table>


</div>


</body>
</html>
