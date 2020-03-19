$(function () {
// <%--动态搜索--%>
$("#s_cName").bind('input',function () {
    var cName=$("#s_cName").val();
    if (cName!=""){
        $.ajax({
            type:"post",
            url:"/search/searchCName",
            dataType:"text",
            data:{"cName":cName},
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
    $("#s_cName").val(v);
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
$("#s_cName").bind("keydown",function (e) {
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
            $("#s_cName").val(v);
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
//ajax书刊报价
$("#s_sub").click(function () {
    var cName=$("#s_cName").val();
    var pName=$("#s_pName").val();
    var fmType= $("#s_fmType").val();
    var fmKs=	$("#s_fmKs").val();
    var fmPs=$("#s_fmPs").val();
    var cpSize=$("#s_cpSize").val();
    var count=$("#s_count").val();
    var nxType=$("#s_nxType").val();
    var nxKs=$("#s_nxKs").val();
    var nxPs=$("#s_nxPs").val();
    var fumo=$("#s_fumo").val();
    var cyKs=$("#s_cyKs").val();
    var cyPs=$("#s_cyPs").val();
    var cyType=$("#s_cyType").val();
    var zd=$("#s_zd").val();
    var sType=$("#s_sType").val();
    var h1=$("#s_h1").val();
    var h2=$("#s_h2").val();
    var h3=$("#s_h3").val();
    var h4=$("#s_h4").val();
    var h5=$("#s_h5").val();
    var hv1=$("#s_hv1").val();
    var hv2=$("#s_hv2").val();
    var hv3=$("#s_hv3").val();
    var hv4=$("#s_hv4").val();
    var hv5=$("#s_hv5").val();
    var pResult=$("#s_pResult").val();
    var fmMs=$("#s_fmMs").val();
    var nxMs=$("#s_nxMs").val();
    var cyMs=$("#s_cyMs").val();
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
        "s_cName":cName,
        "s_pName":pName,
        "s_fmType":fmType,
        "s_fmKs":fmKs,
        "s_fmPs":fmPs,
        "s_cpSize":cpSize,
        "s_count":count,
        "s_nxType":nxType,
        "s_nxKs":nxKs,
        "s_nxPs":nxPs,
        "s_fumo":fumo,
        "s_zd":zd,
        "s_sType":sType,
        "s_hv1":hv1,
        "s_hv2":hv2,
        "s_hv3":hv3,
        "s_hv4":hv4,
        "s_hv5":hv5,
        "s_h1":h1,
        "s_h2":h2,
        "s_h3":h3,
        "s_h4":h4,
        "s_h5":h5,
        "s_pResult":pResult,
        "s_cyType":cyType,
        "s_cyKs":cyKs,
        "s_cyPs":cyPs,
        "s_fmMs":fmMs,
        "s_nxMs":nxMs,
        "s_cyMs":cyMs
    }
    var oo=  JSON.stringify(obj);
    $.ajax({
        type:"post",
        url:"baoJia/skBaoJia",
        dataType:"text",
        data:{"oo":oo},
        success:function (msg) {
            var a= JSON.parse(msg);
            var fmResult=a.fmResult;
            var nxResult=a.nxResult;
            var hjgResult=a.hjgResult;
            var cyResult=a.cyResult;
            var psResult=a.psResult;
            var resultMoney=a.resultMoney;
            $("#s_fmResult").text(fmResult);
            $("#s_nxResult").text(nxResult);
            $("#s_cyResult").text(cyResult);
            $("#s_hjgResult").text(hjgResult);
            $("#s_psResult").text(psResult);
            $("#s_resultMoney").text(resultMoney);
        }
    });
});
});