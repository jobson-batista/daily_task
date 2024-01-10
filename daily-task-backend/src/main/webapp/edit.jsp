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
	console.log("👀 \n Welcome, curioso!");
</script>
</head>
<body>
	<h1>Editar Tarefa</h1>
	<form name="formTask" action="update">
		<table>
			<tr>
				<td> 
					<div class="fields-edit id_ult_fields id">
						<label>ID</label>
						<input type="text" name="id" id="id-field" readonly
						value="<%out.println(request.getAttribute("id"));%>">
					</div>
				</td>
					
			</tr>
			<tr>
				<td>
					<div class="fields-edit id_ult_fields">
						<label>Última Alteração</label>
						<input type="text" name="dt_ult_alt" id="dt_ult_alt"
						readonly
						value="<%
									String format = "dd/MM/yyyy hh:mm";
									SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
									out.println(request.getAttribute("dt_ult_alt").toString());
								%>">
					</div>
				</td>
			</tr>
			<tr>
				 <td>
				 	<div class="fields-edit">
					 	<label>Descrição</label>
					 	<textarea name="description" class="input1" maxlength="255"><%out.print(request.getAttribute("description"));%></textarea>
					</div>
				</td>
			</tr>
		</table>
			<div class="btnContainer">
				<input type="button" value="Salvar" class="btnAcessar"
				onclick="validate()">
			<input type="button" value="Cancelar" class="btnCancelar"
				onclick="javascript: window.location.href = 'main'">
			</div>
	</form>
	<footer>
	  <p>Autor: Dev Jobson</p>
	  <p><a href="https://github.com/jobson-batista/daily_task" target="_blank"><img src="images/github-icon-black.png" width="20"></a></p>
	</footer>
</body>
</html>