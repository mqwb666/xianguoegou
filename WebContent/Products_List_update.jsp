<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
<style type="text/css">
	body,*{
		marging:0px;
		padding:0px;
	}
	#d1{
		//border:1px solid red;
		width:800px;
		height:800px;
		margin:20px auto;
	}
	.label_name{
		//border:1px solid red;
		font-size:25px;
	}
	.d2{
	//border:1px solid red;
	height:50px
	}
</style>
<script>
function backTo(){
	location.href="Products_List.html";
}
</script>
</head>
<body onload="check()">
<div id="d1">
<form action="GoodServlet?type=5" method="post" enctype="multipart/form-data">
<fieldset>
<legend><p style="text-align:center; font-family: 宋体; font-size: 30px">修改商品信息</p></legend>
				<div class="d2">
				<input type="hidden" name="id" value="${map.id}">
				<label class="label_name">商品类型：</label>
				<select name="gtid" style="width:100px;height:40px">
					<option >--请选择--</option>
					<option value="1">类型id1</option>
					<option value="2">类型id2</option>
					<option value="3">类型id3</option>
				</select>
				</div>
				<br>
				
				<div class="d2">
				<label class="label_name">供应商：</label>
				<select name="sid" style="width:100px;height:40px">
					<option >--请选择--</option>
					<option value="1">供应商1</option>
					<option value="2">供应商2</option>
					<option value="3">供应商3</option>
				</select>
				</div>
				<br>
				
				<div class="d2">
				<label class="label_name">当前库存：</label>
				<input name="nownumber" type="text" style="width:50px;height:25px" value="${map.nownumber}"></input>
				</div>
				<br>
				
				<div class="d2">
				<label class="label_name">累计库存：</label>
				<input name="number" type="text" style="width:50px;height:25px" value="${map.number}"></input>
				</div>
				<br>
				
				<div class="d2">
				<label class="label_name">价格：</label>
				<input name="price" type="text" style="width:50px;height:25px" value="${map.price}"></input>
				</div>
				<br>
				
				<div class="d2">
				<label class="label_name">商品名称：</label>
				<input name="gname" type="text" style="width:200px;height:25px" value="${map.gname}"></input>
				</div>
				<br>
				
				<div class="d2">
				<label class="label_name">状&nbsp;&nbsp;态</label>
				<input style="" name="ismarket" type="radio" value="0">
				已上架
				</input>
				<input name="ismarket" type="radio" value="1">
				未上架
				</input>
				</div>
				<br>
				
				<div class="d2">
				<label class="label_name">简介：</label>		
				<input name="content" type="text" style="width: 500px;height:25px" value="${map.content}"></input>
				</div>
				<br>
				
				<div class="d2"> 
				<label class="label_name">商品图片：</label>
				<input name="pic" type="file" style="width: 200px; height: 40px"></input>
				</div>
				<p style="color: red; font-family: '微软雅黑'">图片大小小于5MB,支持.jpg;.gif;.png;.jpeg格式的图片</p>
				<input style="width: 80px; height: 40px;" type="submit" value="修改"></input>
				<input style="width: 80px; height: 40px" type="button" onclick="backTo()" value="返回"></input>
						
			</fieldset>
</form>
</div>
</body>
</script>
</html>