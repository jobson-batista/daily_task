<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dailytask.model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	ArrayList<JavaBeans> tasks = (ArrayList<JavaBeans>) request.getAttribute("tasks");
	String format = "dd/MM/yyyy hh:mm";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Daily Task</title>
<link rel="icon" href="images/todolist.png">
<link rel="stylesheet" href="style.css">
<script src="scripts/confirmation.js ">
	console.log("👀 \n Welcome, curioso!");
</script>
</head>
<body>
	<img src="images/todolist.png" height="100">
	<h1>Daily Task</h1>
	<a href="new.html" class="btnAcessar">Nova Tarefa</a>
	<table id="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Descrição</th>
				<th>Data de Criação</th>
				<th>Última Atualização</th>
				<th>Data Finalizado</th>
				<th class="actions-column">Ações</th>
			</tr>
		</thead>
		<tbody>
			<%int itens = 0; %>
			<% for(int i = 0; i < tasks.size(); i++) { %>
				<% if(tasks.get(i).getExcluido() == 0) {%>
				<% itens++; %>
				<tr>
					<td><%=tasks.get(i).getId()%></td>
					<td><%=tasks.get(i).getDescricao()%></td>
					<td><%=tasks.get(i).getDtCriacao()%></td>
					<td><%=tasks.get(i).getDtUltAlt()%></td>
					<td><%if(tasks.get(i).getDtFinalizado() == null){ %>Não Finalizado!
						<%} else {%>
							<%=tasks.get(i).getDtFinalizado()%>
						<%} %>
					</td>
					<td class="actions-icons">
						<%if(tasks.get(i).getFinalizado() == 0) {%>
							<a href="javascript: confirmFinish(<%=tasks.get(i).getId()%>)" class="actions"><img src="images/check.png" width="20"></a>
						<%} else {%>
							<a href="javascript: confirmFinish(<%=tasks.get(i).getId()%>)" class="actions"><img src="images/uncheck.png" width="20"></a>
						<%} %>
						<a href="task?id=<%=tasks.get(i).getId()%>" class="actions"><img src="images/edit.png" width="20"></a>
						<a href="javascript: confirmDelete(<%=tasks.get(i).getId()%>)" class="actions"><img src="images/delete.png" width="20"></a>
					</td>
				</tr>
				<%} %>
			<%} %>
			<%if(itens == 0) {%>
				<tr><td colspan="6" class="zero-task"><img src="images/in-love.png" width="20"><i>Parabéns! Nenhuma tarefa pendente!</i></td></tr>
			<%} %>
		</tbody>
	</table>
	<footer>
	  <p>Autor: Dev Jobson</p>
	  <p><a href="https://github.com/jobson-batista/daily_task" target="_blank"><img src="images/github-icon-black.png" width="20"></a></p>
	</footer>
</body>
</html>