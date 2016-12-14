package br.com.tcc.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Servicos")
public class ListServicos implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Servicos> servicos;
	
	@XmlElement(name="servicos")
	public List<Servicos> getServicos(){
		return servicos;
	}
	public void setServicos(List<Servicos> servicos){
		this.servicos=servicos;
	}
	@Override
	public String toString() {
		return "ListaServicos [servicos=" + servicos + "]";
	}
	
}