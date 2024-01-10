package com.dailytask.model;

import java.sql.Connection;
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
	private String user = "USUARIO_AQUI";
	private String password = "SENHA_AQUI";

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
		String select = "select id, "
				+ " descricao, "
				+ "finalizado, "
				+ "date_format(dt_finalizado, '%d/%m/%Y %H:%i:%s'), "
				+ "date_format(dt_criacao, '%d/%m/%Y %H:%i:%s'), "
				+ "date_format(dt_ult_alt, '%d/%m/%Y %H:%i:%s'), "
				+ "excluido "
				+ "from tarefa order by dt_ult_alt desc";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(select);
			// ResultSet armazena de maneira temporaria
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String descricao = rs.getString(2);
				byte finalizado = rs.getByte(3);
				String dtFinalizado = rs.getString(4);
				String dtCriacao = rs.getString(5);
				String dtUltAlt = rs.getString(6);
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
		String selectTaskById = "select id, "
				+ " descricao, "
				+ "finalizado, "
				+ "date_format(dt_finalizado, '%d/%m/%Y %H:%i:%s'), "
				+ "date_format(dt_criacao, '%d/%m/%Y %H:%i:%s'), "
				+ "date_format(dt_ult_alt, '%d/%m/%Y %H:%i:%s'), "
				+ "excluido "
				+ "from tarefa where id = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(selectTaskById);
			pst.setString(1, task.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				task.setId(rs.getString(1));
				task.setDescricao(rs.getString(2));
				task.setFinalizado(rs.getByte(3));
				task.setDtFinalizado(rs.getString(4));
				task.setDtCriacao(rs.getString(5));
				task.setDtUltAlt(rs.getString(6));
				task.setExcluido(rs.getByte(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
		}
	}

	public void updateTask(JavaBeans task) {
		String updateQuery = "update tarefa set descricao=?, dt_ult_alt = current_timestamp() where id=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setString(1, task.getDescricao());
			pst.setString(2, task.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString().toString());
		}
	}

	public void deleteTask(JavaBeans task) {
		String deleteLogicalQuery = "update tarefa set excluido = 1, dt_ult_alt = current_timestamp() where id = ?";
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

	public void finishTask(JavaBeans task) {
		String finishTaskQuery = "";

		try {
			selectTask(task);
			Connection con = connect();
			if (task.getFinalizado() == 0) {
				finishTaskQuery = "update tarefa set finalizado = ?, dt_finalizado = current_timestamp() where id = ?";
			} else {
				finishTaskQuery = "update tarefa set finalizado = ?, dt_finalizado = ? where id = ?";
			}
			
			PreparedStatement pst = con.prepareStatement(finishTaskQuery);
			
			if (task.getFinalizado() == 0) {
				pst.setByte(1, (byte) 1);
				pst.setString(2, task.getId());
			} else {
				pst.setByte(1, (byte) 0);
				pst.setNull(2, java.sql.Types.NULL);
				pst.setString(3, task.getId());
			}
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
