package atividadeSemana5Q2;
import java.util.ArrayList;

public class Prioridade {

	private ArrayList<Processo> listaDeProcessos;

	public Prioridade(ArrayList<Processo> listaDeProcessos) {
		super();
		this.listaDeProcessos = listaDeProcessos;
	}

	public ArrayList<Processo> getListaDeProcessos() {
		return listaDeProcessos;
	}

	public void setListaDeProcessos(ArrayList<Processo> listaDeProcessos) {
		this.listaDeProcessos = listaDeProcessos;
	}

	public static void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	//Verifica novamente a lista para saber se existe algum processo que deva entrar no clock atual
	public boolean entraNovo (ArrayList<Processo> listaDeProcessos, int pid, int clock) {
		for(int i = 0; i < listaDeProcessos.size(); i++) {
			Processo p = listaDeProcessos.get(i);
			//Se o processo mais prioritário for o que está sendo executado, mantém-se o mesmo
			if(p.getPid() == pid) {
				return false;
			}
			//Se por acaso achou algum outro processo mais prioritário que deve entrar no clock atual
			else if(p.getEntrada() <= clock){
				return true;
			}


		}
		return false;

	}

	public void escalonar(ArrayList<Processo>  listaDeProcessos) {

		System.out.println("__________________________________________________________");
		int clock = 0;

		//Programa rodando enquanto a lista tiver processos
		while(listaDeProcessos.size() > 0) {


			listaDeProcessos.sort(new OrdenarPrioridade());


			//Flags para controle de execução
			boolean sairDoFor = false;
			boolean encontrou = false;

			//Rodar a lista que ja esta ordenada por prioridade
			//Muda o processo

			for(int i = 0; i< listaDeProcessos.size(); i++) {
				//Sair do for significa checar a lista do começo para caso haja um novo processo de maior prioridade no clock atual
				if(sairDoFor)
				{
					sairDoFor = false;
					break;
				}

				Processo p = listaDeProcessos.get(i);
				//While roda quando se encontra um processo que esteja programado para iniciar no clock atual
				//Processa o processo
				while(p.getEntrada() <= clock) {
					encontrou = true;
					pause(500);
					System.out.println("\nClock atual: "+clock);
					System.out.println("__________________________________________________________");
					System.out.println("Realizando: PID " + p.getPid() + "| Nome: " + p.getNome());
					System.out.println("Escalonamento: Prioridade");
					System.out.println("Tempo Necessário: " + p.getTempo());
					System.out.println("/////////Após a realização do processo durante o quantum///////");
					System.out.print("Aguardando: ");
					p.setTempo(1);
					clock += 1;

					//Somar o turnaround dos processos que já entraram
					//Dar o tempo total que o processo passou desde que entrou até sua saída
					for(int j=0; j < listaDeProcessos.size(); j++) {
						if(clock > listaDeProcessos.get(j).getEntrada()) {
							listaDeProcessos.get(j).setTurnround(1);
						}
					}


					//Somar a quantidade que o processo fica esperando a partir do tempo de entrada dele. 
					for(int j=0; j < listaDeProcessos.size(); j++) {
						if(!p.equals(listaDeProcessos.get(j))) {
							if(clock > listaDeProcessos.get(j).getEntrada()) {
								listaDeProcessos.get(j).setEspera(1);
							}
						}
						
					}
					
					if(listaDeProcessos.size()>1) {
						for(int j=1; j < listaDeProcessos.size(); j++) {
							if(clock >= listaDeProcessos.get(j).getEntrada()) {
								System.out.print(listaDeProcessos.get(j).getPid() +" " + listaDeProcessos.get(j).getNome() + "|");
							}
						}
					}

					//Checa se um novo processo deve ser executado no clock atual, se sim sai do for
					if(entraNovo(listaDeProcessos, p.getPid(), clock)) {
						sairDoFor = true;
						break;

					}

					//Um processo terminou, deve-se sair do while e do for para rodar outro processo
					if(p.getTempo() == 0)
					{
						Teste.turnround.add(p);
						listaDeProcessos.remove(p);
						System.out.println("\nPROCESSO FINALIZADO");
						sairDoFor = true;
						break;
					}
					else {
						System.out.println("\nPROCESSO NAO FINALIZADO");
						System.out.println("Tempo restante:" + p.getTempo());
					}

				}

			}
			//Se não encontrou um processo programado para iniciar no clock atual
			// E se não foi pedido pra sair do for, ou seja, se não encontrou outro processo para entrar por prioridade
			//Adianta o clock em 1
			if(!encontrou && !sairDoFor)
			{
				clock+=1;

			}

		}


		for(int i = 0; i< Teste.turnround.size();i++) {
			System.out.println("\n__________________________________________________________\nTurnround de " + Teste.turnround.get(i).getPid() + " " + Teste.turnround.get(i).getNome() + ": " + Teste.turnround.get(i).getTurnround());
		}
		System.out.println("__________________________________________________________");

		float media = 0;

		for(int i = 0; i< Teste.turnround.size();i++) {
			media += Teste.turnround.get(i).getEspera();
		}
		System.out.println("Tempo Médio de Espera:" + media/(Teste.turnround.size()));


	}
}
