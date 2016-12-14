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
public class Agenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@Column(nullable=false,length=100)
	private int responsavel;
	
	@Column(nullable=true,length=500)
	private String data;
	
	@Column(nullable=false,length=50)
	private int servicos;
		
	@Column(nullable=false,length=50)
	private String hora_inicio;
	
	@Column(nullable=false,length=50)
	private String hora_fim;

	//0 para desativado e 1 para ativado
	@Column(nullable=false,length=50)
	private String status;

	//0 para desativado e 1 para ativado
	@Column(nullable=false,length=50)
	private int cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getServico() {
		return servicos;
	}

	public void setServico(int servico) {
		this.servicos= servico;
	}
	
	public int getServicos() {
		return servicos;
	}

	public void setServicos(int servicos) {
		this.servicos = servicos;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(String hora_fim) {
		this.hora_fim = hora_fim;
	}

	public String getStatus() {
		return status;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", responsavel=" + responsavel + ", data=" + data + ", servicos=" + servicos
				+ ", hora_inicio=" + hora_inicio + ", hora_fim=" + hora_fim + ", status=" + status + ", cliente="
				+ cliente + "]";
	}

	
	


	
}
