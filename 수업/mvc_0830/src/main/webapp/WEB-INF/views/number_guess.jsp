<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자 맞추기 for REST</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#f1").submit(function(evt) {
			//핸들러메서드가 false 반환시 원래행동을 못하게 막는것
			// evt.preventDefault() // 전송기능취소
			sendNumber()
			return false // 전송기능취소
		})
	})
	function sendNumber() {
		var n1 = $("#n1").val() //입력한 숫자
		var options = {
			url : "check_number.ng?no=" + n1,
			success : function(data) {
				$("#msg").html(data.msg)
			},
			error : function() {
			}
		}
		$.ajax(options)
	}
</script>

</head>
<body>
	<h1>숫자맞추기 게임</h1>
	<h3>1~100사이 숫자를 맞춰 보세요~</h3>
	<form action="" id="f1">
		<fieldset>
			<legend>숫자입력</legend>
			<label> 숫자 : <input id="n1" type="number" placeholder="1~100">
				<input type="submit" value="정답확인">
			</label>
		</fieldset>
	</form>
	<div id="msg"></div>
</body>

</html>