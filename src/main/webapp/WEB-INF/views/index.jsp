<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" content="">
<title>AjaxでJSONファイルを読み込みパースします。</title>
<link href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"
	type="text/javascript"></script>
<!-- スクリプト部分 -->
<script type="text/javascript">
	$(function() {
		// Ajax通信テスト ボタンクリック
		$("#time").change(function() {
			// outputDataを空に初期化
			$("#output_data").text("");
			//セレクトボックスで選んだ値のtextを取得
			var time = $("[name=time] option:selected").text();
			console.log(time);
			$.ajax({
				url : "json",
				dataType : "json",
				data : {
					//key : value
					//"time" : 変数timeと同義
					time : time,
					date : "2017/6/4"
				},
				success : function(data) {
					success(data);
				},
				error : function() {
					error();
				}
			});
		});
	});

	// Ajax通信成功時処理
	function success(data) {
		//$("#output_data").text("");
		//for (var cnt = 0; cnt < data.length; cnt++) {
		//	$("#output_data").append("data[" + cnt + "]：" + data[cnt] + "；");
		//}

		console.log(data);
		for (var cnt = 0; cnt < data.length; cnt++) {
			$("#output_data").html($("#output_data").html() +
					"id:" + data[cnt].id + "  name:" + data[cnt].name + "  selectTime:" + data[cnt].time + "<br>");
		}
	}

	// Ajax通信失敗時処理
	function error() {
		alert("通信失敗");
	}
</script>

</head>
<!-- HTML部分 -->
<body>
	<h1>Hello world!</h1>

	<div id="ajax_data">
		<select id="time" name="time">
			<option>8:00</option>
			<option>9:00</option>
			<option>10:00</option>
			<option>11:00</option>
			<option>12:00</option>
			<option>13:00</option>
			<option>14:00</option>
			<option>15:00</option>
			<option>16:00</option>
			<option>17:00</option>
			<option>18:00</option>
			<option>19:00</option>
			<option>20:00</option>
			<option>21:00</option>
			<option>22:00</option>
			<option>23:00</option>
		</select>
		outputData：<p id="output_data"></p>
	</div>

</body>
</html>