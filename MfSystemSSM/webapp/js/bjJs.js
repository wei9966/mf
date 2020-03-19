//报价页面JS
$(function () {

    //标题单击事件
    $("#cName").click(function () {
        $.ajax({
            type:"post",
            url:"searchTitle",
            dataType:"text",
            data:{"type":1},
            success:function (msg) {
                var a=JSON.parse(msg);
                var array=new Array();
                $.each(a,function (i,n) {
                    array[i]=n;
                });
                $("#jCName>ul").html("");
                $("#jCName").show();
                if (array.length>0){
                    for (var i=0;i<a.length;i++){
                        $("#jCName>ul").append("<li>"+a[i]+"</li>");
                    }
                }else {
                    $("#jCName").hide();
                }
            }
        });
    });
    /**
     * 鼠标单击绑定
     * */
    $("#jCName>ul").on("click","li",function (e) {
        var v=$(this).html();
        location.href="baoJiaSel?type=3&cName="+v+"&titleFlag=1";
        // $.ajax()
        $("#jCName").hide();
    });
    /**
     * 鼠标触碰
     */
    $("#jCName>ul").on("mouseenter","li",
        function (e) {
            $(this).addClass('op');
            $(".op").nextAll().removeClass();
            $(".op").prevAll().removeClass();
        }
    );
    $("#jCName>ul").on("mouseleave","li",function () {
        $(this).removeClass('op');
    });
    //取消单击隐藏事件
    $(document).click(function () {
        $("#jCName").hide();
    });
    $("#jCName").click(function (e) {
        e.stopPropagation();
    });
    //---------------------------------------------------------------------——————————————————————
    $("#pName").click(function () {
        $.ajax({
            type:"post",
            url:"searchTitle",
            dataType:"text",
            data:{"type":2},
            success:function (msg) {
                var a=JSON.parse(msg);
                var array=new Array();
                $.each(a,function (i,n) {
                    array[i]=n;
                });
                $("#jPName>ul").html("");
                $("#jPName").show();
                if (array.length>0){
                    for (var i=0;i<a.length;i++){
                        $("#jPName>ul").append("<li>"+a[i]+"</li>");
                    }
                }else {
                    $("#jPName").hide();
                }
            }
        });
    });
    /**
     * 鼠标单击绑定
     * */
    $("#jPName>ul").on("click","li",function (e) {
        var v=$(this).html();
        location.href="baoJiaSel?type=3&pName="+v+"&titleFlag=2";
        // $.ajax()
        $("#jPName").hide();
    });
    /**
     * 鼠标触碰
     */
    $("#jPName>ul").on("mouseenter","li",
        function (e) {
            $(this).addClass('op');
            $(".op").nextAll().removeClass();
            $(".op").prevAll().removeClass();
        }
    );
    $("#jPName>ul").on("mouseleave","li",function () {
        $(this).removeClass('op');
    });
    //取消单击隐藏事件
    $(document).click(function () {
        $("#jPName").hide();
    });
    $("#jPName").click(function (e) {
        e.stopPropagation();
    });
    //————————————————————————————————————————————————————————————————————————————————————————————
    //V代表生产状态
    var v=$("#v").attr("value");
    // $("#resultMoney")



});