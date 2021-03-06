<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>工单</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        #father{
            text-align: center;
        }
        .t1 tr th,.t1 tr td{
            font-size: 22px;
            width: 120px;
            height: 25px;
            text-align: center;
        }
        .t2 tr th,.t2 tr td{
            font-size: 22px;
            width: 150px;
            height: 25px;
        }
        .t2 input{
            width: 155px;
        }
        #pageQieHuan{
            margin: 0 auto;
            height: 35px;
            text-align: center;
        }
    </style>

</head>
<body>
<div id="father">
    <h1 align="center">所有已开工单记录</h1>
<table border="1" align="center" class="t1" cellspacing="0" cellpadding="5">
    <tr>
        <th>编号</th>
        <th>日期</th>
        <th>客户名称</th>
        <th>产品名称</th>
        <th>封面纸张</th>
        <th>内芯纸张</th>
        <th>成品数量</th>
        <th>成品尺寸</th>
        <th>印刷颜色</th>
        <th>加工要求</th>
        <th>总价</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${work.list}" var="w">
        <tr>
            <td>${w.w_id}</td>
            <td>${w.w_kDate}</td>
            <td>${w.w_cName}</td>
            <td>${w.w_pName}</td>
            <td>${w.w_fmKs}${w.w_fmPage}</td>
            <td>${w.w_nxKs}${w.w_nxPage}</td>
            <td>${w.w_count}</td>
            <td>${w.w_pSize}</td>
            <td>${w.w_fmYellow}</td>
            <td>${w.w_hjg}</td>
            <td>${w.w_result}</td>
            <td>${w.w_other}</td>
            <td><button id="x${w.w_id}" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#MyModal">修改</button></td>
        </tr>
    </c:forEach>
</table>
    <div class="modal fade" data-backdrop="static" id="MyModal" tabindex="1" role="dialog" aria-labelledby="MyModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" style="width: 1100px; " role="document">
            <div class="modal-content">
                  <div class="modal-header">
                    <h2>工单数据修改</h2>
                  </div>
                  <div class="modal-body">
                        <h3>请在以下输入你要修改的数据，不输入表示不更改</h3>
                    <table border="1" align="center" class="t2" cellspacing="0" cellpadding="5">
                        <tr>
                            <th>日期</th>
                            <th>客户名称</th>
                            <th>产品名称</th>
                            <th>加工要求</th>
                            <th>总价</th>
                            <th>备注</th>
                        </tr>
                        <tr>
                            <td><input type="date" id="date"></td>
                            <td><input type="text" id="cName"></td>
                            <td><input type="text" id="pName"></td>
                            <td><input type="text" id="hjg"></td>
                            <td><input type="text" id="resultMoney"></td>
                            <td><input type="text" id="other"></td>
                        </tr>
                    </table>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default close1" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary sb" data-dismiss="modal">提交</button>
                  </div>
            </div>
        </div>
    </div>
    <div id="pageQieHuan">
        <ul class="pagination">
            <li>
                <a href="work?pageNum=${work.pageNumber-1}&type=3" <c:if test="${work.pageNumber==1}">onclick="javascript:return false;" </c:if> >上一页</a>
            </li>
            <li>
                <a href="work?pageNum=${work.pageNumber+1}&type=3" <c:if test="${work.pageNumber>=work.total}">onclick="javascript:return false;"</c:if> > 下一页</a>
            </li>
        </ul>
    </div>
    <script>
        $(document).ready(function () {
            $("#pageQieHuan").width($(".t1").width());
            var id;
            $(".t1 button").click(function (e) {
                id=$(e.target).attr("id");
            });
            $(".sb").click(function () {
                var date=$("#date").val();
                var cName=$("#cName").val();
                var pName=$("#pName").val();
                var hjg=$("#hjg").val();
                var resultMoney=$("#resultMoney").val();
                if (resultMoney==''){
                    resultMoney=0;
                }
                var other=$("#other").val();
                var obj={
                    "w_kDate":date,
                    "w_cName":cName,
                    "w_pName":pName,
                    "w_hjg":hjg,
                    "w_result":resultMoney,
                    "w_other":other
                };
                var oo=  JSON.stringify(obj);
                $.ajax({
                    type:"post",
                    url:"work",
                    dataType:"text",
                    data:{"obj":oo,"type":4,"id":id},
                    success:function (msg) {
                        location.href=msg;
                    }
                });
            });
            $(".close1").click(function () {
                $("#date").val("");
                $("#cName").val("");
                $("#pName").val("");
                $("#hjg").val("");
                $("#resultMoney").val("");
                $("#other").val("");
            });
        });
    </script>



</div>
</body>
</html>
