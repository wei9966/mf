$(function () {
// <%--动态搜索--%>
$("#hcName").bind('input',function () {
    var cName=$("#hcName").val();
    if (cName!=""){
        $.ajax({
            type:"post",
            url:"search",
            dataType:"text",
            data:{"cName":cName,"type":2},
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
    }else if (cName==""){
        $("#j").hide();
    }
});
/**
 * 鼠标单击绑定
 * */
$("#j1").on("click","li",function (e) {
    var v=$(this).html();
    $("#hcName").val(v);
    $("#j").hide();
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
/**
 * 上下切换
 */
$("#hcName").bind("keydown",function (e) {
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
            if (i==-1){
                i=0;
                $("#j>ul li").eq(i).addClass('op');
            }
            i=$("#j>ul").find(".op").index();
            $("#j>ul li").eq(i).removeClass('op')
            if (i>=len-1){
                i=0;
            }else{
                i++;
            }
            $("#j>ul li").eq(i).addClass('op')
            break;//下
        case 13:
            if (i==-1){
                i=0;
                $("#j>ul li").eq(i).addClass('op');
            }
            var v=$(".op").html();
            $("#hcName").val(v);
            $("#j").hide();
            break;
    }
});
//取消单击隐藏事件
$(document).click(function () {
    $("#j").hide();
});
$("#j").click(function (e) {
    e.stopPropagation();
});
//ajax报价
$("#hsub").click(function () {
    var cName=$("#hcName").val();
    var pName=$("#hpName").val();
    var fmType= $("#hfmType").val();
    var fmKs=	$("#hfmKs").val();
    var fmPs=$("#hfmPs").val();
    var cpSize=$("#hcpSize").val();
    var count=$("#hcount").val();
    var nxType=$("#hnxType").val();
    var nxKs=$("#hnxKs").val();
    var nxPs=$("#hnxPs").val();
    var fumo=$("#hfumo").val();
    var cyKs=$("#hcyKs").val();
    var cyPs=$("#hcyPs").val();
    var cyType=$("#hcyType").val();
    var zd=$("#hzd").val();
    var sType=$("#hsType").val();
    var h1=$("#hh1").val();
    var h2=$("#hh2").val();
    var h3=$("#hh3").val();
    var h4=$("#hh4").val();
    var h5=$("#hh5").val();
    var hv1=$("#hhv1").val();
    var hv2=$("#hhv2").val();
    var hv3=$("#hhv3").val();
    var hv4=$("#hhv4").val();
    var hv5=$("#hhv5").val();
    var pResult=$("#hpResult").val();
    var fmMs=$("#hfmMs").val();
    var nxMs=$("#hnxMs").val();
    var cyMs=$("#hcyMs").val();
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
    var obj={
        "hcName":cName,
        "hpName":pName,
        "hfmType":fmType,
        "hfmKs":fmKs,
        "hfmPs":fmPs,
        "hcpSize":cpSize,
        "hcount":count,
        "hnxType":nxType,
        "hnxKs":nxKs,
        "hnxPs":nxPs,
        "hfumo":fumo,
        "hzd":zd,
        "hsType":sType,
        "hhv1":hv1,
        "hhv2":hv2,
        "hhv3":hv3,
        "hhv4":hv4,
        "hhv5":hv5,
        "hh1":h1,
        "hh2":h2,
        "hh3":h3,
        "hh4":h4,
        "hh5":h5,
        "hpResult":pResult,
        "hcyType":cyType,
        "hcyKs":cyKs,
        "hcyPs":cyPs,
        "hfmMs":fmMs,
        "hnxMs":nxMs,
        "hcyMs":cyMs
    }
    var oo=  JSON.stringify(obj);
    $.ajax({
        type:"post",
        url:"baoJia",
        dataType:"text",
        data:{"oo":oo,"type":1},
        success:function (msg) {
            var a= JSON.parse(msg);
            var fmResult=a.fmResult;
            var nxResult=a.nxResult;
            var hjgResult=a.hjgResult;
            var cyResult=a.cyResult;
            var psResult=a.psResult;
            var resultMoney=a.resultMoney;
            $("#hfmResult").text(fmResult);
            $("#hnxResult").text(nxResult);
            $("#hcyResult").text(cyResult);
            $("#hhjgResult").text(hjgResult);
            $("#hpsResult").text(psResult);
            $("#hresultMoney").text(resultMoney);
        }
    });
});
});