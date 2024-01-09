<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Daily Tasks</title>
<link rel="icon" href="images/todolist.png">
<link rel="stylesheet" href="style.css">
<script src="scripts/validator.js"></script>
</head>
<body>
	<h1>Editar Tarefa</h1>
	<form name="formTask" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="id-field"
					readonly
					value="<%out.println(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="dt_criacao" id="dt_criacao"
					readonly
					value="<%out.println(request.getAttribute("dt_criacao"));%>"></td>
			</tr>
			<tr>

				<td><textarea name="description" class="input1" maxlength="255">
						<%out.print(request.getAttribute("description"));%>
					</textarea></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="btnAcessar"
			onclick="validate()">
	</form>
</body>
</html>