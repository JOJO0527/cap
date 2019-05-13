<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>爱收藏</title>
		<link rel="stylesheet" href="../../css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">
			<div class="container-fluid">
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<li><a href="login.html">登录</a></li>
						<li><a href="register.html">注册</a></li>
						<li><a href="order_list.html">我的竞拍藏品</a></li>
						<li><a href="add.html">上传藏品</a></li>
					</ol>
				</div>
			</div>
			<!--
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active"><a href="product_list.htm">推荐藏品欣赏<span class="sr-only">(current)</span></a></li>
								<li><a href="product_list.html">瓷器</a></li>
								<li><a href="product_list.html">字画</a></li>
								<li><a href="product_list.html">玉器</a></li>
							</ul>
							<form class="navbar-form navbar-right" role="search">
								<div class="form-group">
									<input type="text" class="text" placeholder="搜索其它类别">
                                    <%--<input type="text" class="text" accesskey="s" id="key" autocomplete="off" onkeydown="javascript:if(event.keyCode==13) search('key');">--%>

								</div>
                                <%--<input type="button" value="搜索" class="btn btn-default" onclick="search('key');return false;" clstag="homepage|keycount|home2013|03a">--%>
                                <button type="submit" class="btn btn-default">搜索</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>

			<!--
            	描述：轮播条
            -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active" align="center">
							<img src="img/1.jpg" align="center">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item" align="center">
							<img src="img/2.jpg" align="center">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item" align="center">
							<img src="img/3.jpg" align="center">
							<div class="carousel-caption">

							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--
            	描述：藏品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>推荐藏品&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.html">
							<img src="" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
					
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_infol.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>

					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>字画</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
				</div>
			</div>
			<!--
            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>推荐藏品&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.html">
							<img src="" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
					
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.html">
							<img src="" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>青花瓷</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;29999.00</font></p>
					</div>
				</div>
			</div>
        </div>
	</body>

</html>