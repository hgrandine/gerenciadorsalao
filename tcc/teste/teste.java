package br.com.tcc.teste;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import br.com.tcc.dao.UsuarioDAO;
import br.com.tcc.domain.Agenda;
import br.com.tcc.domain.AgendaService;
import br.com.tcc.domain.ServicoService;
import br.com.tcc.domain.Servicos;
import br.com.tcc.domain.UsuarioService;
import br.com.tcc.domain.Usuarios;
import br.com.tcc.rest.AgendaResource;

public class teste {

	public static void main(String[] args) {

		
		
//		UsuarioService s = (UsuarioService) SpringUtil.getInstance().getBeans(UsuarioService.class);
//
//		Usuarios u = new Usuarios();
//		UsuarioService s2 = new UsuarioService();
//
//		u.setCelular("19981582651");
//		u.setConfirmaSenha("123456");
//		u.setEmail("CONSEssssssssssGUI@NOISQUEVOA.com");
//		u.setNome("");
//		u.setPermissao("CLIENTE");
//		u.setSenha("123456");
//		u.setTelefone("19981582651");
//		u.setId(null);
//
//		s.save(u);
//		System.out.println("Usuario salvo");
//		System.out.println(s.getUsuarios().get(0));
		
		ServicoService ss = (ServicoService) SpringUtil.getInstance().getBeans(ServicoService.class);
//		Servicos s = new Servicos();
//		
//		s.setDescricao("");
//		s.setNome("Corte de cabelo masculino");
//		s.setTempo("00:30");
//		s.setValor("15.00");
//		
//		ss.save(s);
//		ss.getServicos();
//		
//		ss.delete((long) 1);
		
//		AgendaService as = (AgendaService) SpringUtil.getInstance().getBeans(AgendaService.class);
//		Agenda a = new Agenda();
		
//		a.setData("2016/10/21");
//		a.setHoraInicio("12:00");
//		a.setHoraFim("16:30");
//		a.setResponsavel("hugo");
//		a.setCliente("ze");
//		a.setServico("cortar cabelo");
//		a.setStatus(true);
//		
//		as.save(a);
//		System.out.println(as.findByNome("hugo"));
//		System.out.println(as.findByDiaNome("3", "2016/11/22"));
		
		AgendaResource as = (AgendaResource) SpringUtil.getInstance().getBeans(AgendaResource.class);
//		Agenda agenda = new Agenda();
//		agenda.setCliente(1);
//		agenda.setData("2016/11/06");
//		agenda.setHora_inicio("23:00");
//		agenda.setHora_fim("23:30");
//		agenda.setResponsavel(1);
//		agenda.setServico(1);
//		agenda.setStatus("AGENDADO");
//		String u = new Gson().toJson(agenda, Agenda.class);
//		as.post(u);
		
		JSONObject dados = new JSONObject();
		dados.put("idFuncionario", "1");
		dados.put("data", "2016/11/13");
		dados.put("idServico", "2 ");
		System.out.println(as.horarioDisponivel(dados).toString());
		
//		System.out.println(ss.findById("2").get(0).getTempo().toString());
		
	}

}
