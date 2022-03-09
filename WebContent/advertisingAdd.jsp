<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">	</script>
<script>	
			//显示商品下拉框
			$(function(){
				//alert(1);
				$.ajax({
        			url:"GoodServlet?type=6",
        			type:"post",
        			dataType:"json",
        			success:function(data){
        				
        				var h = "<option> --请选择--</option>";
        				for (var i = 0; i < data.length; i++) {
        					h += "<option value='"+data[i].id+"'>"
        							+ data[i].gname + "</option>"
        					}
        				$("#select").html(h);
        			}
				});
			})
			
			function back(){
				location.href="advertising.html";
			}
			</script>					
<title>添加广告</title>
</head>
<body>
<div id="d1">
<form action="AdvertisingServlet?type=2" method="post" enctype="multipart/form-data">
<fieldset>
<legend><p style="text-align:center; font-family: 宋体; font-size: 30px">添加广告信息</p></legend>
				<div class="d2">
				<label class="label_name">所属商品：</label>
				<select id="select" name="gid" style="width:100px;height:40px">
					
				</select>
				</div>
				<br>
				
				<div class="d2">
				<label class="label_name">广告名称：</label>
				<input name="adname" type="text" style="width:200px;height:25px" ></input>
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
				<label class="label_name">广告内容：</label>		
				<input name="content" type="text" style="width: 500px;height:25px"></input>
				</div>
				<br>
				
				<div class="d2"> 
				<label class="label_name">广告图片：</label>
				<input name="pic" type="file" style="width: 200px; height: 40px"></input>
				</div>
				<p style="color: red; font-family: '微软雅黑'">图片大小小于5MB,支持.jpg;.gif;.png;.jpeg格式的图片</p>
				<input style="width: 80px; height: 40px;" type="submit" value="添加"></input>
				<input style="width: 80px; height: 40px" type="button" onclick="back()" value="返回"></input>
						
			</fieldset>
</form>
</div>
</body>
</html>