package com.dailytask.model;

public class JavaBeans {
	
	private String id;
	
	private String descricao;
	
	private byte finalizado;
	
	private String dtFinalizado;
	
	private String dtCriacao;
	
	private String dtUltAlt;
	
	private byte excluido;

	public JavaBeans() {
		super();
	}

	public JavaBeans(String id, String descricao, byte finalizado, String dtFinalizado, String dtCriacao, String dtUltAlt,
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

	public String getDtFinalizado() {
		return dtFinalizado;
	}

	public void setDtFinalizado(String dtFinalizado) {
		this.dtFinalizado = dtFinalizado;
	}

	public String getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getDtUltAlt() {
		return dtUltAlt;
	}

	public void setDtUltAlt(String dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}

	public byte getExcluido() {
		return excluido;
	}

	public void setExcluido(byte excluido) {
		this.excluido = excluido;
	}
	
}
