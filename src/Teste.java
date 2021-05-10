import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
	
	public static ArrayList<Processo> turnround = new ArrayList();
	
	public static void main(String [] args){ 
		//Processo processo1 = new Processo(120,"Diego","CPU",1,0);
		//Processo processo2 = new Processo(130,"Daniel","CPU",5,0);
		//Processo processo3 = new Processo(140,"Wei","CPU",4,4);
		//Processo processo4 = new Processo(150,"Joao","CPU",2,4);
		//Processo processo5 = new Processo(160,"Rosa","CPU",1,1);
		
		ArrayList<Processo> processos = new ArrayList();
	    //processos.add(processo1);
		//processos.add(processo2);
        //processos.add(processo3);
	    //processos.add(processo4);
	    //processos.add(processo5);
		
		Scanner sc = new Scanner(System.in);
		
		
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
			System.out.println("Qual o tempo para realização do Processo #" + (i+1) + "?");
			tempo = sc.nextInt();
			System.out.println("Qual o tempo para entrada do Processo #" + (i+1) + "?");
			entrada = sc.nextInt();
			Processo pr = new Processo(pid,nome,typeName,tempo,entrada);
			processos.add(pr);
		}
		RoundRobin rr = new RoundRobin(processos);
		rr.escalonar(processos,quantum);
		
		sc.close();
	}
}
