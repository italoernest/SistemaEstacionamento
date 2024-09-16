package br.com.sistemaestacionamento.crud;

import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.sistemaestacionamento.jdbc.ConnectionFactory;
import br.com.sistemaestacionamento.model.Estacionamento;

public class CrudEstacionamento {
	public static void create() {
		try {
			//Importa a classe de conexão com o banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//Importa a classe de transição de dados no sql
			Estacionamento estacionamento = new Estacionamento();
			
			//Envia o dado para a classe Estacionamento()
			estacionamento.setPlaca(JOptionPane.showInputDialog("Entre com a Placa do Veículo"));
			Double valor = 0.00;
			estacionamento.setValor(valor);
			
			//Criar o SQL para inserir dados no banco
			String sql = "INSERT INTO estacione( placa,valor) VALUES (?,?);";
			
			//Criando um comando para passar o SQL
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, estacionamento.getPlaca());
			cmd.setDouble(2, estacionamento.getValor());
			
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Entrada registada com sucesso!");
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void read() {
		try {
			//Importa a classe de conexão com o banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//Importa a classe de transição de dados no sql
			Estacionamento estacionamento = new Estacionamento();
			
			//Criar o SQL para buscar todos os dados no banco
			String sql = "select * from estacione;";
			
			//Criando um comando para passar o SQL
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			ResultSet resultado = cmd.executeQuery();
			
			String estacionados;
			
			estacionados = "<<Estacionamento encontrados>>\n\n";
			
			while(resultado.next()) {
				String saida = "---";
				String status = "-";
				
				if(resultado.getInt("status")==0) {
					status = "Estacionado";
				}else {
					status = "---";
				}
				
				if(resultado.getString("saida")==null || resultado.getString("saida")=="")
				{
					saida = "0000-00-00 00:00:00";
				}else {
					saida = resultado.getString("saida");
				}
				
				estacionados += "ID: " + resultado.getInt("idestacione")
				+ " - PLACA: " + resultado.getString("placa")
				+ " - ENTRADA: " + resultado.getString("entrada")
				+ " - SAIDA: " + saida
				+ " - VALOR: " + resultado.getString("valor")				
				+ " - STATUS: " + status
				+ "\n -------------------------------------- \n"; 
			}
			
			
			JOptionPane.showMessageDialog(null, estacionados);
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void readone() {
		try {
			//Importa a classe de conexão com o banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//Importa a classe de transição de dados no sql
			Estacionamento estacionamento = new Estacionamento();
			
			estacionamento.setId(Integer.parseInt(JOptionPane.showInputDialog("Entre com a Código")));
			
			//Criar o SQL para buscar todos os dados no banco
			String sql = "select * from estacione where idestacione = ?;;";
			
			//Criando um comando para passar o SQL
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, estacionamento.getPlaca());
			
			ResultSet resultado = cmd.executeQuery();
			
			String estacionados;
			
			estacionados = "<<Estacionamento encontrados>>\n\n";
			
			while(resultado.next()) {
				String saida = "---";
				String status = "-";
				
				if(resultado.getInt("status")==0) {
					status = "Estacionado";
				}else {
					status = "---";
				}
				
				if(resultado.getString("saida")==null || resultado.getString("saida")=="")
				{
					saida = "0000-00-00 00:00:00";
				}else {
					saida = resultado.getString("saida");
				}
				
				estacionados += "ID: " + resultado.getInt("idestacione")
				+ "\n"
				+ "\n   PLACA: " + resultado.getString("placa")
				+ "\n   ENTRADA: " + resultado.getString("entrada")
				+ "\n   SAIDA: " + saida
				+ "\n   VALOR: " + resultado.getString("valor")				
				+ "\n   STATUS: " + status
				+ "\n -------------------------------------- \n"; 
			}
			
			
			JOptionPane.showMessageDialog(null, estacionados);
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void update() {
		try {
			//Importa a classe de conexão com o banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//Importa a classe de transição de dados no sql
			Estacionamento estacionamento = new Estacionamento();
			
			estacionamento.setId(Integer.parseInt(JOptionPane.showInputDialog("Entre com a Código")));
			
			int status = 1;
	        int opcao = JOptionPane.showConfirmDialog(
	                null,
	                "Você deseja registar a saída?",
	                "Escolha uma opção",
	                JOptionPane.YES_NO_OPTION);
	        System.out.print(opcao);
	        
			if(opcao == 0) {
				//Criar o SQL para buscar todos os dados no banco
				String sql = "UPDATE estacione SET status=? WHERE idestacione=?;";
				
				//Criando um comando para passar o SQL
				PreparedStatement cmd = conexao.prepareStatement(sql);
				cmd.setInt(1, status);
				cmd.setString(2, estacionamento.getPlaca());
				
				cmd.executeUpdate();
				JOptionPane.showMessageDialog(null, "Saída registrada com sucesso!");
				cmd.close();
			}else {
				//Criar o SQL para buscar todos os dados no banco
				String sql = "select * from estacione where idestacione = ?;;";
				
				//Criando um comando para passar o SQL
				PreparedStatement cmd = conexao.prepareStatement(sql);
				cmd.setString(1, estacionamento.getPlaca());
				
				ResultSet resultado = cmd.executeQuery();
				
				JOptionPane.showMessageDialog(null, "Saída não foi registrada!");
				cmd.close();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void delete() {
		try {
			//Abrir conexao
			Connection conexao = ConnectionFactory.createConnection();
			
			//Importa a classe de transição de dados no sql
			Estacionamento estacionamento = new Estacionamento();
			
			estacionamento.setId(Integer.parseInt(JOptionPane.showInputDialog("Entre com a Código")));
			
			//Sql para apagar o registro
			String sql = "delete from estacione where idestacione = ?;";
			
			//Criar comando para mandar um comando para o SQL no banco
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setInt(1, estacionamento.getId());
			
			//executar o comando
			cmd.execute();
			
			//Caso der certo vou imprimir uma mensagem
			JOptionPane.showMessageDialog(null, "Estacionamento deletado com sucesso!");
			//Fechar conexao
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void select() {
		try {
			//Abrir conexao
			Connection conexao = ConnectionFactory.createConnection();
			
			//Importa a classe de transição de dados no sql
			Estacionamento estacionamento = new Estacionamento();
			
			String sql = "select idestacione, placa from estacione;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			ResultSet resultado = cmd.executeQuery();
			
			Map<String, Integer> mapaEstaciones = new HashMap<>();
			ArrayList<String> listaPlacas = new ArrayList<>();
			
			while(resultado.next()) {
				int placaId = resultado.getInt("idestacione");
				String placa = resultado.getString("placa");
				
				listaPlacas.add(placa);
				mapaEstaciones.put(placa, placaId);
			}
			
			String[] placasArray = listaPlacas.toArray(new String[0]);
			
			String placaSelecionada = (String) JOptionPane.showInputDialog(
					null,
					"Selecione a placa: ",
					"Seleção de Placa",
					JOptionPane.QUESTION_MESSAGE,
					null,
					placasArray,
					placasArray[0]
			);
			
			if(placaSelecionada != null) {
				int placaIdSelecionada  = mapaEstaciones.get(placaSelecionada);
				
				JOptionPane.showMessageDialog(null, 
						"Você selecionou a placa: " + 
						placaSelecionada + 
						"\nID da placa: " + placaIdSelecionada);
				
				int idPlaca = 2;
				String sqlselect = "select * from estacione where idestacione = ?";
				
				//Criando um comando para passar o SQL
				PreparedStatement cmd1 = conexao.prepareStatement(sqlselect);
				cmd1.setInt(1, idPlaca);
				
				ResultSet resultado1 = cmd1.executeQuery();
				while(resultado1.next()) {
					System.out.println(resultado1.getInt("idestacione"));
					System.out.println(resultado1.getString("placa"));
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Nenhuma placa selecionada");
			}
			
		} catch (Exception e) {
			
		}
	}
}
