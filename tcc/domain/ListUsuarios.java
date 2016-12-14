package br.com.tcc.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Usuarios")
public class ListUsuarios implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Usuarios> usuarios;
	
	@XmlElement(name="usuarios")
	public List<Usuarios> getUsuarios(){
		return usuarios;
	}
	public void setUsuarios(List<Usuarios> usuarios){
		this.usuarios=usuarios;
	}
	@Override
	public String toString() {
		return "ListaUsuarios [usuarios=" + usuarios + "]";
	}
	
}