package atividade;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Computador {
	@Id
	private String id;
	private String memoria;
	private String modelo;
	private String voltagem;

	public Computador() {
		id = UUID.randomUUID().toString();
	}

	public Computador(String memoria, String modelo, String voltagem) {
		
		this.memoria = memoria;

		this.modelo = modelo;

		this.voltagem = voltagem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(String voltagem) {
		this.voltagem = voltagem;
	}
    
}
