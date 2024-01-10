package com.dailytask.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailytask.model.DAO;
import com.dailytask.model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/task", "/update", "/check", "/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans task = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			tasks(request, response);
		} else if (action.equals("/insert")) {
			newTask(request, response);
		} else if (action.equals("/task")) {
			getTask(request, response);
		} else if (action.equals("/update")) {
			updateTask(request, response);
		} else if (action.equals("/check")) {
			checkTask(request, response);
		} else if (action.equals("/delete")) {
			deleteTask(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar tarefas
	protected void tasks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<JavaBeans> taskList = dao.getTasks();
		// Encaminhar as tasks para o jsp
		request.setAttribute("tasks", taskList);
		RequestDispatcher rd = request.getRequestDispatcher("tasks.jsp");
		rd.forward(request, response);
	}

	// Criar uma nova tarefa
	protected void newTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		task.setDescricao(request.getParameter("description"));
		dao.insertTask(task);

		response.sendRedirect("main");
	}

	// Buscando task pelo ID
	protected void getTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		task.setId(id);
		dao.selectTask(task);
		System.out.println(task.getDtCriacao());
		// Settar atributos no formulario com conteudo do JavaBeans
		request.setAttribute("id", task.getId());
		request.setAttribute("description", task.getDescricao().trim());
		request.setAttribute("dt_criacao", task.getDtCriacao());
		// Encaminhar conteudo para o arquivo edit.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		rd.forward(request, response);
	}

	protected void updateTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		task.setId(request.getParameter("id"));
		task.setDescricao(request.getParameter("description"));
		task.setDtUltAlt(new Date());
		dao.updateTask(task);
		response.sendRedirect("main");
	}

	protected void checkTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		task.setId(request.getParameter("id"));
		dao.finishTask(task);
		response.sendRedirect("main");
	}

	// Deletar tarefa
	protected void deleteTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		task.setId(id);
		dao.deleteTask(task);
		response.sendRedirect("main");
	}

}
