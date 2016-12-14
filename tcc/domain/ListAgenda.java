package br.com.tcc.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Servicos")
public class ListAgenda implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Agenda> horarios;
	
	@XmlElement(name="servicos")
	public List<Agenda> getHorarios(){
		return horarios;
	}
	public void setHorario(List<Agenda> horarios){
		this.horarios=horarios;
	}
	@Override
	public String toString() {
		return "ListaAgenda [horarios=" + horarios + "]";
	}
	
}