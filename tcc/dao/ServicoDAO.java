package br.com.tcc.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.com.tcc.domain.Servicos;

@Component
@SuppressWarnings("unchecked")
public class ServicoDAO extends HibernateDAO<Servicos> {
	public ServicoDAO() {
		// Informa o tipo da entidade para o Hibernate
		super(Servicos.class);
	}

	// Insere ou atualiza um servicos
	public void salvar(Servicos u) {
		super.save(u);
	}

	// Consulta todos os servicos
	public List<Servicos> getServicos() {
		Query q = getSession().createQuery("from Servicos where lower(status) like lower(?)");

		q.setString(0, "ATIVO");
		return q.list();
	}
	
	public List<Servicos> findByNome(String nome) {
		Query q = getSession().createQuery("from Servicos where lower(nome)  like lower(?) and lower(status) like lower(?)");
		q.setString(0, "%"+nome+"%");
		q.setString(1, "ATIVO");
		return q.list();
	}
	public List<Servicos> findById(String id) {
		Query q = getSession().createQuery("from Servicos where lower(id)  like lower(?) and lower(status) like lower(?)");
		q.setString(0, id);
		q.setString(1, "ATIVO");
		return q.list();
	}
	
	public List<Servicos> findByTipo(String tipo) {
		Query q = getSession().createQuery("from Servicos where lower(status) like lower(?) and lower(tipo) like lower(?)");
		q.setString(0, "ATIVO");
		q.setString(1, tipo);
		
		return q.list();
	}
	
	// Deleta o servico pelo id
		public boolean delete(Long id) {
			Servicos c = get(id);
			delete(c);
			return true;
		}
}
