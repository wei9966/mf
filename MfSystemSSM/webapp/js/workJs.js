$(function () {
    /**
     * 显示机台
     */
    $("#w_jiTai").bind('input',function () {
        var jiT=$("#w_jiTai").val();
        if (jiT!=""){
            $.ajax({
                type:"post",
                url:"search",
                dataType:"text",
                data:{"w_jiTai":jiT,"type":1},
                success:function (msg) {
                    var a=JSON.parse(msg);
                    var array=new Array();
                    $.each(a,function (i,n) {
                        array[i]=n;
                    });
                    $("#j>ul").html("");
                    $("#j").show();
                    if (array.length>0){
                        for (var i=0;i<a.length;i++){
                            $("#j>ul").append("<li>"+a[i]+"</li>");
                        }
                    }else {
                        $("#j").hide();
                    }
                }
            });
        }else if (jiT==""){
            $("#j").hide();
        }
    });
    $("#j>ul").on("click","li",function (e) {
        var v=$(this).html();
        $("#w_jiTai").val(v);
        $("#j").hide();
    });
    /**
     * 上下切换
     */
    $("#w_jiTai").bind("keydown",function (e) {
        var jiT=$("#w_jiTai").val();
        var len=$("#j>ul li").length;
        var i=$("#j>ul").find(".op").index();
        switch (e.keyCode){
            case 38:
                if (i==-1){
                    i=0;
                    $("#j>ul li").eq(i).addClass('op');
                }
                i=$("#j>ul").find(".op").index();
                $("#j>ul li").eq(i).removeClass('op')
                if (i<=0){
                    i=len-1;
                }else{
                    i--;
                }
                $("#j>ul li").eq(i).addClass('op')
                break;//上
            case 40:
                if (len!=0){
                if (i==-1){
                    i=0;
                    $("#j>ul li").eq(i).addClass('op');
                }
                i=$("#j>ul").find(".op").index();
                $("#j>ul li").eq(i).removeClass('op');
                if (i>=len-1){
                    i=0;
                }else{
                    i++;
                }
                $("#j>ul li").eq(i).addClass('op');
                }else if (len==0){
                    $.ajax({
                        type:"post",
                        url:"search",
                        dataType:"text",
                        data:{"w_jiTai":jiT,"type":1},
                        success:function (msg) {
                            var a=JSON.parse(msg);
                            var array=new Array();
                            $.each(a,function (i,n) {
                                array[i]=n;
                            });
                            $("#j>ul").html("");
                            $("#j").show();
                            if (array.length>0){
                                for (var i=0;i<a.length;i++){
                                    $("#j>ul").append("<li>"+a[i]+"</li>");
                                }
                            }else {
                                $("#j").hide();
                            }
                        }
                    });
                }
                break;//下
            case 13:
                if (i==-1){
                    i=0;
                    $("#j>ul li").eq(i).addClass('op');
                }
                var v=$(".op").html();
                $("#w_jiTai").val(v);
                $("#j").hide();
                break;
        }
    });
    /**
     * 鼠标触碰
     */
    $("#j1").on("mouseenter","li",
        function (e) {
            $(this).addClass('op');
            $(".op").nextAll().removeClass();
            $(".op").prevAll().removeClass();
        }
    );
    $("#j1").on("mouseleave","li",function () {
        $(this).removeClass('op');
    });
    //解除单击事件
    $(document).click(function () {
        $("#j").hide();
    });
    $("#j").click(function (e) {
        e.stopPropagation();
    });

});