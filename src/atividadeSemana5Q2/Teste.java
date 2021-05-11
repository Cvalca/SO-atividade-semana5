package atividadeSemana5Q2;
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

	public static ArrayList<Processo> turnround = new ArrayList<Processo>();

	public static void main(String [] args){ 


		ArrayList<Processo> processos = new ArrayList<Processo>();


		Scanner sc = new Scanner(System.in);

		System.out.println("BIP BOP!!!\nSistema de Escalonamento Preemptivo de processos:\n\nEscolha qual o algoritmo de escalonamento você quer usar:\n1.Round Robin\n2.Prioridade\nDigite sua opcao: ");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1: {
			System.out.println("------------------------------------------------------\nVoce escolheu Round Robin!");
			System.out.println("Escolha o Quantum:");
			int quantum = sc.nextInt();
			System.out.println("Quantos processos vão ser executados?");
			int qnt = sc.nextInt();
			int pid;
			String nome;
			int tipo;
			String typeName;
			int tempo;
			int entrada;
			int prioridade;
			for(int i = 0; i<qnt; i++) {
				System.out.println("Qual o PID do Processo #"+ (i+1) +"?");
				pid = sc.nextInt();
				System.out.println("Qual o nome do Processo #"+ (i+1) +"?");
				nome = sc.next();
				System.out.println("Qual o tipo do Processo #"+ (i+1) + "? Digite 1 para CPU e 2 para I/O");
				tipo = sc.nextInt();
				if(tipo == 1) {
					typeName = "CPU/Bound";
				}else {
					typeName = "I/O Bound";
				}
				System.out.println("Qual o tempo para realizacao do Processo #" + (i+1) + "?");
				tempo = sc.nextInt();
				System.out.println("Qual o tempo para entrada do Processo #" + (i+1) + "?");
				entrada = sc.nextInt();

				Processo pr = new Processo(pid,nome,typeName,tempo,entrada);
				processos.add(pr);
			}
			
			RoundRobin rr = new RoundRobin(processos);
			rr.escalonar(processos,quantum);
			
			break;
		}
		case 2: {
			
			System.out.println("------------------------------------------------------\nVoce escolheu Prioridade Preemptiva!");
			System.out.println("Quantos processos vão ser executados?");
			int qnt = sc.nextInt();
			int pid;
			String nome;
			int tipo;
			String typeName;
			int tempo;
			int entrada;
			int prioridade;
			for(int i = 0; i<qnt; i++) {
				System.out.println("Qual o PID do Processo #"+ (i+1) +"?");
				pid = sc.nextInt();
				System.out.println("Qual o nome do Processo #"+ (i+1) +"?");
				nome = sc.next();
				System.out.println("Qual o tipo do Processo #"+ (i+1) + "? Digite 1 para CPU e 2 para I/O");
				tipo = sc.nextInt();
				if(tipo == 1) {
					typeName = "CPU/Bound";
				}else {
					typeName = "I/O Bound";
				}
				System.out.println("Qual o tempo para realizacao do Processo #" + (i+1) + "?");
				tempo = sc.nextInt();
				System.out.println("Qual o tempo para entrada do Processo #" + (i+1) + "?");
				entrada = sc.nextInt();
				System.out.println("Qual a prioridade do Processo #" + (i+1) + "?");
				prioridade = sc.nextInt();
				
				Processo pr = new Processo(pid,nome,typeName,tempo,entrada, prioridade);
				processos.add(pr);
			}
			
			
			Prioridade p = new Prioridade (processos);
			p.escalonar(processos);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcao);
		}


		
		

		sc.close();
	}
}
