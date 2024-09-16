package br.com.sistemaestacionamento.view;

import javax.swing.JOptionPane;

import br.com.sistemaestacionamento.crud.CrudEstacionamento;

public class main {

	public static void main(String[] args) {
		//Importar todas as Classes
				CrudEstacionamento crudestacionamento = new CrudEstacionamento();
				
				
				int opcao = 0;
				
				//Enquanto for diferente 9 vai ficar dentro do loop
				while(opcao != 9) {
					opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"BIBLIOTECA: Leiturinha \n\n" +
					"1: Cad. Entrada \n" + 
					"2: Lis. Entradas \n" +
					"3: Lis. Entrada por Placa \n" +
					"4: Cad. Saída \n" +
					"5: Del. Registro \n" +
					"6: Sel. Registro\n" +
					"9: Sair \n"
					));
					switch(opcao) {
						case 1:
							crudestacionamento.create();
						break;
						case 2:
							crudestacionamento.read();
						break;
						case 3:
							crudestacionamento.readone();
						break;
						case 4:
							crudestacionamento.update();
						break;
						case 5:
							crudestacionamento.delete();
						break;
						case 6:
							crudestacionamento.select();
						break;
						case 9:
							System.exit(0);
						break;
						default:
							JOptionPane.showConfirmDialog(null, 
									"Entre com uma opção válida!");
					}
				}

	}

}
