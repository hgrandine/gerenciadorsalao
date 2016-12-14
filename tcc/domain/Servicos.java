package br.com.tcc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Servicos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@Column(nullable=false,length=100)
	private String nome;
	
	@Column(nullable=true,length=500)
	private String tipo;
	
	@Column(nullable=false,length=50)
	private String tempo;
		
	@Column(nullable=false,length=50)
	private String valor;
	
	@Column(nullable=false,length=50)
	private String status;
	
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Servicos [id=" + id + ", nome=" + nome + ", descricao=" + tipo + ", tempo=" + tempo + ", valor="
				+ valor + "]";
	}
	
	
}
