package atividadeSemana5Q2;
import java.util.ArrayList;

public class RoundRobin {

	private ArrayList<Processo> listaDeProcessos;

	public RoundRobin(ArrayList<Processo> processos) {
		this.listaDeProcessos = processos;
	}

	public ArrayList<Processo> getListaDeProcessos() {
		return listaDeProcessos;
	}

	public void setListaDeProcessos( ArrayList<Processo>  listaDeProcessos) {
		this.listaDeProcessos = listaDeProcessos;
	}

	public static void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	public void escalonar( ArrayList<Processo>  listaDeProcessos, int quantum) {
		System.out.println("__________________________________________________________");
		int tempoGasto = 0;
		while(listaDeProcessos.size() > 0) {
			for(int x = 0; x < listaDeProcessos.size();x++) {
				for(int i = x; i < listaDeProcessos.size();i++) {
					if(listaDeProcessos.get(i).getEntrada() > tempoGasto) {
						Processo proc = listaDeProcessos.get(i);
						listaDeProcessos.remove(proc);
						listaDeProcessos.add(proc);
					}
				}
			}
			Processo p = listaDeProcessos.get(0);
			if(p.getEntrada() <= tempoGasto) {
				pause(500);
				System.out.println("Realizando: PID " + p.getPid() + "| Nome: " + p.getNome());
				System.out.println("Escalonamento: Round Robin");
				System.out.println("Tempo Necessário: " + p.getTempo());
				System.out.println("/////////Apos a realização do processo durante o quantum///////");
				System.out.print("Aguardando:");

				if(p.getTempo() >= quantum) {
					tempoGasto +=quantum;
					for(int i=0; i < listaDeProcessos.size(); i++) {
						if(tempoGasto > listaDeProcessos.get(i).getEntrada()) {
							listaDeProcessos.get(i).setTurnround(quantum);
						}
					}
				}else{
					tempoGasto += p.getTempo();
					for(int i=0; i < listaDeProcessos.size(); i++) {
						if(tempoGasto > listaDeProcessos.get(i).getEntrada()) {
							listaDeProcessos.get(i).setTurnround(p.getTempo());
						}
					}
				}

				if(p.getTempo() >= quantum) {
					for(int i=1; i < listaDeProcessos.size(); i++) {
						if(tempoGasto > listaDeProcessos.get(i).getEntrada()) {
							listaDeProcessos.get(i).setEspera(quantum);
						}
					}
				}else{
					for(int i=1; i < listaDeProcessos.size(); i++) {
						if(tempoGasto > listaDeProcessos.get(i).getEntrada()) {
							listaDeProcessos.get(i).setEspera(p.getTempo());
						}
					}
				}

				if(listaDeProcessos.size()>1) {
					for(int i=1; i < listaDeProcessos.size(); i++) {
						if(tempoGasto >= listaDeProcessos.get(i).getEntrada()) {
							System.out.print(listaDeProcessos.get(i).getPid() +" " + listaDeProcessos.get(i).getNome() + "|");
						}
					}
				}

				p.setTempo(quantum);

				if(p.getTempo() > 0) {
					listaDeProcessos.remove(p);
					listaDeProcessos.add(p);
					System.out.println("\nPROCESSO NAO FINALIZADO");
					System.out.println("Tempo restante:" + p.getTempo());
				}else {
					System.out.println("\nPROCESSO FINALIZADO");
					Teste.turnround.add(p);
					listaDeProcessos.remove(p);
				}
				System.out.println("__________________________________________________________");
			}else {
				tempoGasto += quantum;
			}
		}

		for(int i = 0; i< Teste.turnround.size();i++) {
			System.out.println("Turnround de " + Teste.turnround.get(i).getPid() + " " + Teste.turnround.get(i).getNome() + ": " + Teste.turnround.get(i).getTurnround());
		}
		System.out.println("__________________________________________________________");

		float media = 0;

		for(int i = 0; i< Teste.turnround.size();i++) {
			media += Teste.turnround.get(i).getEspera();
		}
		System.out.println("Tempo Medio de Espera:" + media/(Teste.turnround.size()));
	}
}
