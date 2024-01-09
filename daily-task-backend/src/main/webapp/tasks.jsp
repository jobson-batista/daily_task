<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dailytask.model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<JavaBeans> tasks = (ArrayList<JavaBeans>) request.getAttribute("tasks");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Daily Task</title>
<link rel="icon" href="images/todolist.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Daily Task</h1>
	<a href="new.html" class="btnAcessar">Nova Tarefa</a>
	<table id="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Descrição</th>
				<th>Data de Criação</th>
				<th>Última Atualização</th>
				<th class="actions-column">Ações</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i < tasks.size(); i++) { %>
				<tr>
					<td><%=tasks.get(i).getId()%></td>
					<td><%=tasks.get(i).getDescricao()%></td>
					<td><%=tasks.get(i).getDtCriacao()%></td>
					<td><%=tasks.get(i).getDtUltAlt()%></td>
					<td>
						<%if(tasks.get(i).getFinalizado() == 0) {%>
							<a href="" class="actions"><img src="images/check.png" width="20"></a>
						<%} else {%>
							<a href="" class="actions"><img src="images/uncheck.png" width="20"></a>
						<%} %>
						<a href="task?id=<%=tasks.get(i).getId()%>" class="actions"><img src="images/edit.png" width="20"></a>
						<a href="" class="actions"><img src="images/delete.png" width="20"></a>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>