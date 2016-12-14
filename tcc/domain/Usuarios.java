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
public class Usuarios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@Column(nullable=false,length=100)
	private String nome;
	
	@Column(nullable=true,length=500)
	private String email;
	
	@Column(nullable=false,length=50)
	private String senha;
	
	private transient String confirmaSenha;
	
	@Column(nullable=false,length=50)
	private String telefone;
	
	@Column(nullable=false,length=50)
	private String celular;
	
	@Column(nullable=false,length=50)
	private String permissao;
	
	@Column(nullable=false,length=25)
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", confirmaSenha="
				+ confirmaSenha + ", telefone=" + telefone + ", celular=" + celular + ", permissao=" + permissao + "]";
	}	
	
	
}
