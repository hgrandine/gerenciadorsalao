package br.com.tcc.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.tcc.dao.ServicoDAO;

@Component
public class ServicoService {

	@Autowired
	private ServicoDAO db;

	// Salva ou atualiza o usuarios
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Servicos servicos) {
		db.saveOrUpdate(servicos);
		return true;
	} 

	// Lista todos os usuarios do banco de dados
	public List<Servicos> getServicos() {
		List<Servicos> servicos = db.getServicos();
		return servicos;
	}
	
	//busca usuario pelo nome	
	public List<Servicos> findByNome(String nome){
		return db.findByNome(nome);
	}
	public List<Servicos> findById(String id){
		return db.findById(id);
	}
	public List<Servicos> findByTipo(String tipo){
		return db.findByTipo(tipo);
	}
	
	//deleta usuario pelo id
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(Long id){
		return db.delete(id);
	}
}
