<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Random</title>
	</head>
	<body>
		<button onclick="random()">랜덤번호 생성</button>
		<form action="randomProcess.jsp" method="post">
			<input id="seq" name="seq" type="text" placeholder="SEQ를 입력해주세요." />
			<input id="random1" name="random1" type="text" />
			<input id="random2" name="random2" type="text" />
			<input id="random3" name="random3" type="text" />
			<input id="random4" name="random4" type="text" />
			<input id="random5" name="random5" type="text" />
			<input id="random6" name="random6" type="text" />
			<input id="random7" name="random7" type="text" />
			<input id="random8" name="random8" type="text" />
			<input type="submit" value="전송" />
		</form>
		<script type="text/javascript">
			const random = function () {
				const rand1 = Math.round(Math.random() * 1000);
				const rand2 = Math.round(Math.random() * 1000);
				const rand3 = Math.round(Math.random() * 1000);
				const rand4 = Math.round(Math.random() * 1000);
				const rand5 = Math.round(Math.random() * 1000);
				const rand6 = Math.round(Math.random() * 1000);
				const rand7 = Math.round(Math.random() * 1000);
				const rand8 = Math.round(Math.random() * 1000);
				document.querySelector("#random1").value = rand1;
				document.querySelector("#random2").value = rand2;
				document.querySelector("#random3").value = rand3;
				document.querySelector("#random4").value = rand4;
				document.querySelector("#random5").value = rand5;
				document.querySelector("#random6").value = rand6;
				document.querySelector("#random7").value = rand7;
				document.querySelector("#random8").value = rand8;
			};
		</script>
	</body>
</html>