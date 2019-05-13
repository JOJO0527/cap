<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>欢迎登录</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #666;
    font-size: 22px;
    font-weight: normal;
    padding-right:17px;
}
 </style>
</head>
<body>	
<div class="container"  style="width:100%;height:460px;background:#FF2C4C url('images/loginbg.jpg') no-repeat;">
<div class="row"> 
	<div class="col-md-7">
		<!--<img src="./image/login.jpg" width="500" height="330" alt="登录" title="登录">-->
	</div>
	
	<div class="col-md-5">
				<div style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;">
				<font>欢迎登录</font>USER LOGIN

				<div>&nbsp;</div>
<%--<form class="form-horizontal">--%>
  <%----%>
 <%--<div class="form-group">--%>
    <%--<label for="username" class="col-sm-2 control-label">用户名</label>--%>
    <%--<div class="col-sm-6">--%>
      <%--<input type="text" class="form-control" id="username" placeholder="请输入用户名">--%>
    <%--</div>--%>
  <%--</div>--%>
   <%--<div class="form-group">--%>
    <%--<label for="inputPassword3" class="col-sm-2 control-label">密码</label>--%>
    <%--<div class="col-sm-6">--%>
      <%--<input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码">--%>
    <%--</div>--%>
  <%--</div>--%>
   <%--<div class="form-group">--%>
        <%--<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>--%>
    <%--<div class="col-sm-3">--%>
      <%--<input type="text" class="form-control" id="inputPassword3" placeholder="请输入验证码">--%>
    <%--</div>--%>
    <%--<div class="col-sm-3">--%>
      <%--<img src="./image/captcha.jhtml"/>--%>
    <%--</div>--%>
    <%----%>
  <%--</div>--%>
   <%--<div class="form-group">--%>
    <%--<div class="col-sm-offset-2 col-sm-10">--%>
      <%--<div class="checkbox">--%>
        <%--<label>--%>
          <%--<input type="checkbox"> 自动登录--%>
        <%--</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
        <%--<label>--%>
          <%--<input type="checkbox"> 记住用户名--%>
        <%--</label>--%>
      <%--</div>--%>
    <%--</div>--%>
  <%--</div>--%>
  <%--<div class="form-group">--%>
    <%--<div class="col-sm-offset-2 col-sm-10">--%>
    <%--<input type="submit"  width="100" value="登录" name="submit" border="0"--%>
    <%--style="background: url('./images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);--%>
    <%--height:35px;width:100px;color:white;">--%>
    <%--</div>--%>
  <%--</div>--%>
<%--</form>--%>
    <form id="formlogin" method="post" onsubmit="return false;">
        <div class=" w1" id="entry">
            <div class="mc " id="bgDiv">
                <div id="entry-bg" clstag="passport|keycount|login|02" style="width: 511px; height: 455px; position: absolute; left: -44px; top: -44px; background: url(/images/544a11d3Na5a3d566.png) 0px 0px no-repeat;">
                </div>
                <div class="form ">
                    <div class="item fore1">
                        <span>用户名</span>
                        <div class="item-ifo">
                            <input type="text" id="loginname" name="username" class="text"  tabindex="1" autocomplete="off"/>
                            <div class="i-name ico"></div>
                            <label id="loginname_succeed" class="blank invisible"></label>
                            <label id="loginname_error" class="hide"><b></b></label>
                        </div>
                    </div>
                    <script type="text/javascript">
                        setTimeout(function () {
                            if (!$("#loginname").val()) {
                                $("#loginname").get(0).focus();
                            }
                        }, 0);
                    </script>
                    <div id="capslock"><i></i><s></s>键盘大写锁定已打开，请注意大小写</div>
                    <div class="item fore2">
                        <span>密码</span>
                        <div class="item-ifo">
                            <input type="password" id="nloginpwd" name="password" class="text" tabindex="2" autocomplete="off"/>
                            <div class="i-pass ico"></div>
                            <label id="loginpwd_succeed" class="blank invisible"></label>
                            <label id="loginpwd_error" class="hide"></label>
                        </div>
                    </div>
                    <div class="item login-btn2013">
                        <input type="button" class="btn-img btn-entry" id="loginsubmit" value="登录" tabindex="8" clstag="passport|keycount|login|06"/>
                    </div>
                </div>
            </div>
            <div class="free-regist">
                <span><a href="/page/register" clstag="passport|keycount|login|08">免费注册&gt;&gt;</a></span>
            </div>
        </div>
    </form>
</div>
    </div>
</div>
</div>
<script type="text/javascript">
    var redirectUrl = "${redirect}";
    var LOGIN = {
        checkInput:function() {
            if ($("#loginname").val() == "") {
                alert("用户名不能为空");
                $("#loginname").focus();
                return false;
            }
            if ($("#nloginpwd").val() == "") {
                alert("密码不能为空");
                $("#nloginpwd").focus();
                return false;
            }
            return true;
        },
        doLogin:function() {
            $.post("/user/login", $("#formlogin").serialize(),function(data){
                if (data.status == 200) {
                    alert("登录成功！");
                    if (redirectUrl == "") {
                        location.href = "http://localhost:8082";
                    } else {
                        location.href = redirectUrl;
                    }
                } else {
                    alert("登录失败，原因是：" + data.msg);
                    $("#loginname").select();
                }
            });
        },
        login:function() {
            if (this.checkInput()) {
                this.doLogin();
            }
        }

    };
    $(function(){
        $("#loginsubmit").click(function(){
            LOGIN.login();
        });
    });
</script>
</body>
</html>