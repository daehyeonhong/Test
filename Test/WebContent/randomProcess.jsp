<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="common.bean.RandomBean"%>
<%@ page import="common.model.RandomDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Random</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="randomBean" class="common.bean.RandomBean" />
	<jsp:setProperty property="*" name="randomBean" />

	<%
	RandomDAO dao = RandomDAO.getInstance();
	RandomBean before = dao.read(randomBean.getSeq());
	dao.updateRandom(randomBean);
	RandomBean after = dao.read(randomBean.getSeq());
	%>

	<h1>변경 전</h1>
	<table style="border: 2px">
		<tr>
			<td>SEQ</td>
			<td><%=before.getSeq()%></td>
		</tr>
		<tr>
			<td>RANDOM1</td>
			<td><%=before.getRandom1()%></td>
		</tr>
		<tr>
			<td>RANDOM2</td>
			<td><%=before.getRandom2()%></td>
		</tr>
		<tr>
			<td>RANDOM3</td>
			<td><%=before.getRandom3()%></td>
		</tr>
		<tr>
			<td>RANDOM4</td>
			<td><%=before.getRandom4()%></td>
		</tr>
		<tr>
			<td>RANDOM5</td>
			<td><%=before.getRandom5()%></td>
		</tr>
		<tr>
			<td>RANDOM6</td>
			<td><%=before.getRandom6()%></td>
		</tr>
		<tr>
			<td>RANDOM7</td>
			<td><%=before.getRandom7()%></td>
		</tr>
		<tr>
			<td>RANDOM8</td>
			<td><%=before.getRandom8()%></td>
		</tr>
	</table>

	<h1>Parameter로 받은 값</h1>
	<table style="border: 2px">
		<tr>
			<td>SEQ</td>
			<td><%=randomBean.getSeq()%></td>
		</tr>
		<tr>
			<td>RANDOM1</td>
			<td><%=randomBean.getRandom1()%></td>
		</tr>
		<tr>
			<td>RANDOM2</td>
			<td><%=randomBean.getRandom2()%></td>
		</tr>
		<tr>
			<td>RANDOM3</td>
			<td><%=randomBean.getRandom3()%></td>
		</tr>
		<tr>
			<td>RANDOM4</td>
			<td><%=randomBean.getRandom4()%></td>
		</tr>
		<tr>
			<td>RANDOM5</td>
			<td><%=randomBean.getRandom5()%></td>
		</tr>
		<tr>
			<td>RANDOM6</td>
			<td><%=randomBean.getRandom6()%></td>
		</tr>
		<tr>
			<td>RANDOM7</td>
			<td><%=randomBean.getRandom7()%></td>
		</tr>
		<tr>
			<td>RANDOM8</td>
			<td><%=randomBean.getRandom8()%></td>
		</tr>
	</table>

	<h1>변경 후</h1>
	<table style="border: 2px">
		<tr>
			<td>SEQ</td>
			<td><%=after.getSeq()%></td>
		</tr>
		<tr>
			<td>RANDOM1</td>
			<td><%=after.getRandom1()%></td>
		</tr>
		<tr>
			<td>RANDOM2</td>
			<td><%=after.getRandom2()%></td>
		</tr>
		<tr>
			<td>RANDOM3</td>
			<td><%=after.getRandom3()%></td>
		</tr>
		<tr>
			<td>RANDOM4</td>
			<td><%=after.getRandom4()%></td>
		</tr>
		<tr>
			<td>RANDOM5</td>
			<td><%=after.getRandom5()%></td>
		</tr>
		<tr>
			<td>RANDOM6</td>
			<td><%=after.getRandom6()%></td>
		</tr>
		<tr>
			<td>RANDOM7</td>
			<td><%=after.getRandom7()%></td>
		</tr>
		<tr>
			<td>RANDOM8</td>
			<td><%=after.getRandom8()%></td>
		</tr>
	</table>
</body>
</html>