package br.com.tcc.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.com.tcc.domain.Usuarios;

@Component
@SuppressWarnings("unchecked")
public class UsuarioDAO extends HibernateDAO<Usuarios> {
	public UsuarioDAO() {
		// Informa o tipo da entidade para o Hibernate
		super(Usuarios.class);
	}

	// Insere ou atualiza um usuarios
	public void salvar(Usuarios u) {
		super.save(u);
	}

	// Consulta todos os usuarios
	public List<Usuarios> getUsuarios() {
		Query q = getSession().createQuery("from Usuarios");
		List<Usuarios> usuarios = q.list();
		return usuarios;
	}
	
	public List<Usuarios> findByEmail(String email) {
		Query q = getSession().createQuery("from Usuarios where lower(email)  like lower(?) and lower(status) like lower(?)");
		q.setString(0, email);
		q.setString(1, "ATIVO");
		return q.list();
	}
	public List<Usuarios> findByEmail2(String email) {
		Query q = getSession().createQuery("from Usuarios where lower(email)  like lower(?) and lower(status) like lower(?) and lower(permissao) not like lower(?)");
		q.setString(0, email);
		q.setString(1, "ATIVO");
		q.setString(2, "ADMINISTRADOR");
		return q.list();
	}
	
	public List<Usuarios> getFuncionarios() {
		Query q = getSession().createQuery("from Usuarios where lower(permissao) like lower(?) and lower(status) like lower(?)");
		q.setString(0, "FUNCIONARIO");
		q.setString(1, "ATIVO");
		return q.list();
	}
	
	
	
	public List<Usuarios> findByNome2(String nome) {
		Query q = getSession().createQuery("from Usuarios where lower(nome) like lower(?) and lower(status) like lower(?) and lower(permissao) not like lower(?)");
		q.setString(0, "%"+nome+"%");
		q.setString(1, "ATIVO");
		q.setString(2, "ADMINISTRADOR");
		return q.list();
	}
	public List<Usuarios> findByNome(String nome) {
		Query q = getSession().createQuery("from Usuarios where lower(nome) like lower(?) and lower(status) like lower(?)");
		q.setString(0, "%"+nome+"%");
		q.setString(1, "ATIVO");
		return q.list();
	}
	
	
	public List<Usuarios> findByTelefone(String telefone) {
		Query q = getSession().createQuery("from Usuarios where lower(telefone)  like lower(?) and lower(status) like lower(?)");
		q.setString(0, telefone);
		q.setString(1, "ATIVO");
		return q.list();
	}
	public List<Usuarios> findByTelefone2(String telefone) {
		Query q = getSession().createQuery("from Usuarios where lower(telefone)  like lower(?) and lower(status) like lower(?) and lower(permissao) not like lower(?)");
		q.setString(0, telefone);
		q.setString(1, "ATIVO");
		q.setString(2, "ADMINISTRADOR");
		return q.list();
	}
	
	
	
	public List<Usuarios> findById(String id) {
		Query q = getSession().createQuery("from Usuarios where lower(id)  like lower(?)");
		q.setString(0, id);
		return q.list();
	}
	public List<Usuarios> findById2(String id) {
		Query q = getSession().createQuery("from Usuarios where lower(id)  like lower(?)");
		q.setString(0, id);
		return q.list();
	}
	
	// Deleta o usuario pelo id
		public boolean delete(Long id) {
			Usuarios c = get(id);
			delete(c);
			return true;
		}
}
