package br.com.tcc.domain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.tcc.dao.UsuarioDAO;

@Component
public class UsuarioService {

	@Autowired
	private UsuarioDAO db;

	// Salva ou atualiza o usuarios
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Usuarios usuarios) {
		db.saveOrUpdate(usuarios);
		return true;
	}
	public boolean update(Usuarios usuarios) {
		db.update(usuarios);
		return true;
	}
	// Lista todos os usuarios do banco de dados
	public List<Usuarios> getUsuarios() {
		List<Usuarios> usuarios = db.getUsuarios();
		return usuarios;
	}
	
	public List<Usuarios> getFuncionarios() {
		List<Usuarios> usuarios = db.getFuncionarios();
		return usuarios;
	}
	
	//busca usuario pelo email
	public List<Usuarios> findByEmail(String email){
			return db.findByEmail(email);
	}
	//busca usuario pelo nome ou parte dele
	public List<Usuarios> findByNome(String nome){
		return db.findByNome(nome);
	}
	//busca usuario por telefone
	public List<Usuarios> findByTelefone(String telefone){
		return db.findByTelefone(telefone);
	}
	
		//busca usuario pelo email
		public List<Usuarios> findByEmail2(String email){
				return db.findByEmail2(email);
		}
		//busca usuario pelo nome ou parte dele
		public List<Usuarios> findByNome2(String nome){
			return db.findByNome2(nome);
		}
		//busca usuario por telefone
		public List<Usuarios> findByTelefone2(String telefone){
			return db.findByTelefone2(telefone);
		}
	
	//busca usuario pelo id
	public List<Usuarios> findById(String id){
		return db.findById(id);
	}
	//deleta usuario pelo id
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(Long id){
		return db.delete(id);
	}
	@Transactional(rollbackFor = Exception.class)
	public boolean novaSenha(String email) {
		List<Usuarios> u = db.findByEmail(email);
		util enviar = new util();
		
		if (u.size() > 0) {
			UUID uuid = UUID.randomUUID();
			String myRandom = uuid.toString();
			u.get(0).setSenha(criptografiaMD5(myRandom.substring(0, 6)));
			db.save(u.get(0));
			enviar.sendEmail(email, myRandom.substring(0, 6));			
			return true;
		} else {
			return false;
		}
		
	}
	
	private String criptografiaMD5(String valor) { 
		MessageDigest mDigest; 			
		try { 
			mDigest = MessageDigest.getInstance("MD5"); 
			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8")); 
			StringBuffer sb = new StringBuffer(); 
			for (byte b : valorMD5){ 
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3)); 
				} 
			return sb.toString(); 
		} 
		catch (NoSuchAlgorithmException e) { 
			e.printStackTrace(); 
			return null; 
		} 
		catch (UnsupportedEncodingException e) { 
			e.printStackTrace(); 
			return null; 
		} 
	}
}
