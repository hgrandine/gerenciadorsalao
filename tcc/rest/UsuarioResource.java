package br.com.tcc.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tcc.domain.UsuarioService;
import br.com.tcc.domain.Usuarios;

@Path("/cadastro")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class UsuarioResource {
	@Autowired
	private UsuarioService usuarioService;
	
	@POST
	public Response post(Usuarios u) {
		usuarioService.save(u);
		return Response.Ok("Cadastro salvo com sucesso");
	}

	@PUT
	public Response put(Usuarios u) {
		usuarioService.save(u);
		return Response.Ok("Cadastro atualizado com sucesso");
	}
	
	@PUT
	@Path("/esqueci/{email}")
	public Response putNewSenha(@PathParam("email") String email) {
		usuarioService.novaSenha(email);
		return Response.Ok("Cadastro atualizado com sucesso");
	}
	
	@GET
	public List<Usuarios> get() {
		List<Usuarios> usuarios = usuarioService.getUsuarios();
		return usuarios;
	}
	
	@GET
	@Path("/funcionarios")
	public List<Usuarios> getFunc() {
		List<Usuarios> usuarios = usuarioService.getFuncionarios();
		return usuarios;
	}
	
	@GET
	@Path("/email/{email}")
	public List<Usuarios> getByEmail(@PathParam("email") String email) {
		List<Usuarios> usuarios = usuarioService.findByEmail(email);
		return usuarios;
	}
	
	@GET
	@Path("/nome/{nome}")
	public List<Usuarios> getByNome(@PathParam("nome") String nome) {
		List<Usuarios> usuarios = usuarioService.findByNome(nome);
		return usuarios;
	}
	
	@GET
	@Path("/telefone/{telefone}")
	public List<Usuarios> getByTelefone(@PathParam("telefone") String telefone) {
		List<Usuarios> usuarios = usuarioService.findByTelefone(telefone);
		return usuarios;
	}
	
	@GET
	@Path("/email/gerente/{email}")
	public List<Usuarios> getByEmail2(@PathParam("email") String email) {
		List<Usuarios> usuarios = usuarioService.findByEmail2(email);
		return usuarios;
	}
	
	@GET
	@Path("/nome/gerente/{nome}")
	public List<Usuarios> getByNome2(@PathParam("nome") String nome) {
		List<Usuarios> usuarios = usuarioService.findByNome2(nome);
		return usuarios;
	}
	
	@GET
	@Path("/telefone/gerente/{telefone}")
	public List<Usuarios> getByTelefone2(@PathParam("telefone") String telefone) {
		List<Usuarios> usuarios = usuarioService.findByTelefone2(telefone);
		return usuarios;
	}
	
	
	@GET
	@Path("{id}")
	public List<Usuarios> getById(@PathParam("id") String id) {
		List<Usuarios> usuarios = usuarioService.findById(id);
		return usuarios;
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		usuarioService.delete(id);
		return Response.Ok("Usuario deletado com sucesso");
	}
}
