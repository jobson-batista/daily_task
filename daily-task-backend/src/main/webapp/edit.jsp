<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Daily Tasks</title>
<link rel="icon" href="images/todolist.png">
<link rel="stylesheet" href="style.css">
<script src="scripts/validator.js">
	document.querySelector("textarea").value = document.querySelector("textarea").value.trim();
</script>
</head>
<body>
	<h1>Editar Tarefa</h1>
	<form name="formTask" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="id-field" readonly
					value="<%out.println(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="dt_criacao" id="dt_criacao"
					readonly
					value="<%
								String format = "dd/MM/yyyy hh:mm";
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
								out.println(simpleDateFormat.format(request.getAttribute("dt_criacao")));
							%>"></td>
			</tr>
			<tr>
				 <td><textarea name="description" class="input1" maxlength="255"><%out.print(request.getAttribute("description"));%></textarea></td>
			</tr>
		</table>
			<div class="btnContainer">
				<input type="button" value="Salvar" class="btnAcessar"
				onclick="validate()">
			<input type="button" value="Cancelar" class="btnCancelar"
				onclick="javascript: window.location.href = 'main'">
			</div>
	</form>
</body>
</html>