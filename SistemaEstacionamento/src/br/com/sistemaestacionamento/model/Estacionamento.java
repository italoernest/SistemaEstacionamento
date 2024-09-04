package br.com.sistemaestacionamento.model;

import java.util.Date;

public class Estacionamento {
	private Integer id;
	private String placa;
	private Date entrada;
	private Date saida;
	private Double valor;
	private Integer status;
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public Date getEntrada() {
		return entrada;
	}
	public Date getSaida() {
		return saida;
	}
}
