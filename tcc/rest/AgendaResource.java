package br.com.tcc.rest;

import java.util.ArrayList;
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

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.tcc.domain.Agenda;
import br.com.tcc.domain.AgendaService;

@Path("/agenda")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class AgendaResource {
	@Autowired
	private AgendaService agendaService;
	
	@GET
	public List<Agenda> get() {
		List<Agenda> agenda = agendaService.getAgenda();
		return agenda;
	}
	
	@POST
	@Path("/marcar/{dados}")
	public Response post(@PathParam("dados") String dados) {
		 Agenda u = new Gson().fromJson(dados, Agenda.class);
		agendaService.save(u);
		return Response.Ok("Horario salvo com sucesso");
	}

	// pegar todos horarios (Função exclusiva dos funcionarios)
	/*@GET
	@Path("/horarios/")
	public List<Agenda> get() {
		List<Agenda> horarios = agendaService.getHorarios();
		return horarios;
	}*/

	// pegar horarios por funcionario
	@GET
	@Path("/horario/nome/{nome}")
	public List<Agenda> getByNome(@PathParam("nome") String nome) {
		List<Agenda> horarios = agendaService.findByNome(nome);
		return horarios;
	}
	
	// pegar horarios por funcionario e dia
	@GET
	@Path("/horario/dia/{dados}")
	public List<Agenda> getByNomeDia(@PathParam("dados") JSONObject dados) {
		List<Agenda> horarios = agendaService.findByDiaNome(dados.getString("nome"), dados.getString("data"));
		return horarios;
	}
	
	@GET
	@Path("{idCliente}")
	public List<Agenda> getByIdCliente(@PathParam("idCliente") String idCliente) {
		List<Agenda> horarios = agendaService.findByIdCliente(idCliente);
		return horarios;
	}
	
	@GET
	@Path("/agenda/{agenda}")
	public List<Agenda> getByIdAgenda(@PathParam("agenda") String agenda) {
		List<Agenda> horarios = agendaService.findByIdAgenda(agenda);
		return horarios;
	}
	
	@POST
	public Response put(Agenda u) {
		agendaService.save(u);
		return Response.Ok("Cadastro atualizado com sucesso");
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		agendaService.delete(id);
		return Response.Ok("Horario deletado com sucesso");
	}
	
	@POST
	@Path("/setHorarioFuncionamento/{horario}")
	public boolean setHorarioFuncionamento(@PathParam("horario") JSONObject horario) {
		return agendaService.setHorarioFuncionamento(horario.get("horarioAbertura").toString(), horario.get("inicioAlmoco").toString(),
				horario.get("fimAlmoco").toString(), horario.get("horarioFechamento").toString());
	}
	
	@GET
	@Path("/getHorarioFuncionamento")
	public String getHorarioFuncionamento() {
		return agendaService.getHorarioFuncionamento();
	}
	
	// pegar horarios disponivel do funcionario
	@GET
	@Path("/horario/disponiveis")
	public List<String> horarioDisponivel(JSONObject dados){
		List<String> horarios = agendaService.horarioDisponivel(dados.getString("idFuncionario"), dados.getString("data"), dados.getString("idServico"));
		//String horarios = agendaService.horarioDisponivel("1","2016/11/07");
		return horarios;
	}
}
