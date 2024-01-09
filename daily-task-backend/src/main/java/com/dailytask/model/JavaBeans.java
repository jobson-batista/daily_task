package com.dailytask.model;

import java.util.Date;

public class JavaBeans {
	
	private String id;
	
	private String descricao;
	
	private byte finalizado;
	
	private Date dtFinalizado;
	
	private Date dtCriacao;
	
	private Date dtUltAlt;
	
	private byte excluido;

	public JavaBeans() {
		super();
	}

	public JavaBeans(String id, String descricao, byte finalizado, Date dtFinalizado, Date dtCriacao, Date dtUltAlt,
			byte excluido) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.finalizado = finalizado;
		this.dtFinalizado = dtFinalizado;
		this.dtCriacao = dtCriacao;
		this.dtUltAlt = dtUltAlt;
		this.excluido = excluido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(byte finalizado) {
		this.finalizado = finalizado;
	}

	public Date getDtFinalizado() {
		return dtFinalizado;
	}

	public void setDtFinalizado(Date dtFinalizado) {
		this.dtFinalizado = dtFinalizado;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtUltAlt() {
		return dtUltAlt;
	}

	public void setDtUltAlt(Date dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}

	public byte getExcluido() {
		return excluido;
	}

	public void setExcluido(byte excluido) {
		this.excluido = excluido;
	}
	
}
