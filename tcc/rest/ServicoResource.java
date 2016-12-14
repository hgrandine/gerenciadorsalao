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

import br.com.tcc.domain.ServicoService;
import br.com.tcc.domain.Servicos;

@Path("/cadastro/servico")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class ServicoResource {
	@Autowired
	private ServicoService servicoService;
	
	@POST
	public Response post(Servicos u) {
		servicoService.save(u);
		return Response.Ok("Cadastro salvo com sucesso");
	}

	@PUT
	public Response put(Servicos u) {
		servicoService.save(u);
		return Response.Ok("Cadastro atualizado com sucesso");
	}
	
	@GET
	public List<Servicos> get() {
		List<Servicos> servicos = servicoService.getServicos();
		return servicos;
	}
	
	@GET
	@Path("/nome/{nome}")
	public List<Servicos> getByNome(@PathParam("nome") String nome) {
		List<Servicos> servicos = servicoService.findByNome(nome);
		return servicos;
	}
	
	@GET
	@Path("{id}")
	public List<Servicos> getById(@PathParam("id") String id) {
		List<Servicos> servicos = servicoService.findById(id);
		return servicos;
	}
	
	@GET
	@Path("/tipo/{tipo}")
	public List<Servicos> getByTipo(@PathParam("tipo") String tipo) {
		List<Servicos> servicos = servicoService.findByTipo(tipo);
		return servicos;
	}
	
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		servicoService.delete(id);
		return Response.Ok("Serviço deletado com sucesso");
	}
}
