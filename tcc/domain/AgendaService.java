package br.com.tcc.domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.tcc.dao.AgendaDAO;

@Component
public class AgendaService {

	@Autowired
	private AgendaDAO db;

	// Salva ou atualiza o horario
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Agenda horario) {
		db.saveOrUpdate(horario);
		return true;
	}

	public List<Agenda> findByIdCliente(String idCliente) {
		return db.findByIdCliente(idCliente);
	}

	public List<Agenda> findByIdAgenda(String agenda) {
		return db.findByIdAgenda(agenda);
	}

	// Lista todos os horarios marcados do banco de dados
	public List<Agenda> getAgenda() {
		List<Agenda> agenda = db.getAgenda();
		return agenda;
	}

	// Lista todos os horarios do banco de dados
	public List<Agenda> getHorarios() {
		List<Agenda> horarios = db.getHorarios();
		return horarios;
	}

	// busca agenda pelo nome
	public List<Agenda> findByNome(String nome) {
		return db.findByResponsavel(nome);
	}

	// busca agenda pelo nome e dia
	public List<Agenda> findByDiaNome(String nome, String data) {
		return db.findByDiaNome(nome, data);
	}

	// deleta horario pelo id
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Long id) {
		return db.delete(id);
	}

	// incluir/atualizar horario de funcionamento
	public boolean setHorarioFuncionamento(String horarioAbertura, String inicioAlmoco, String fimAlmoco,
			String horarioFechamento) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src//main//resources//conexao.properties");
			// load a properties file
			prop.load(input);

			prop.replace("horario.abertura", "08:00:00");
			prop.setProperty("horario.inicio.almoco", "12:00:00");
			prop.setProperty("horario.fim.almoco", "13:00:00");
			prop.setProperty("horario.fechamento", "17:00:00");
			OutputStream out = new FileOutputStream("src//main//resources//conexao.properties");
			prop.store(out, null);

			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// pega os horarios funcionamento
	public String getHorarioFuncionamento() {
		Properties prop = new Properties();
		InputStream input = null;
		JSONObject horario = new JSONObject();
		;
		try {
			input = new FileInputStream("src//main//resources//conexao.properties");
			// load a properties file
			prop.load(input);
			horario.put("horarioAbertura", prop.getProperty("horario.abertura"));
			horario.put("inicioAlmoco", prop.getProperty("horario.inicio.almoco"));
			horario.put("fimAlmoco", prop.getProperty("horario.fim.almoco"));
			horario.put("horarioFechamento", prop.getProperty("horario.fechamento"));

			return horario.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			horario.put("erro", true);
			return horario.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			horario.put("erro", true);
			return horario.toString();
		}
	}

	// retorna horario disponivel
	@SuppressWarnings({ "null" })
	public ArrayList<String> horarioDisponivel(String idFuncionario, String data, String idServico) {
		Properties prop = new Properties();
		InputStream input = null;
		ArrayList<String> horarioLivre = new ArrayList<String>();
		JSONObject horarioOcupado = new JSONObject();
		Calendar cal = Calendar.getInstance();
		ServicoService servico = new ServicoService();
		ArrayList<String> horarioDisponivel = null;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		String j = null;
		
		String tempoServiço = servico.findById(idServico).get(0).getTempo().toString();
		try {
			input = new FileInputStream("src//main//resources//conexao.properties");
			// load a properties file
			prop.load(input);
			String inicio = prop.getProperty("horario.abertura");
			String inicioAlmoco = prop.getProperty("horario.inicio.almoco");
			String fimAlmoco = prop.getProperty("horario.fim.almoco");
			String fim = prop.getProperty("horario.fechamento");
			
			j = inicio;
			// listar os horarios marcados
			List<Agenda> a = db.findByDiaNome(idFuncionario, data);
			
			//mapeia os horarios ocupados
			do {
				for (int i = 0; i < a.size(); i++) {
					if (Integer.parseInt(j.replaceAll(":", "")) >= Integer
							.parseInt(a.get(i).getHora_inicio().replaceAll(":", ""))) {
						if (Integer.parseInt(j.replaceAll(":", "")) < Integer
								.parseInt(a.get(i).getHora_fim().replaceAll(":", ""))) {
							horarioOcupado.put(j, true);
						} else if ((Integer.parseInt(j.replaceAll(":", "")) >= Integer
								.parseInt(inicioAlmoco.replaceAll(":", "")))) {
							if ((Integer.parseInt(j.replaceAll(":", "")) < Integer
									.parseInt(fimAlmoco.replaceAll(":", "")))) {
								horarioOcupado.put(j, true);
							}
						} else {

						}
					}

				}
				cal.setTime(format.parse(j));
				cal.add(Calendar.MINUTE, 30);
				j = cal.getTime().toString().substring(11, 19);
			} while (Integer.parseInt(j.replaceAll(":", "")) < Integer.parseInt(fim.replaceAll(":", "")));

			//com base nos horarios ocupados, devolve os horarios livres
			j = inicio;
			do {
				try {
					if (horarioOcupado.get(j).equals(true)) {
					} else {
					}
				} catch (Exception e) {
					horarioLivre.add(j);
				}
				cal.setTime(format.parse(j));
				cal.add(Calendar.MINUTE, 30);
				j = cal.getTime().toString().substring(11, 19);
			} while (Integer.parseInt(j.replaceAll(":", "")) < Integer.parseInt(fim.replaceAll(":", "")));
			
			System.out.println("Até aqui blz");
			
			//compara o servico solicitado com os horarios disponiveis, devolve os horários em que o serviço pode ser realizado
			try{
				
				int intervalo = 0;
				for(int p=0;p<=horarioLivre.size();p++){
					System.out.println(p+"vez");
					if(p == horarioLivre.size()){
						if(tempoServiço.replaceAll(":", "") == "00:30:00".replaceAll(":", "")){
							System.out.println("ultimo tempo");
							horarioDisponivel.add(horarioLivre.get(p));
							System.out.println(horarioLivre.get(p));
						}
					}else{
						System.out.println("não é o ultimo tempo");
						intervalo = Integer.parseInt(horarioLivre.get(p).replaceAll(":", ""))-Integer.parseInt(horarioLivre.get(p+1).replaceAll(":", ""));
						System.out.println(intervalo);
						if(Integer.parseInt(tempoServiço.replaceAll(":", "")) <= intervalo){
							horarioDisponivel.add(horarioLivre.get(p));
						}
					}
				}
			}catch(Exception e){
				System.out.println("moio");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return horarioDisponivel;
	}
}
