<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/15
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="css/au.css">
<script src="js/jQuery1.8.3.js"></script>
<script src="js/test.js"></script>
  <head>
    <title>$Title$</title>
      <script>

  // var proposals = ['百度1', '百度2', '百度3', '百度4', '百度5', '百度6', '百度7','呵呵呵呵呵呵呵','百度','新浪','a1','a2','a3','a4','b1','b2','b3','b4'];

  $(document).ready(function(){
      $.ajax({
            type:"post",
            url:"tt",
            dataType:"text",
            data:"",
            success:function (msg) {
               var m=msg;
                $('#search-form').autocomplete({
                    hints: m,
                    width: 300,
                    height: 30,
                    onSubmit: function(text){
                        $('#message').html('Selected: <b>' + text + '</b>');
                    }
                });
            }
      });
  });
  </script>
  </head>
  <body>
  <div id="demo">
      <div class="wrapper">
      <h3>试试输入"百度"</h3>
  <div id="search-form"></div>
      <div id="message"></div>
      </div>
      </div>
      </body>
</html>
