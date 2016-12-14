package br.com.tcc.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.com.tcc.domain.Agenda;
import br.com.tcc.domain.Usuarios;

@Component
@SuppressWarnings("unchecked")
public class AgendaDAO extends HibernateDAO<Agenda> {
	public AgendaDAO() {
		// Informa o tipo da entidade para o Hibernate
		super(Agenda.class);
	}

	// Insere ou atualiza um horario
	public void salvar(Agenda u) {
		super.save(u);
	}
	
		
	
	// Consulta todos os horarios
	public List<Agenda> getHorarios() {
		Query q = getSession().createQuery("from Agenda");
		List<Agenda> horarios = q.list();
		return horarios;
	}
	
	public List<Agenda> getAgenda() {
		Query q = getSession().createQuery("from Agenda ORDER BY data");
		List<Agenda> agenda = q.list();
		return agenda;
	}
	
	// Consulta horarios por usuario
	public List<Agenda> findByResponsavel(String responsavel) {
		Query q = getSession().createQuery("from Agenda where lower(responsavel)  like lower(?) ");
		q.setString(0, responsavel);
		return q.list();
	}

	public List<Agenda> findByIdCliente(String idCliente) {
		Query q = getSession().createQuery("from Agenda where lower(cliente)  like lower(?) and data >= CURRENT_DATE ORDER BY data");
		q.setString(0, idCliente);
		return q.list();
	}
	public List<Agenda> findByIdAgenda(String agenda) {
		Query q = getSession().createQuery("from Agenda where lower(id)  like lower(?)");
		q.setString(0, agenda);
		return q.list();
	}
	// Consulta horario por usuario e dia
	public List<Agenda> findByDiaNome(String responsavel, String data) {
		Query q = getSession().createQuery("from Agenda where responsavel= :responsavel and  data= :data");
		q.setString("responsavel", responsavel);
		q.setString("data", data);
		return q.list();
	}

	// Deleta horario pelo id
	public boolean delete(Long id) {
		Agenda c = get(id);
		delete(c);
		return true;
	}

	// Consulta horario por usuario e dia
	public List<Agenda> horarioDisponivel(String idFuncionario, String data) {
		Query q = getSession().createQuery("from Agenda where responsavel= :responsavel and  data= :data");
		q.setString("responsavel", idFuncionario);
		q.setString("data", data);
		return q.list();
	}
	

}
