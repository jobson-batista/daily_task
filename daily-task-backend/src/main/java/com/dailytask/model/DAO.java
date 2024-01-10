package com.dailytask.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	/** Módulo de conexão **/

	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/prova_remsoft?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "35153515";

	// Métodos de conexão
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			return null;
		}
	}

	public void insertTask(JavaBeans task) {
		String create = "insert into tarefa (descricao) values (?)";
		try {
			// Abrir conexão
			Connection con = connect();

			// Preparar a query para execucao no BD
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os parametros pelo conteudo pelas variaveis JavaBeans
			pst.setString(1, task.getDescricao());

			// Executar a query
			pst.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
		}
	}

	public List<JavaBeans> getTasks() {
		ArrayList<JavaBeans> tasks = new ArrayList<>();
		String select = "select * from tarefa order by dt_ult_alt, finalizado desc";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(select);
			// ResultSet armazena de maneira temporaria
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String descricao = rs.getString(2);
				byte finalizado = rs.getByte(3);
				Date dtFinalizado = rs.getDate(4);
				Date dtCriacao = rs.getDate(5);
				Date dtUltAlt = rs.getDate(6);
				byte excluido = rs.getByte(7);

				tasks.add(new JavaBeans(id, descricao, finalizado, dtFinalizado, dtCriacao, dtUltAlt, excluido));
			}
			con.close();
			return tasks;
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			return null;
		}
	}

	public void selectTask(JavaBeans task) {
		String selectTaskById = "select * from tarefa where id = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(selectTaskById);
			pst.setString(1, task.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				task.setId(rs.getString(1));
				task.setDescricao(rs.getString(2));
				task.setFinalizado(rs.getByte(3));
				task.setDtFinalizado(rs.getDate(4));
				task.setDtCriacao(rs.getDate(5));
				task.setDtUltAlt(rs.getDate(6));
				task.setExcluido(rs.getByte(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
		}
	}

	public void updateTask(JavaBeans task) {
		String updateQuery = "update tarefa set descricao=?, dt_ult_alt=? where id=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setString(1, task.getDescricao());
			pst.setDate(2, new java.sql.Date(task.getDtUltAlt().getTime()));
			pst.setString(3, task.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString().toString());
		}
	}

	public void deleteTask(JavaBeans task) {
		String deleteLogicalQuery = "update tarefa set excluido = 1 where id = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(deleteLogicalQuery);
			pst.setString(1, task.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
		}
	}
}
